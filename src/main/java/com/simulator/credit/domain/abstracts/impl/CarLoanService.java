package com.simulator.credit.domain.abstracts.impl;

import com.simulator.credit.domain.abstracts.VehicleLoanService;
import com.simulator.credit.domain.model.VehicleTypeEnum;

public class CarLoanService extends VehicleLoanService {

    public void getInterestRate() {
        interestRate = VehicleTypeEnum.CAR.getInterestRate();
    }

}
