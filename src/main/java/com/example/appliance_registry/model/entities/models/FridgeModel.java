package com.example.appliance_registry.model.entities.models;

import com.example.appliance_registry.model.entities.appliances.Fridge;

import jakarta.persistence.*;

/**
 * @author silent_rider
 */

@Entity
@Table(name = "fridge_models")
public class FridgeModel extends Model {

    @Column(name = "doors_count", nullable = false)
    private Integer doorsCount;

    @Column(name = "compressor_type", nullable = false)
    private String compressorType;

    @ManyToOne
    @JoinColumn(name = "fridge_id", nullable = false)
    private Fridge fridge;

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

    public Fridge getFridge() {
        return fridge;
    }

    public void setFridge(Fridge fridge) {
        this.fridge = fridge;
    }
}
