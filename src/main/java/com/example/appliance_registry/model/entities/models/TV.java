package com.example.appliance_registry.model.entities.models;

import com.example.appliance_registry.model.entities.Model;

import jakarta.persistence.Entity;
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
}
