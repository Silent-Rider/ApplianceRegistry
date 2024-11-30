package com.example.appliance_registry.model.entities.models;

import com.example.appliance_registry.model.entities.Appliance;
import com.example.appliance_registry.model.entities.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "tvs")
public class TV extends Model {
    
    private String category;
    private String technology;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "appliance_id", nullable = false)
    private Appliance appliance;
}
