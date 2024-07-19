package com.simulator.credit.domain.command;

import com.simulator.credit.domain.command.impl.*;
import com.simulator.credit.domain.errors.BaseException;
import com.simulator.credit.domain.errors.CommandNotFoundException;

import java.util.LinkedHashMap;

public class CommandFactory {

    private static CommandFactory singleInstance = null;
    private LinkedHashMap<Integer, Object> commandMap = new LinkedHashMap<>();
    private Integer inputedCommand;

    public void setInputedCommand(Integer inputedCommand) {
        this.inputedCommand = inputedCommand;
    }

    public CommandFactory() {
        commandMap.put(1, new CommandSelectVehicleTypeImpl());
        commandMap.put(2, new CommandSelectVehicleConditionImpl());
        commandMap.put(3, new CommandSelectVehicleYearImpl());
        commandMap.put(4, new CommandSelectLoanAmountImpl());
        commandMap.put(5, new CommandSelectInstallmentTenormpl());
        commandMap.put(6, new CommandSelectLoanDownPaymentImpl());
    }

    public LinkedHashMap<Integer, Object> getCommandMap() {
        return commandMap;
    }

    public CommandSelect getCommandSelect() {
        var commandSelect = (CommandSelect) commandMap.get(inputedCommand);
        if(commandSelect == null) {
            throw new CommandNotFoundException();
        }

        return commandSelect;
    }

    public static CommandFactory getInstance() {
        if (singleInstance == null) {
            singleInstance = new CommandFactory();
        }

        return singleInstance;
    }
}
