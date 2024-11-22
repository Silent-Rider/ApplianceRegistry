package com.example.appliance_registry.model.repositories.models;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.appliance_registry.model.entities.models.FridgeModel;

/**
 * @author silent_rider
 */

@Repository
public interface FridgeModelRepository extends JpaRepository <FridgeModel, Long> {

    FridgeModel findByNameIgnoreCase(String name);

    List<FridgeModel> findByColor(String color);

    List<FridgeModel> findByPriceBetween(Integer from, Integer to);

    List<FridgeModel> findByDoorsCount(Integer doorsCount);

    List<FridgeModel> findByCompressorType(String compressorType);
}
