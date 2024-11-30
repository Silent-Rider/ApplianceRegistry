package com.example.appliance_registry.model.entities.models;

import com.example.appliance_registry.model.entities.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "fridges")
public class Fridge extends Model {

    @Column(name = "doors_count")
    private Integer doorsCount;

    @Column(name = "compressor_type")
    private String compressorType;
}
