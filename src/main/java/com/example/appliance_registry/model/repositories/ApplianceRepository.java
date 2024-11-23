package com.example.appliance_registry.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.appliance_registry.model.entities.Appliance;

/**
 * @author silent_rider
 */

public interface ApplianceRepository extends JpaRepository<Appliance, Long>{

}
