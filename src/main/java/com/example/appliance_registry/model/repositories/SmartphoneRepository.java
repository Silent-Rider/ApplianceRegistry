package com.example.appliance_registry.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.example.appliance_registry.model.entities.models.Smartphone;

@Repository
public interface SmartphoneRepository extends JpaRepository<Smartphone, Long>, 
JpaSpecificationExecutor<Smartphone>{

}
