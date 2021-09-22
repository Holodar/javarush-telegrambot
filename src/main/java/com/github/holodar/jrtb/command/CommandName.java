package com.github.holodar.jrtb.command;

public enum CommandName {
    START("/start"),
    STOP ("/stop"),
    STAT("/stat"),
    ADD_GROUP_SUB("/addgroupsub"),
    NO("nocommand"),
    LIST_GROUP_SUB("/listGroupSub"),
    DELETE_GROUP_SUB("/deleteGroupSub"),
    ADMIN_HELP("/ahelp"),
    HELP("/help");

    private final String commandName;

    CommandName(String commandName){
        this.commandName = commandName;
    }
    public String getCommandName(){
        return commandName;
    }


}
