package com.example.appliance_registry.model.entities.models;

import com.example.appliance_registry.model.entities.appliances.Smartphone;

import jakarta.persistence.*;

/**
 * @author silent_rider
 */

@Entity
@Table(name = "smartphone_models")
public class SmartphoneModel extends Model {

    @Column(nullable = false)
    private Integer memory;

    @Column(name = "cameras_count", nullable = false)
    private Integer camerasCount;

    @ManyToOne
    @JoinColumn(name = "smartphone_id", nullable = false)
    private Smartphone smartphone;

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

    public Smartphone getSmartphone() {
        return smartphone;
    }

    public void setSmartphone(Smartphone smartphone) {
        this.smartphone = smartphone;
    }
}
