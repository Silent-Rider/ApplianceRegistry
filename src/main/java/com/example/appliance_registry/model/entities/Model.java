package com.example.appliance_registry.model.entities;

import com.example.appliance_registry.model.entities.models.*;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import jakarta.persistence.*;
import lombok.Data;

/**
 * @author silent_rider
 */

@Data
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = Computer.class, name = "computer"),
    @JsonSubTypes.Type(value = TV.class, name = "tv"),
    @JsonSubTypes.Type(value = Fridge.class, name = "fridge"),
    @JsonSubTypes.Type(value = Smartphone.class, name = "smartphone"),
    @JsonSubTypes.Type(value = Vacuum.class, name = "vacuum")
})
@MappedSuperclass
public abstract class Model {
    
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

    @Column(name = "appliance_name", nullable = false)
    private String applianceName;

    @Column(nullable = false)
    private String type;

    public abstract void setAppliance(Appliance appliance);
}
