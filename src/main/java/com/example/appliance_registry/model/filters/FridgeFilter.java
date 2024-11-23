package com.example.appliance_registry.model.filters;

public class FridgeFilter extends Filter{

    Integer doorsCount;
    String compressorType;

    public FridgeFilter(String type, String applianceName, String modelName, String color, Integer minPrice,
            Integer maxPrice, Integer doorsCount, String compressorType) {
        super(type, applianceName, modelName, color, minPrice, maxPrice);
        this.doorsCount = doorsCount;
        this.compressorType = compressorType;
    }
    
    public Integer getDoorsCount() {
        return doorsCount;
    }

    public void setDoorsCount(Integer doorsCount) {
        this.doorsCount = doorsCount;
    }

    public String getCompressorType() {
        return compressorType;
    }

    public void setCompressorType(String compressorType) {
        this.compressorType = compressorType;
    }
}
