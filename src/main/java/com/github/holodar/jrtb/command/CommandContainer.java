package com.github.holodar.jrtb.command;

import com.github.holodar.jrtb.service.SendBotMessageService;
import com.google.common.collect.ImmutableMap;

import java.nio.ByteBuffer;

import static com.github.holodar.jrtb.command.CommandName.*;


public class CommandContainer {

    private final ImmutableMap<String,Command> commandMap;
    private final Command unknownCommand;

    public CommandContainer(SendBotMessageService sendBotMessageService){

        commandMap = ImmutableMap.<String,Command >builder()
                .put(START.getCommandName(),new StartCommand(sendBotMessageService))
                .put(STOP.getCommandName(), new StopCommand(sendBotMessageService))
                .put(HELP.getCommandName(), new HelpCommand(sendBotMessageService))
                .put(NO.getCommandName(), new NoCommand(sendBotMessageService))
                .build();
        unknownCommand = new UnknownCommand(sendBotMessageService);
    }

    public Command retriveCommand(String commandIdentifier){
        return commandMap.getOrDefault(commandIdentifier,unknownCommand);
    }
}
