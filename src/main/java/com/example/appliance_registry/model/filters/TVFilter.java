package com.example.appliance_registry.model.filters;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Фильтр моделей телевизоров")
public class TVFilter extends Filter{

    @Schema(description = "Категория и технология")
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
