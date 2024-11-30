package com.example.appliance_registry.services.filters;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import lombok.Data;

@Data
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = ComputerFilter.class, name = "computer"),
    @JsonSubTypes.Type(value = TVFilter.class, name = "tv"),
    @JsonSubTypes.Type(value = FridgeFilter.class, name = "fridge"),
    @JsonSubTypes.Type(value = SmartphoneFilter.class, name = "smartphone"),
    @JsonSubTypes.Type(value = VacuumFilter.class, name = "vacuum")
})
public class Filter {
    
    private String type;
    private String applianceName;
    private String modelName;
    private String color;
    private Integer minPrice;
    private Integer maxPrice;
    
    public Filter(String type, String applianceName, String modelName, String color, Integer minPrice,
            Integer maxPrice) {
        if(type != null)
            this.type = type.toUpperCase();
        this.applianceName = applianceName;
        this.modelName = modelName;
        this.color = color;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }
}
