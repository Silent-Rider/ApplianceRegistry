package com.example.appliance_registry.model.entities.models;

import com.example.appliance_registry.model.entities.appliances.TV;

import jakarta.persistence.*;

/**
 * @author silent_rider
 */

@Entity
@Table(name = "tv_models")
public class TVModel extends Model {

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private String technology;

    @ManyToOne
    @JoinColumn(name = "tv_id", nullable = false)
    private TV tv;

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

    public TV getTv() {
        return tv;
    }

    public void setTv(TV tv) {
        this.tv = tv;
    }
}
