package com.simulator.credit.domain.command.impl;

import com.simulator.credit.domain.command.CommandSelect;
import com.simulator.credit.domain.model.VehicleLoan;
import com.simulator.credit.domain.validate.ValidateVehicleLoanService;

public class CommandSelectVehicleYearImpl implements CommandSelect {

    public void displayMenu() {
        System.out.println("Input Vehicle Year");
    }

    public void executeCommand(VehicleLoan vehicleLoan, String input) {
        new ValidateVehicleLoanService().validateInputVehicleYear(vehicleLoan, input);
        vehicleLoan.setVehicleYear(Integer.valueOf(input));
    }

}
