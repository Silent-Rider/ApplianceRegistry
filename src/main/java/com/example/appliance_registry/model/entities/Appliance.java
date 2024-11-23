package com.example.appliance_registry.model.entities;

import jakarta.persistence.*;
import java.util.List;

/**
 * @author silent_rider
 */

@Entity
@Table(name = "appliances")
public class Appliance {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private String manufacturer;

    @Column(name = "available_online", nullable = false)
    private Boolean availableOnline;

    @Column(name = "installment_option", nullable = false)
    private Boolean installmentOption;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Type type;

    @OneToMany(mappedBy = "appliance", cascade = CascadeType.ALL)
    List<Model> models;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Boolean getAvailableOnline() {
        return availableOnline;
    }

    public void setAvailableOnline(Boolean availableOnline) {
        this.availableOnline = availableOnline;
    }

    public Boolean getInstallmentOption() {
        return installmentOption;
    }

    public void setInstallmentOption(Boolean installmentOption) {
        this.installmentOption = installmentOption;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<Model> getModels() {
        return models;
    }

    public void setModels(List<Model> models) {
        this.models = models;
    }

    public enum Type{
        COMPUTER,
        FRIDGE,
        SMARTPHONE,
        TV,
        VACUUM
    }
}
