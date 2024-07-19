package com.simulator.credit.domain.command.impl;

import com.simulator.credit.domain.command.CommandSelect;
import com.simulator.credit.domain.model.VehicleLoan;
import com.simulator.credit.domain.validate.ValidateVehicleLoanService;

public class CommandSelectInstallmentTenormpl implements CommandSelect {

    public void displayMenu() {
        System.out.println("Input Installment Tenor (max 6 years)");
    }

    public void executeCommand(VehicleLoan vehicleLoan, String input) {
        new ValidateVehicleLoanService().validateInputInstallmentTenor(input);
        vehicleLoan.setInstallmentTenor(Integer.valueOf(input));
    }

}
