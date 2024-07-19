package com.simulator.credit.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class InstallmentLoan {

    private Integer installmentYear;
    private Double installmentAmountPerMonth;
    private Double interestRatePercentage;

}
