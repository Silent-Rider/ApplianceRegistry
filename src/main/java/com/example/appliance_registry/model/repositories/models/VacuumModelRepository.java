package com.example.appliance_registry.model.repositories.models;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.appliance_registry.model.entities.models.VacuumModel;

/**
 * @author silent_rider
 */

@Repository
public interface VacuumModelRepository extends JpaRepository<VacuumModel, Long> {

    VacuumModel findByNameIgnoreCase(String name);

    List<VacuumModel> findByColor(String color);

    List<VacuumModel> findByPriceBetween(Integer from, Integer to);

    List<VacuumModel> findByDustBagVolume(Double dustBagVolume);

    List<VacuumModel> findByModesCount(Integer modesCount);
}
