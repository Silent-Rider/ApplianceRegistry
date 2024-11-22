package com.example.appliance_registry.services;

import org.springframework.stereotype.Service;

import com.example.appliance_registry.model.repositories.appliances.TVRepository;
import com.example.appliance_registry.model.repositories.models.TVModelRepository;

/**
 * @author silent_rider
 */

@Service
public class TVService {

    private TVRepository tvRep;
    private TVModelRepository tvModelRep;
}
