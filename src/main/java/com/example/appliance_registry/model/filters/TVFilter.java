package com.example.appliance_registry.model.filters;

public class TVFilter extends Filter{

    String category, technology;

    public TVFilter(String type, String applianceName, String modelName, String color, Integer minPrice,
            Integer maxPrice, String category, String technology) {
        super(type, applianceName, modelName, color, minPrice, maxPrice);
        this.category = category;
        this.technology = technology;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }
}
