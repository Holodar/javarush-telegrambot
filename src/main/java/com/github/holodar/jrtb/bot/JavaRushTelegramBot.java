package com.github.holodar.jrtb.bot;

import com.github.holodar.jrtb.javarushclient.JavaRushGroupClient;
import com.github.holodar.jrtb.service.GroupSubService;
import com.github.holodar.jrtb.service.TelegramUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.springframework.beans.factory.annotation.Value;
import com.github.holodar.jrtb.command.CommandContainer;
import com.github.holodar.jrtb.service.SendBotMessageServiceImpl;

import java.util.List;
import java.util.Locale;

import static com.github.holodar.jrtb.command.CommandName.NO;

@Component
public class JavaRushTelegramBot extends TelegramLongPollingBot{

    public static String COMMAND_PREFIX = "/";

    @Value("${bot.username}")
    private String username;

    @Value("${bot.token}")
    private String token;

    private final CommandContainer commandContainer;

    @Override
    public void onUpdateReceived(Update update){
        if(update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText().trim();
            if(message.startsWith(COMMAND_PREFIX)){
                String commandIdentifier = message.split(" ")[0].toLowerCase();

                commandContainer.retrieveCommand(commandIdentifier).execute(update);
            }else {
                commandContainer.retrieveCommand(NO.getCommandName()).execute(update);
            }
        }
    }

    @Override
    public String getBotUsername(){
        return username;
    }

    @Override
    public String getBotToken(){
        return token;
    }

    @Autowired
    public JavarushTelegramBot(TelegramUserService telegramUserService, JavaRushGroupClient groupClient, GroupSubService groupSubService,
                               @Value("#{'${bot.admins}'.split(',')}") List<String> admins) {
        this.commandContainer =
                new CommandContainer(new SendBotMessageServiceImpl(this),
                        telegramUserService, groupClient, groupSubService, admins);
    }
}
