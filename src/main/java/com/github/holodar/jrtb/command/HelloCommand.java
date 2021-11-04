package com.github.holodar.jrtb.command;

import com.github.holodar.jrtb.service.SendBotMessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.meta.api.objects.Update;



import static com.github.holodar.jrtb.command.CommandUtils.getChatId;

/**
 * Hello {@link Command}.
 */
public class HelloCommand implements Command {

    private static Logger logger = LoggerFactory.getLogger(HelloCommand.class);

    private final SendBotMessageService sendBotMessageService;

    public static final String HELLO_MASSAGE = "Приветствую тебя, Я твой телеграмм бот \uD83D\uDD25";

    public HelloCommand(SendBotMessageService sendBotMessageService){
        this.sendBotMessageService = sendBotMessageService;
    }
    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(getChatId(update),HELLO_MASSAGE);
        logger.info("Command hello Worked out");
    }
}
