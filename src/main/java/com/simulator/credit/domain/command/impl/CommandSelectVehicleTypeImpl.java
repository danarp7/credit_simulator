package com.simulator.credit.domain.command.impl;

import com.simulator.credit.domain.command.CommandSelect;
import com.simulator.credit.domain.model.VehicleLoan;
import com.simulator.credit.domain.model.VehicleTypeEnum;
import com.simulator.credit.domain.validate.ValidateVehicleLoanService;

public class CommandSelectVehicleTypeImpl implements CommandSelect {

    public void displayMenu() {
        System.out.println("Input Vehicle Type (car/motorcycle)");
    }

    public void executeCommand(VehicleLoan vehicleLoan, String input) {
        new ValidateVehicleLoanService().validateInputVehicleType(input);
        vehicleLoan.setVehicleType(VehicleTypeEnum.ofCode(input).get());
    }

}
