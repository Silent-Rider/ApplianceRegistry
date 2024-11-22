package com.example.appliance_registry.model.entities.appliances;

import jakarta.persistence.*;

/**
 * @author silent_rider
 */

@MappedSuperclass
public class Appliance {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private String manufacturer;

    @Column(name = "available_online", nullable = false)
    private Boolean availableOnline;

    @Column(name = "installment_option", nullable = false)
    private Boolean installmentOption;

    

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

    private enum Type{
        COMPUTER,
        FRIDGE,
        SMARTPHONE,
        TV,
        VACUUM
    }
}
