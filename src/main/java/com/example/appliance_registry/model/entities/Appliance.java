package com.example.appliance_registry.model.entities;

import java.util.List;

import com.example.appliance_registry.model.entities.models.*;

import jakarta.persistence.*;
import lombok.Data;

/**
 * @author silent_rider
 */

@Data
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

    @OneToMany(mappedBy = "appliance", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<Computer> computerModels;

    @OneToMany(mappedBy = "appliance", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<Fridge> fridgeModels;

    @OneToMany(mappedBy = "appliance", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<Smartphone> smartphoneModels;

    @OneToMany(mappedBy = "appliance", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<TV> tvModels;

    @OneToMany(mappedBy = "appliance", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<Vacuum> vacuumModels;
}
