package com.simulator.credit.domain.errors;

public class CommandNotFoundException extends BaseException {

    public CommandNotFoundException() {
        super("Error Command Not Found");
    }

}
