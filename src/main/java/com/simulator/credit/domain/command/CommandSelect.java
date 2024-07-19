package com.simulator.credit.domain.command;

import com.simulator.credit.domain.model.VehicleLoan;

public interface CommandSelect {

    void displayMenu();
    void executeCommand(VehicleLoan vehicleLoan, String input);

}
