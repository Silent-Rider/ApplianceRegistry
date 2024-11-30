package com.example.appliance_registry.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.example.appliance_registry.model.entities.models.Fridge;

@Repository
public interface FridgeRepository extends JpaRepository<Fridge, Long>, JpaSpecificationExecutor<Fridge>{

}