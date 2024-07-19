package com.simulator.credit.domain.errors;

public class InputNotBlankException extends BaseException {

    public InputNotBlankException() {
        super("Error input is not blank");
    }

}
