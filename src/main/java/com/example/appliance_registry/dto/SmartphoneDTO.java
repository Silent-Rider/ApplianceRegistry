package com.example.appliance_registry.dto;

import com.example.appliance_registry.model.entities.Model;

public class SmartphoneDTO extends ModelDTO {

    private Integer memory, camerasCount;

    @Override
    public void loadFromModel(Model model){
        super.loadFromModel(model);
        this.memory = model.getMemory();
        this.camerasCount = model.getCamerasCount();
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
