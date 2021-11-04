package com.github.holodar.jrtb.command;

import org.junit.jupiter.api.DisplayName;

import static com.github.holodar.jrtb.command.CommandName.HELLO_COMMAND;
import static com.github.holodar.jrtb.command.HelloCommand.HELLO_MASSAGE;

@DisplayName("Unit-level testing for HelloCommand")
public class HelloCommandTest extends AbstractCommandTest {

    @Override
    String getCommandName() {
        return HELLO_COMMAND.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return HELLO_MASSAGE;
    }

    @Override
    Command getCommand() {
        return new HelloCommand(sendBotMessageService);
    }
}
