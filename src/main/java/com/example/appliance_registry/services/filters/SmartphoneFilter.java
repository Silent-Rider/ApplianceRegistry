package com.example.appliance_registry.services.filters;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SmartphoneFilter extends Filter{

    Integer memory, camerasCount;

    public SmartphoneFilter(String type, String applianceName, String modelName, String color, Integer minPrice,
            Integer maxPrice, Integer memory, Integer camerasCount) {
        super(type, applianceName, modelName, color, minPrice, maxPrice);
        this.memory = memory;
        this.camerasCount = camerasCount;
    }
}
