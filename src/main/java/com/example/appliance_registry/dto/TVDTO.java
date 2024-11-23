package com.example.appliance_registry.dto;

import com.example.appliance_registry.model.entities.Model;

public class TVDTO extends ModelDTO{

    private String category, technology;

    @Override
    public void loadFromModel(Model model){
        super.loadFromModel(model);
        this.category = model.getCategory();
        this.technology = model.getTechnology();
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
