package com.simulator.credit.interfaces.console;

import com.simulator.credit.domain.command.CommandFactory;
import com.simulator.credit.domain.errors.BaseException;
import com.simulator.credit.domain.model.VehicleLoan;
import com.simulator.credit.domain.service.SimulatorCreditService;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Scanner;

public class VehicleLoanSubmissionMenu {

    public void vehicleLoanSubmissionMenu() {

        var scanner = new Scanner(System.in);
        String input = "";
        var commandFactory = CommandFactory.getInstance();
        var vehicleLoan = new VehicleLoan();
        var commandMap = commandFactory.getCommandMap();
        var commandMapListIterator = Arrays.asList(commandMap.keySet().toArray()).listIterator();

        while(commandMapListIterator.hasNext()) {
            System.out.println("\n");
            System.out.println("--------------------Vehicle Loan Submission Menu--------------------");
            System.out.println("98. Previous Input");
            System.out.println("99. Back To Main Menu");
            System.out.println("-------------------------------------------------------------------");
            System.out.println("Choose Number Menu:");

            try {
                commandFactory.setInputedCommand((Integer) commandMapListIterator.next());
                var commandSelect = commandFactory.getCommandSelect();
                commandSelect.displayMenu();
                input = scanner.next();

                if(StringUtils.equals("98", input)) {
                    if(commandMapListIterator.hasPrevious()) {
                        commandMapListIterator.previous();
                        commandMapListIterator.previous();
                    } else {
                        break;
                    }
                } else if(StringUtils.equals("99", input)) {
                    break;
                } else {
                    commandSelect.executeCommand(vehicleLoan, input);

                    if(!commandMapListIterator.hasNext()) {
                        new SimulatorCreditService().calculateVehicleLoan(vehicleLoan);
                    }
                }
            } catch (BaseException be) {
                be.printErrorMessage();
                commandMapListIterator.previous();
            }
        }
    }

}
