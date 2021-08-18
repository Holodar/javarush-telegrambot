package com.github.holodar.jrtb.bot;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.springframework.beans.factory.annotation.Value;
import com.github.holodar.jrtb.command.CommandContainer;
import com.github.holodar.jrtb.service.SendBotMessageServiceImpl;

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

    public JavaRushTelegramBot(){
        this.commandContainer = new CommandContainer(new SendBotMessageServiceImpl(this));
    }


    @Override
    public void onUpdateReceived(Update update){
        if(update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText().trim();
            if(message.startsWith(COMMAND_PREFIX)){
                String commandIdentifier = message.split(" ")[0].toLowerCase();

                commandContainer.retriveCommand(commandIdentifier).execute(update);
            }else {
                commandContainer.retriveCommand(NO.getCommandName()).execute(update);
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
}
