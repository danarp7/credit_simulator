package com.simulator.credit.domain.model;

import java.util.Optional;

public enum VehicleTypeEnum {

    CAR("CAR", "Car", 0.08D, 0.25D),
    MOTORCYCLE("MOTORCYCLE", "Motorcycle", 0.09D, 0.35D);

    private final String code;
    private final String description;
    private final Double interestRate;
    private final Double maxDownPaymentRate;

    VehicleTypeEnum(String code, String description, Double interestRate, Double maxDownPaymentRate) {
        this.code = code;
        this.description = description;
        this.interestRate = interestRate;
        this.maxDownPaymentRate = maxDownPaymentRate;
    }

    public static Optional<VehicleTypeEnum> ofCode(String code) {
        for (VehicleTypeEnum vehicleTypeEnum : VehicleTypeEnum.values()) {
            if (vehicleTypeEnum.code.equalsIgnoreCase(code)) {
                return Optional.of(vehicleTypeEnum);
            }
        }

        return Optional.empty();
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public Double getMaxDownPaymentRate() {
        return maxDownPaymentRate;
    }
}
