package com.example.appliance_registry.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

/**
 * @author silent_rider
 */

@Data
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@MappedSuperclass
public class Model {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(name = "serial_number", nullable = false, unique = true)
    private String serialNumber;

    @Column(nullable = false)
    private String color;

    @Column(columnDefinition = "VARCHAR(50)", nullable = false)
    private String size;

    @Column(nullable = false)
    private Integer price;

    @Column(name = "in_stock", nullable = false)
    private Boolean inStock;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "appliance_id", nullable = false)
    private Appliance appliance;

    @Column(nullable = false)
    private String type;

    @JsonProperty(value = "applianceName")
    public String applianceName(){
        return appliance.getName();
    }


}
