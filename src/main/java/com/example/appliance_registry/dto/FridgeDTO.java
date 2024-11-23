package com.example.appliance_registry.dto;

import com.example.appliance_registry.model.entities.Model;

public class FridgeDTO extends ModelDTO {

    private Integer doorsCount;
    private String compressorType;

    @Override
    public void loadFromModel(Model model){
        super.loadFromModel(model);
        this.doorsCount = model.getDoorsCount();
        this.compressorType = model.getCompressorType();
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
