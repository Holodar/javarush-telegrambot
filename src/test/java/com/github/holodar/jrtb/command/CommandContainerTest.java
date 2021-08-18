package com.github.holodar.jrtb.command;

import com.github.holodar.jrtb.service.SendBotMessageService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

@DisplayName("Unit-level testing for CommandContainer")
class CommandContainerTest {

    private CommandContainer commandContainer;

    @BeforeEach
    public void imit(){
        SendBotMessageService sendBotMessageService = Mockito.mock(SendBotMessageService.class);
        commandContainer = new CommandContainer(sendBotMessageService);
    }
    @Test
    public void shouldGetAllTheExistingCommands(){
        Arrays.stream(CommandName.values()).forEach(commandName -> {
            Command command = commandContainer.retriveCommand(commandName.getCommandName());
            Assertions.assertNotEquals(UnknownCommand.class,command.getClass());
        });
    }
    @Test
    public void shouldReturnUnknownCommand() {
        String unknownCommand = "/fgjhdfgdfg";

        Command command = commandContainer.retriveCommand(unknownCommand);

        Assertions.assertEquals(UnknownCommand.class,command.getClass());
    }

}
