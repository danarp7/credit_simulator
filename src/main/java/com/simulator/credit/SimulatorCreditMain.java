package com.simulator.credit;

import com.simulator.credit.domain.service.SimulatorCreditService;
import com.simulator.credit.interfaces.console.MainMenu;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class SimulatorCreditMain
{
    public static void main( String[] args ) {
        if(args.length > 0) {
            try {
                var fileInput = args[0];
                var scannerFile = new Scanner(new File(fileInput));
                int currentLine = 0;
                while(scannerFile.hasNext()) {
                    if(currentLine == 0) {
                        continue;
                    }

                    var dataText = scannerFile.next();
                    var dataArray = Arrays.asList(StringUtils.split(dataText, "|"));
                    new SimulatorCreditService().loadFromFileArgs(dataArray);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        new MainMenu().mainMenu();
    }
}
