package com.example.appliance_registry.services.filters;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TVFilter extends Filter{

    String category, technology;

    public TVFilter(String type, String applianceName, String modelName, String color, Integer minPrice,
            Integer maxPrice, String category, String technology) {
        super(type, applianceName, modelName, color, minPrice, maxPrice);
        this.category = category;
        this.technology = technology;
    }
}
