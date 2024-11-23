package com.example.appliance_registry.model.filters;

public class SmartphoneFilter extends Filter{

    Integer memory, camerasCount;

    public SmartphoneFilter(String type, String applianceName, String modelName, String color, Integer minPrice,
            Integer maxPrice, Integer memory, Integer camerasCount) {
        super(type, applianceName, modelName, color, minPrice, maxPrice);
        this.memory = memory;
        this.camerasCount = camerasCount;
    }

    public Integer getMemory() {
        return memory;
    }

    public void setMemory(Integer memory) {
        this.memory = memory;
    }

    public Integer getCamerasCount() {
        return camerasCount;
    }

    public void setCamerasCount(Integer camerasCount) {
        this.camerasCount = camerasCount;
    }
}