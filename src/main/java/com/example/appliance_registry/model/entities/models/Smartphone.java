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
@Table(name = "smartphones")
public class Smartphone extends Model {

    @Column(name = "cameras_count")
    private Integer camerasCount;
    private Integer memory;
}
