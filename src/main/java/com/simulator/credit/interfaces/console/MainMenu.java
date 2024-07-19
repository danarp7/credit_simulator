package com.simulator.credit.interfaces.console;

import com.simulator.credit.domain.errors.BaseException;
import com.simulator.credit.domain.service.SimulatorCreditService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenu {

    public void mainMenu() {

        var scanner = new Scanner(System.in);
        int menu = 0;

        while(menu != 99) {
            System.out.println("\n");
            System.out.println("--------------------Main Menu--------------------");
            System.out.println("1. Vehicle Loan Submission");
            System.out.println("2. Load Vehicle Loan Submission From API Mocky");
            System.out.println("99. Exit");
            System.out.println("-------------------------------------------------");
            System.out.println("Choose Number Menu:");

            try {
                menu = scanner.nextInt();

                if(menu == 1) {
                    var vehicleLoanSubmissionMenu = new VehicleLoanSubmissionMenu();
                    vehicleLoanSubmissionMenu.vehicleLoanSubmissionMenu();
                } else if(menu == 2) {
                    new SimulatorCreditService().loadFromMocky();
                } else if(menu == 99) {
                    System.out.print("Thankyou");
                } else {
                    System.out.println("Menu not found");
                }
            } catch (InputMismatchException ime) {
                System.out.println("must numeric");
            } catch (BaseException be) {
                be.printErrorMessage();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

        scanner.close();
    }
}
