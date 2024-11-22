package com.example.appliance_registry.services;

import org.springframework.stereotype.Service;

import com.example.appliance_registry.model.repositories.appliances.VacuumRepository;
import com.example.appliance_registry.model.repositories.models.VacuumModelRepository;

/**
 * @author silent_rider
 */

@Service
public class VacuumService {

    private VacuumRepository vacRep;
    private VacuumModelRepository vacModelRep;
}
