package com.simulator.credit.domain.errors;

public class BaseException extends RuntimeException {

    public BaseException(String message) {
        super(message);
    }

    public void printErrorMessage() {
        System.out.println(this.getMessage());
    }

}
