package com.example.appliance_registry.services;

import org.springframework.stereotype.Service;

import com.example.appliance_registry.model.repositories.appliances.FridgeRepository;
import com.example.appliance_registry.model.repositories.models.FridgeModelRepository;

/**
 * @author silent_rider
 */

@Service
public class FridgeService {

    private FridgeRepository fridgeRep;
    private FridgeModelRepository fridgeModelRep;
}
