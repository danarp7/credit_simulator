package com.simulator.credit.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VehicleLoan {

    private VehicleTypeEnum vehicleType;
    private VehicleConditionEnum vehicleCondition;
    private Integer vehicleYear;
    private Double loanAmount;
    private Integer installmentTenor;
    private Double loanDownPayment;

}
