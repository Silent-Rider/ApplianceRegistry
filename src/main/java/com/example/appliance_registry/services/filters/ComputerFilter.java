package com.example.appliance_registry.services.filters;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ComputerFilter extends Filter {
    
    String category, processorType;

    public ComputerFilter(String type, String applianceName, String modelName, String color, Integer minPrice,
            Integer maxPrice, String category, String processorType) {
        super(type, applianceName, modelName, color, minPrice, maxPrice);
        this.category = category;
        this.processorType = processorType;
    }
}
