package com.example.appliance_registry.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.example.appliance_registry.model.entities.Model;
import com.example.appliance_registry.model.entities.models.Computer;
import com.example.appliance_registry.model.entities.models.Fridge;
import com.example.appliance_registry.model.entities.models.Smartphone;
import com.example.appliance_registry.model.entities.models.TV;
import com.example.appliance_registry.model.entities.models.Vacuum;
import com.example.appliance_registry.services.filters.ComputerFilter;
import com.example.appliance_registry.services.filters.Filter;
import com.example.appliance_registry.services.filters.FridgeFilter;
import com.example.appliance_registry.services.filters.SmartphoneFilter;
import com.example.appliance_registry.services.filters.TVFilter;
import com.example.appliance_registry.services.filters.VacuumFilter;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

/**
 * @author silent_rider
 */

public class FilterManager {
    
    private static Predicate commonFilters(CriteriaBuilder criteriaBuilder, 
    Root<? extends Model> root, Filter filter){
        List<Predicate> predicates = new ArrayList<>();
        var applianceJoin = root.join("appliance", JoinType.LEFT);
        if (StringUtils.hasText(filter.getApplianceName()))
            predicates.add(criteriaBuilder.like(
                    criteriaBuilder.lower(applianceJoin.get("name")),
                    "%" + filter.getApplianceName().toLowerCase() + "%"));
        if (StringUtils.hasText(filter.getModelName()))
            predicates.add(criteriaBuilder.like(
                    criteriaBuilder.lower(root.get("name")),
                    "%" + filter.getModelName().toLowerCase() + "%"));
        if (StringUtils.hasText(filter.getColor()))
            predicates.add(criteriaBuilder.equal(root.get("color"),
                    filter.getColor()));
        if (filter.getMinPrice() != null && filter.getMaxPrice() != null) {
            predicates.add(criteriaBuilder.between(
                    root.get("price"),
                    filter.getMinPrice(),
                    filter.getMaxPrice()));
        } else if (filter.getMinPrice() != null) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(
                    root.get("price"),
                    filter.getMinPrice()));
        } else if (filter.getMaxPrice() != null) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(
                    root.get("price"),
                    filter.getMaxPrice()));
        }
        return criteriaBuilder.and(predicates.toArray(Predicate[]::new));
    }

    public static Specification<Computer> byComputerFilter(ComputerFilter filter){
        return (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (StringUtils.hasText(filter.getCategory()))
                predicates.add(builder.equal(root.get("category"), filter.getCategory()));
            if (StringUtils.hasText(filter.getProcessorType()))
                predicates.add(builder.equal(root.get("processorType"),
                        filter.getProcessorType()));
            predicates.add(commonFilters(builder, root, filter));
            return builder.and(predicates.toArray(Predicate[]::new));
        };
    }

    public static Specification<Fridge> byFridgeFilter(FridgeFilter filter){
        return (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (filter.getDoorsCount() != null)
                predicates.add(builder.equal(root.get("doorsCount"), filter.getDoorsCount()));
            if (StringUtils.hasText(filter.getCompressorType()))
                predicates.add(builder.equal(root.get("compressorType"),
                    filter.getCompressorType()));
            predicates.add(commonFilters(builder, root, filter));
            return builder.and(predicates.toArray(Predicate[]::new));
        };
    }

    public static Specification<Smartphone> bySmartphoneFilter(SmartphoneFilter filter){
        return (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (filter.getMemory() != null)
                predicates.add(builder.equal(root.get("memory"), filter.getMemory()));
            if (filter.getCamerasCount() != null)
                predicates.add(builder.equal(root.get("camerasCount"), filter.getCamerasCount()));
            predicates.add(commonFilters(builder, root, filter));
            return builder.and(predicates.toArray(Predicate[]::new));
        };
    }

    public static Specification<TV> byTVFilter(TVFilter filter){
        return (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (StringUtils.hasText(filter.getCategory()))
                predicates.add(builder.equal(root.get("category"), filter.getCategory()));
            if (StringUtils.hasText(filter.getTechnology()))
                predicates.add(builder.equal(root.get("technology"),
                filter.getTechnology()));
            predicates.add(commonFilters(builder, root, filter));
            return builder.and(predicates.toArray(Predicate[]::new));
        };
    }

    public static Specification<Vacuum> byVacuumFilter(VacuumFilter filter){
        return (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (filter.getDustBagVolume() != null)
                predicates.add(builder.equal(root.get("dustBagVolume"), filter.getDustBagVolume()));
            if (filter.getModesCount() != null)
                predicates.add(builder.equal(root.get("modesCount"), filter.getModesCount()));
            predicates.add(commonFilters(builder, root, filter));
            return builder.and(predicates.toArray(Predicate[]::new));
        };
    }    
}
