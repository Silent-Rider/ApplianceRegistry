package com.example.appliance_registry.model.repositories.appliances;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.appliance_registry.model.entities.appliances.Computer;

/**
 * @author silent_rider
 */

@Repository
public interface ComputerRepository extends JpaRepository <Computer, Long> {
    
    Computer findByNameIgnoreCase(String name);
}
