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
@Table(name = "vacuums")
public class Vacuum extends Model {

    @Column(name = "dust_bag_volume")
    private Double dustBagVolume;

    @Column(name = "modes_count")
    private Integer modesCount;
}
