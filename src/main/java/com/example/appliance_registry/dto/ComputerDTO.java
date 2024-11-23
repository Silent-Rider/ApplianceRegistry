package com.example.appliance_registry.dto;

import com.example.appliance_registry.model.entities.Model;

public class ComputerDTO extends ModelDTO {

    private String category, processorType;

    @Override
    public void loadFromModel(Model model){
        super.loadFromModel(model);
        this.category = model.getCategory();
        this.processorType = model.getProcessorType();
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
