package com.example.appliance_registry.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.appliance_registry.model.entities.appliances.Computer;
import com.example.appliance_registry.model.repositories.appliances.ComputerRepository;
import com.example.appliance_registry.model.repositories.models.ComputerModelRepository;

/**
 * @author silent_rider
 */

@Service
public class ComputerService {

    private ComputerRepository compRep;
    private ComputerModelRepository compModelRep;

    public List<Computer> getAllComputers(){
        return compRep.findAll();
    }

    public Computer save (Computer computer){
        return compRep.save(computer);
    }

    public Computer getByName(String name){
        return compRep.findByName(name);
    }
}
