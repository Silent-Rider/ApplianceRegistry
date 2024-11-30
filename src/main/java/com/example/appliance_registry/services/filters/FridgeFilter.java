package com.example.appliance_registry.services.filters;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FridgeFilter extends Filter{

    Integer doorsCount;
    String compressorType;

    public FridgeFilter(String type, String applianceName, String modelName, String color, Integer minPrice,
            Integer maxPrice, Integer doorsCount, String compressorType) {
        super(type, applianceName, modelName, color, minPrice, maxPrice);
        this.doorsCount = doorsCount;
        this.compressorType = compressorType;
    }
}
