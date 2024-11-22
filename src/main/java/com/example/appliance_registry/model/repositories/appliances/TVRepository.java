package com.example.appliance_registry.model.repositories.appliances;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.appliance_registry.model.entities.appliances.TV;

/**
 * @author silent_rider
 */

@Repository
public interface TVRepository extends JpaRepository<TV, Long>{

    TV findByNameIgnoreCase(String name);
}
