package com.example.appliance_registry.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.appliance_registry.model.entities.Appliance;
import com.example.appliance_registry.model.entities.Type;


/**
 * @author silent_rider
 */

@Repository
public interface ApplianceRepository extends JpaRepository<Appliance, Long>{

    Appliance findByTypeAndNameIgnoreCase(Type type, String name);
}
