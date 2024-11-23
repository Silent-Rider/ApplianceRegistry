package com.example.appliance_registry.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.appliance_registry.model.entities.Appliance;
import com.example.appliance_registry.services.ApplianceService;

/**
 * @author silent_rider
 */

@RequestMapping("/registry")
@RestController()
public class ApplianceController {

    private final ApplianceService applianceService;    

    public ApplianceController(ApplianceService applianceRepository) {
        this.applianceService = applianceRepository;
    }

    @PostMapping("/appliances") 
    public ResponseEntity<Appliance> addAppliance(@RequestBody Appliance appliance){
        Appliance savedAppliance = applianceService.saveAppliance(appliance);
        return new ResponseEntity<>(savedAppliance, HttpStatus.CREATED);
    }
}
