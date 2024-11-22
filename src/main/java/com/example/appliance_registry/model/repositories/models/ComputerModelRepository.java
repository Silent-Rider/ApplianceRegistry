package com.example.appliance_registry.model.repositories.models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.appliance_registry.model.entities.models.ComputerModel;
import java.util.List;


/**
 * @author silent_rider
 */

@Repository
public interface ComputerModelRepository extends JpaRepository <ComputerModel, Long> {

    ComputerModel findByNameIgnoreCase(String name);

    List<ComputerModel> findByColor(String color);

    List<ComputerModel> findByPriceBetween(Integer from, Integer to);

    List<ComputerModel> findByCategory(String category);
    
    List<ComputerModel> findByProcessorType(String processorType);
}
