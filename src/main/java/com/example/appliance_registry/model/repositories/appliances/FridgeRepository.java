package com.example.appliance_registry.model.repositories.appliances;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.appliance_registry.model.entities.appliances.Fridge;

/**
 * @author silent_rider
 */

@Repository
public interface FridgeRepository extends JpaRepository<Fridge, Long> {

    Fridge findByNameIgnoreCase(String name);
}
