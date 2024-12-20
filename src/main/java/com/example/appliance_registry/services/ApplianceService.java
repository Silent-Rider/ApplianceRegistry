package com.example.appliance_registry.services;

import org.springframework.stereotype.Service;

import com.example.appliance_registry.model.entities.Appliance;
import com.example.appliance_registry.model.repositories.ApplianceRepository;
import com.example.appliance_registry.model.entities.Type;

@Service
public class ApplianceService {

    private final ApplianceRepository applianceRepository;

    public ApplianceService(ApplianceRepository applianceRepository) {
        this.applianceRepository = applianceRepository;
    }

    public Appliance saveAppliance(Appliance appliance) {
        return applianceRepository.save(appliance);
    }

    public Appliance getApplianceByTypeAndName(Type type, String name) {
        return applianceRepository.findByTypeAndNameIgnoreCase(type, name);
    }
}
