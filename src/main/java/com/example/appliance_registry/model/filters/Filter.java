package com.example.appliance_registry.model.filters;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Общий фильтр для поиска моделей приборов")
public class Filter {
    @Schema(description = "Тип прибора", example = "SMARTPHONE")
    private String type;
    @Schema(description = "Название прибора")
    private String applianceName;
    @Schema(description = "Название модели")
    private String modelName;
    @Schema(description = "Цвет")
    private String color;
    @Schema(description = "Минимальная цена")
    private Integer minPrice;
    @Schema(description = "Максимальная цена")
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getApplianceName() {
        return applianceName;
    }

    public void setApplianceName(String applianceName) {
        this.applianceName = applianceName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Integer minPrice) {
        this.minPrice = minPrice;
    }

    public Integer getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Integer maxPrice) {
        this.maxPrice = maxPrice;
    }
}
