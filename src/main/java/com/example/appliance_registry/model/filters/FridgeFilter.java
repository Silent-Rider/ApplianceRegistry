package com.example.appliance_registry.model.filters;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Фильтр моделей холодильников")
public class FridgeFilter extends Filter{

    @Schema(description = "Количество дверей")
    Integer doorsCount;
    @Schema(description = "Тип компрессора")
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
