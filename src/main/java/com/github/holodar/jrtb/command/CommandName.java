package com.github.holodar.jrtb.command;

public enum CommandName {
    START("/start"),
    STOP ("/stop"),
    NO(""),
    HELP("/help");

    private final String commandName;

    CommandName(String commandName){
        this.commandName = commandName;
    }
    public String getCommandName(){
        return commandName;
    }
}
