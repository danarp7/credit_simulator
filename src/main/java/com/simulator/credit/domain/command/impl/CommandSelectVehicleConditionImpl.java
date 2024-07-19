package com.simulator.credit.domain.command.impl;

import com.simulator.credit.domain.command.CommandSelect;
import com.simulator.credit.domain.model.VehicleConditionEnum;
import com.simulator.credit.domain.model.VehicleLoan;
import com.simulator.credit.domain.validate.ValidateVehicleLoanService;

public class CommandSelectVehicleConditionImpl implements CommandSelect {

    public void displayMenu() {
        System.out.println("Input Vehicle Condition (new/second)");
    }

    public void executeCommand(VehicleLoan vehicleLoan, String input) {
        new ValidateVehicleLoanService().validateInputVehicleCondition(input);
        vehicleLoan.setVehicleCondition(VehicleConditionEnum.ofCode(input).get());
    }

}
