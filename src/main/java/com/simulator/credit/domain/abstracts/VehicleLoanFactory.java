package com.simulator.credit.domain.abstracts;

import com.simulator.credit.domain.abstracts.impl.CarLoanService;
import com.simulator.credit.domain.abstracts.impl.MotorcycleLoanService;
import com.simulator.credit.domain.model.VehicleTypeEnum;

public class VehicleLoanFactory {

    public VehicleLoanService getVehicleLoanFactory(VehicleTypeEnum vehicleTypeEnum) {

        if(vehicleTypeEnum == null) {
            return null;
        }

        if(vehicleTypeEnum == VehicleTypeEnum.CAR) {
            return new CarLoanService();
        } else if(vehicleTypeEnum == VehicleTypeEnum.MOTORCYCLE){
            return new MotorcycleLoanService();
        }
        return null;
    }

}
