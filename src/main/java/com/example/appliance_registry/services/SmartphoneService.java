package com.example.appliance_registry.services;

import org.springframework.stereotype.Service;

import com.example.appliance_registry.model.repositories.appliances.SmartphoneRepository;
import com.example.appliance_registry.model.repositories.models.SmartphoneModelRepository;

/**
 * @author silent_rider
 */

@Service
public class SmartphoneService {

    private SmartphoneRepository smartRep;
    private SmartphoneModelRepository smartModelRep;
}
