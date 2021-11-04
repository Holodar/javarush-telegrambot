package com.github.holodar.jrtb.command;

public enum CommandName {
    START("/start"),
    STOP ("/stop"),
    HELP("/help"),
    ADMIN_HELP("/ahelp"),
    STAT("/stat"),
    NO("nocommand"),
    ADD_GROUP_SUB("/addgroupsub"),
    DELETE_GROUP_SUB("/deletegroupsub"),
    LIST_GROUP_SUB("/listgroupsub"),
    HELLO_COMMAND("/hello");


    private final String commandName;

    CommandName(String commandName){
        this.commandName = commandName;
    }

    public String getCommandName(){
        return commandName;
    }


}
