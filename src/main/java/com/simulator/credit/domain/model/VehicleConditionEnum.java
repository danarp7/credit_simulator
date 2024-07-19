package com.simulator.credit.domain.model;

import java.util.Optional;

public enum VehicleConditionEnum {

    NEW("NEW", "New"),
    SECOND("SECOND", "Second");

    private final String code;
    private final String description;

    VehicleConditionEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static Optional<VehicleConditionEnum> ofCode(String code) {
        for (VehicleConditionEnum vehicleConditionEnum : VehicleConditionEnum.values()) {
            if (vehicleConditionEnum.code.equalsIgnoreCase(code)) {
                return Optional.of(vehicleConditionEnum);
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

}
