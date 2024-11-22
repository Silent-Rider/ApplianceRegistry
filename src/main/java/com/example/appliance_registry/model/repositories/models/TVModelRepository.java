package com.example.appliance_registry.model.repositories.models;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.appliance_registry.model.entities.models.TVModel;

/**
 * @author silent_rider
 */

@Repository
public interface TVModelRepository extends JpaRepository<TVModel, Long> {

    TVModel findByNameIgnoreCase(String name);

    List<TVModel> findByColor(String color);

    List<TVModel> findByPriceBetween(Integer from, Integer to);

    List<TVModel> findByCategory(String category);

    List<TVModel> findByTechnology(String technology);
}
