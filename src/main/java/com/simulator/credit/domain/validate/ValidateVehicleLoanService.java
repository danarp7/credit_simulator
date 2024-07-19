package com.simulator.credit.domain.validate;

import com.simulator.credit.domain.constant.Constant;
import com.simulator.credit.domain.errors.BaseException;
import com.simulator.credit.domain.errors.InputNotBlankException;
import com.simulator.credit.domain.errors.InputNotNumericException;
import com.simulator.credit.domain.model.VehicleConditionEnum;
import com.simulator.credit.domain.model.VehicleLoan;
import com.simulator.credit.domain.model.VehicleTypeEnum;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;

public class ValidateVehicleLoanService {

    public void validateInputVehicleType(String input) {
        if(StringUtils.isBlank(input)) {
            throw new InputNotBlankException();
        }

        var vehicleTypeEnumOpt = VehicleTypeEnum.ofCode(input);
        if(vehicleTypeEnumOpt.isEmpty()) {
            throw new BaseException("input only Car or Motorcycle");
        }
    }

    public void validateInputVehicleCondition(String input) {
        if(StringUtils.isBlank(input)) {
            throw new InputNotBlankException();
        }

        var vehicleConditionEnumOpt = VehicleConditionEnum.ofCode(input);
        if(vehicleConditionEnumOpt.isEmpty()) {
            throw new BaseException("input only New or Second");
        }
    }

    public void validateInputVehicleYear(VehicleLoan vehicleLoan, String input) {
        if(StringUtils.isBlank(input)) {
            throw new InputNotBlankException();
        }

        if(!StringUtils.isNumeric(input)) {
            throw new InputNotNumericException();
        }

        if(StringUtils.length(input) != 4) {
            throw new BaseException("must 4 digit");
        }

        if(vehicleLoan.getVehicleCondition() == VehicleConditionEnum.NEW) {
            var currentYear = LocalDate.now().getYear();
            if(Integer.valueOf(input) <= (currentYear - 1)) {
                throw new BaseException(
                        "vehicle year must greater than current year - 1 if vehicle condition new"
                );
            }
        }
    }

    public void validateInputLoanAmount(String input) {
        if(StringUtils.isBlank(input)) {
            throw new InputNotBlankException();
        }

        if(!StringUtils.isNumeric(input)) {
            throw new InputNotNumericException();
        }

        var loanAmount = Long.valueOf(input);
        if(loanAmount > Constant.MAX_LOAN_AMOUNT) {
            throw new BaseException("must under 1 milyar");
        }
    }

    public void validateInputInstallmentTenor(String input) {
        if(StringUtils.isBlank(input)) {
            throw new InputNotBlankException();
        }

        if(!StringUtils.isNumeric(input)) {
            throw new InputNotNumericException();
        }

        var installmentTenor = Integer.valueOf(input);
        if(installmentTenor > Constant.MAX_INSTALLMENT_TENOR) {
            throw new BaseException("max 6 years");
        }

        if(installmentTenor <= 0) {
            throw new BaseException("must greater than 0");
        }
    }

    public void validateInputLoanDownPayment(VehicleLoan vehicleLoan, String input) {
        if(StringUtils.isBlank(input)) {
            throw new InputNotBlankException();
        }

        if(!StringUtils.isNumeric(input)) {
            throw new InputNotNumericException();
        }

        var loanDownPayment = Double.valueOf(Long.valueOf(input));
        var loanDownPaymentRate = loanDownPayment / vehicleLoan.getLoanAmount();
        var maxDownPaymentRate = vehicleLoan.getVehicleType().getMaxDownPaymentRate();
        if(loanDownPaymentRate > maxDownPaymentRate) {
            throw new BaseException("must under limit down payment rate " + (maxDownPaymentRate * 100) + "%");
        }
    }

}
