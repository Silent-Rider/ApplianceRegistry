package com.example.appliance_registry.dto;

import com.example.appliance_registry.model.entities.Model;

public class VacuumDTO extends ModelDTO {

    private Double dustBagVolume;
    private Integer modesCount;

    @Override
    public void loadFromModel(Model model){
        super.loadFromModel(model);
        this.dustBagVolume = model.getDustBagVolume();
        this.modesCount = model.getModesCount();
    }

    public Double getDustBagVolume() {
        return dustBagVolume;
    }

    public void setDustBagVolume(Double dustBagVolume) {
        this.dustBagVolume = dustBagVolume;
    }

    public Integer getModesCount() {
        return modesCount;
    }

    public void setModesCount(Integer modesCount) {
        this.modesCount = modesCount;
    }
}
