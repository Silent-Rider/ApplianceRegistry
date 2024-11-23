package com.example.appliance_registry.model.filters;

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
