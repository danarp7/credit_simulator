package com.simulator.credit.domain.command.impl;

import com.simulator.credit.domain.command.CommandSelect;
import com.simulator.credit.domain.model.VehicleLoan;
import com.simulator.credit.domain.validate.ValidateVehicleLoanService;

public class CommandSelectLoanAmountImpl implements CommandSelect {

    public void displayMenu() {
        System.out.println("Input Loan Amount (max 1 milyar)");
    }

    public void executeCommand(VehicleLoan vehicleLoan, String input) {
        new ValidateVehicleLoanService().validateInputLoanAmount(input);
        vehicleLoan.setLoanAmount(Double.valueOf(Long.valueOf(input)));
    }

}
