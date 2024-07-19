package com.simulator.credit.domain.service;

import com.simulator.credit.domain.abstracts.VehicleLoanFactory;
import com.simulator.credit.domain.model.VehicleConditionEnum;
import com.simulator.credit.domain.model.VehicleLoan;
import com.simulator.credit.domain.model.VehicleTypeEnum;
import com.simulator.credit.domain.validate.ValidateVehicleLoanService;
import com.simulator.credit.integration.mocky.service.MockyIntegrationService;

import java.math.BigDecimal;
import java.util.List;

public class SimulatorCreditService {

    public void calculateVehicleLoan(VehicleLoan vehicleLoan) {
        var vehicleLoanFactory = new VehicleLoanFactory();
        var vehicleLoanService = vehicleLoanFactory.getVehicleLoanFactory(vehicleLoan.getVehicleType());
        vehicleLoanService.getInterestRate();
        vehicleLoanService.displayVehicleLoan(vehicleLoan);
        vehicleLoanService.calculateLoan(vehicleLoan);
    }

    public void loadFromMocky() {
        var mockyIntegrationService = new MockyIntegrationService();
        var mockyVehicleLoanRespDto = mockyIntegrationService.postMockyVehicleLoan();

        var vehicleLoan = new VehicleLoan();
        var validateVehicleLoanService = new ValidateVehicleLoanService();

        validateVehicleLoanService.validateInputVehicleType(mockyVehicleLoanRespDto.getVehicleType());
        vehicleLoan.setVehicleType(VehicleTypeEnum.ofCode(mockyVehicleLoanRespDto.getVehicleType()).get());

        validateVehicleLoanService.validateInputVehicleCondition(mockyVehicleLoanRespDto.getVehicleCondition());
        vehicleLoan.setVehicleCondition(
                VehicleConditionEnum.ofCode(mockyVehicleLoanRespDto.getVehicleCondition()).get()
        );

        validateVehicleLoanService.validateInputVehicleYear(
                vehicleLoan, mockyVehicleLoanRespDto.getVehicleYear().toString()
        );
        vehicleLoan.setVehicleYear(mockyVehicleLoanRespDto.getVehicleYear());

        validateVehicleLoanService.validateInputLoanAmount(
                BigDecimal.valueOf(mockyVehicleLoanRespDto.getLoanAmount()).toPlainString()
        );
        vehicleLoan.setLoanAmount(mockyVehicleLoanRespDto.getLoanAmount());

        validateVehicleLoanService.validateInputInstallmentTenor(
                mockyVehicleLoanRespDto.getInstallmentTenor().toString()
        );
        vehicleLoan.setInstallmentTenor(mockyVehicleLoanRespDto.getInstallmentTenor());

        validateVehicleLoanService.validateInputLoanDownPayment(
                vehicleLoan, BigDecimal.valueOf(mockyVehicleLoanRespDto.getLoanDownPayment()).toPlainString()
        );
        vehicleLoan.setLoanDownPayment(mockyVehicleLoanRespDto.getLoanDownPayment());

        calculateVehicleLoan(vehicleLoan);
    }

    public void loadFromFileArgs(List<String> dataList) {
        var vehicleLoan = new VehicleLoan();
        var validateVehicleLoanService = new ValidateVehicleLoanService();

        var vehicleType = dataList.get(0);
        var vehicleCondition = dataList.get(1);
        var vehicleYear = dataList.get(2);
        var loanAmount = dataList.get(3);
        var installmentTenor = dataList.get(4);
        var loanDownPayment = dataList.get(5);

        validateVehicleLoanService.validateInputVehicleType(vehicleType);
        vehicleLoan.setVehicleType(VehicleTypeEnum.ofCode(vehicleType).get());

        validateVehicleLoanService.validateInputVehicleCondition(vehicleCondition);
        vehicleLoan.setVehicleCondition(
                VehicleConditionEnum.ofCode(vehicleCondition).get()
        );

        validateVehicleLoanService.validateInputVehicleYear(vehicleLoan, vehicleYear);
        vehicleLoan.setVehicleYear(Integer.valueOf(vehicleYear));

        validateVehicleLoanService.validateInputLoanAmount(loanAmount);
        vehicleLoan.setLoanAmount(Double.valueOf(loanAmount));

        validateVehicleLoanService.validateInputInstallmentTenor(installmentTenor);
        vehicleLoan.setInstallmentTenor(Integer.valueOf(installmentTenor));

        validateVehicleLoanService.validateInputLoanDownPayment(vehicleLoan, loanDownPayment);
        vehicleLoan.setLoanDownPayment(Double.valueOf(loanDownPayment));

        calculateVehicleLoan(vehicleLoan);
    }

}
