package com.example.appliance_registry.model.filters;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Фильтр моделей компьютеров")
public class VacuumFilter extends Filter{
    @Schema(description = "Объём пылесборника")
    Double dustBagVolume;
    @Schema(description = "Количество режимов")
    Integer modesCount;
    
    public VacuumFilter(String type, String applianceName, String modelName, String color, Integer minPrice,
            Integer maxPrice, Double dustBagVolume, Integer modesCount) {
        super(type, applianceName, modelName, color, minPrice, maxPrice);
        this.dustBagVolume = dustBagVolume;
        this.modesCount = modesCount;
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
