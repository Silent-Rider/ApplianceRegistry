package com.example.appliance_registry.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.example.appliance_registry.model.entities.Model;
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
    
    public static Specification<Model> byFilters(Filter filter){
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            var applianceJoin = root.join("appliance", JoinType.LEFT);

            if (StringUtils.hasText(filter.getType())) {
                predicates.add(criteriaBuilder.equal(
                        criteriaBuilder.upper(applianceJoin.get("type")),
                        filter.getType()
                ));
                switch(filter.getType()){
                    case "COMPUTER" -> predicates.addAll(byComputerFilter(
                        (ComputerFilter)filter, criteriaBuilder, root));
                    case "FRIDGE" -> predicates.addAll(byFridgeFilter(
                        (FridgeFilter)filter, criteriaBuilder, root));
                    case "SMARTPHONE" -> predicates.addAll(bySmartphoneFilter(
                        (SmartphoneFilter)filter, criteriaBuilder, root));
                    case "TV" -> predicates.addAll(byTVFilter(
                        (TVFilter)filter, criteriaBuilder, root));
                    case "VACUUM" -> predicates.addAll(byVacuumFilter(
                        (VacuumFilter)filter, criteriaBuilder, root));
                }
            }

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
        };
    }

    private static List<Predicate> byComputerFilter(ComputerFilter filter, CriteriaBuilder builder,
    Root<Model> root){
        List<Predicate> predicates = new ArrayList<>();
        if (StringUtils.hasText(filter.getCategory()))
            predicates.add(builder.equal(root.get("category"), filter.getCategory()));
        if (StringUtils.hasText(filter.getProcessorType()))
            predicates.add(builder.equal(root.get("processorType"),
                    filter.getProcessorType()));
        return predicates;
    }

    private static List<Predicate> byFridgeFilter(FridgeFilter filter, CriteriaBuilder builder,
    Root<Model> root){
        List<Predicate> predicates = new ArrayList<>();
        if (filter.getDoorsCount() != null)
            predicates.add(builder.equal(root.get("doorsCount"), filter.getDoorsCount()));
        if (StringUtils.hasText(filter.getCompressorType()))
            predicates.add(builder.equal(root.get("compressorType"),
                    filter.getCompressorType()));
        return predicates;
    }

    private static List<Predicate> bySmartphoneFilter(SmartphoneFilter filter, CriteriaBuilder builder,
    Root<Model> root){
        List<Predicate> predicates = new ArrayList<>();
        if (filter.getMemory() != null)
            predicates.add(builder.equal(root.get("memory"), filter.getMemory()));
        if (filter.getCamerasCount() != null)
            predicates.add(builder.equal(root.get("camerasCount"), filter.getCamerasCount()));
        return predicates;
    }

    private static List<Predicate> byTVFilter(TVFilter filter, CriteriaBuilder builder,
    Root<Model> root){
        List<Predicate> predicates = new ArrayList<>();
        if (StringUtils.hasText(filter.getCategory()))
            predicates.add(builder.equal(root.get("category"), filter.getCategory()));
        if (StringUtils.hasText(filter.getTechnology()))
            predicates.add(builder.equal(root.get("technology"),
            filter.getTechnology()));
        return predicates;
    }

    private static List<Predicate> byVacuumFilter(VacuumFilter filter, CriteriaBuilder builder,
    Root<Model> root){
        List<Predicate> predicates = new ArrayList<>();
        if (filter.getDustBagVolume() != null)
            predicates.add(builder.equal(root.get("dustBagVolume"), filter.getDustBagVolume()));
        if (filter.getModesCount() != null)
            predicates.add(builder.equal(root.get("modesCount"), filter.getModesCount()));
        return predicates;
    }    
}
