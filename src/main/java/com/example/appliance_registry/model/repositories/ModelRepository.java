package com.example.appliance_registry.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.appliance_registry.model.entities.Model;

/**
 * @author silent_rider
 */

public interface ModelRepository extends JpaRepository<Model, Long>, JpaSpecificationExecutor<Model>{

}
