package com.simulator.credit.domain.command.impl;

import com.simulator.credit.domain.command.CommandSelect;
import com.simulator.credit.domain.model.VehicleLoan;
import com.simulator.credit.domain.validate.ValidateVehicleLoanService;

public class CommandSelectLoanDownPaymentImpl implements CommandSelect {

    public void displayMenu() {
        System.out.println("Input Loan Down Payment");
    }

    public void executeCommand(VehicleLoan vehicleLoan, String input) {
        new ValidateVehicleLoanService().validateInputLoanDownPayment(vehicleLoan, input);
        vehicleLoan.setLoanDownPayment(Double.valueOf(Long.valueOf(input)));
    }

}
