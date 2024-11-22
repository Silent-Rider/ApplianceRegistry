package com.example.appliance_registry.model.repositories.models;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.appliance_registry.model.entities.models.SmartphoneModel;

/**
 * @author silent_rider
 */

@Repository
public interface SmartphoneModelRepository extends JpaRepository<SmartphoneModel, Long>{

    SmartphoneModel findByNameIgnoreCase(String name);

    List<SmartphoneModel> findByColor(String color);

    List<SmartphoneModel> findByPriceBetween(Integer from, Integer to);

    List<SmartphoneModel> findByMemory(Integer memory);

    List<SmartphoneModel> findByCamerasCount(Integer camerasCount);
}
