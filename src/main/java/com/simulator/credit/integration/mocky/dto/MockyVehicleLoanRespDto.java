package com.simulator.credit.integration.mocky.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class MockyVehicleLoanRespDto {

    private String vehicleType;
    private String vehicleCondition;
    private Integer vehicleYear;
    private Double loanAmount;
    private Integer installmentTenor;
    private Double loanDownPayment;

}
