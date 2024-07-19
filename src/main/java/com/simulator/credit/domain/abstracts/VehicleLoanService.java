package com.simulator.credit.domain.abstracts;

import com.simulator.credit.domain.model.InstallmentLoan;
import com.simulator.credit.domain.model.VehicleLoan;
import com.simulator.credit.utils.AmountUtil;

import java.util.ArrayList;
import java.util.List;

public abstract class VehicleLoanService {

    protected Double interestRate;
    protected List<InstallmentLoan> installmentLoanList = new ArrayList<>();

    public abstract void getInterestRate();

    public void displayVehicleLoan(VehicleLoan vehicleLoan) {
        System.out.println("Vehicle Type\t\t\t: " + vehicleLoan.getVehicleType().getDescription());
        System.out.println("Vehicle Condition\t\t: " + vehicleLoan.getVehicleCondition().getDescription());
        System.out.println("Vehicle Year\t\t\t: " + vehicleLoan.getVehicleYear());
        System.out.println("Loan Amount\t\t\t\t: "
                + AmountUtil.formatAmountWithCurrency(vehicleLoan.getLoanAmount(), "Rp"));
        System.out.println("Installment Tenor\t\t: " + vehicleLoan.getInstallmentTenor());
        System.out.println("Loan Down Payment\t\t: "
                + AmountUtil.formatAmountWithCurrency(vehicleLoan.getLoanDownPayment(), "Rp"));
    }

    public void calculateLoan(VehicleLoan vehicleLoan) {
        var totalMonthTenor = vehicleLoan.getInstallmentTenor() * 12;
        var principalLoanAmount = vehicleLoan.getLoanAmount() - vehicleLoan.getLoanDownPayment();
        var loanAfterInterestRate = (principalLoanAmount * interestRate) + principalLoanAmount;

        for(int i = 0; i < vehicleLoan.getInstallmentTenor(); i++) {
            var installmentMonthly = loanAfterInterestRate / (totalMonthTenor - (i * 12));
            var installmentYearly = installmentMonthly * 12;

            var installmentLoan = new InstallmentLoan();
            installmentLoan.setInstallmentYear(i + 1);
            installmentLoan.setInstallmentAmountPerMonth(installmentMonthly);
            installmentLoan.setInterestRatePercentage(interestRate * 100);
            installmentLoanList.add(installmentLoan);

            if ((i + 1) % 2 == 0) {
                interestRate = interestRate + 0.005D;
            } else {
                interestRate = interestRate + 0.001D;
            }

            loanAfterInterestRate = loanAfterInterestRate - installmentYearly;
            loanAfterInterestRate = (loanAfterInterestRate * interestRate) + loanAfterInterestRate;
        }

        System.out.println("Calculate Loan Result");
        installmentLoanList.stream()
                .forEach(il -> {
                    System.out.println("Year " + il.getInstallmentYear() + " Installment per Month "
                            + AmountUtil.formatAmountWithCurrency(il.getInstallmentAmountPerMonth(), "Rp")
                            + " rate " + il.getInterestRatePercentage() + "%");
                });
    }

}
