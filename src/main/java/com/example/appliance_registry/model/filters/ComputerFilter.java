package com.example.appliance_registry.model.filters;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Фильтр моделей компьютеров")
public class ComputerFilter extends Filter {
    
    @Schema(description = "Категория и тип процессора")
    String category, processorType;

    public ComputerFilter(String type, String applianceName, String modelName, String color, Integer minPrice,
            Integer maxPrice, String category, String processorType) {
        super(type, applianceName, modelName, color, minPrice, maxPrice);
        this.category = category;
        this.processorType = processorType;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProcessorType() {
        return processorType;
    }

    public void setProcessorType(String processorType) {
        this.processorType = processorType;
    }
}
