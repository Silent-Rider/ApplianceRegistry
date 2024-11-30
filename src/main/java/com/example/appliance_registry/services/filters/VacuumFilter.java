package com.example.appliance_registry.services.filters;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VacuumFilter extends Filter{

    Double dustBagVolume;
    Integer modesCount;
    
    public VacuumFilter(String type, String applianceName, String modelName, String color, Integer minPrice,
            Integer maxPrice, Double dustBagVolume, Integer modesCount) {
        super(type, applianceName, modelName, color, minPrice, maxPrice);
        this.dustBagVolume = dustBagVolume;
        this.modesCount = modesCount;
    }
}
