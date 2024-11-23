package com.example.appliance_registry.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.example.appliance_registry.model.entities.Model;

import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;

/**
 * @author silent_rider
 */

public class ModelSpecification {
    
    public static Specification<Model> byFilters(
        String type,
        String applianceName,
        String modelName,
        String color,
        Integer minPrice,
        Integer maxPrice,
        String category,
        String processorType,
        Integer doorsCount,
        String compressorType,
        Integer memory,
        Integer camerasCount,
        String technology,
        Double dustBagVolume,
        Integer modesCount
    ) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            var applianceJoin = root.join("appliance", JoinType.LEFT);

            if (StringUtils.hasText(type)) {
                predicates.add(criteriaBuilder.equal(
                        criteriaBuilder.upper(applianceJoin.get("type")),
                        type.toUpperCase()
                ));
            }
            if (StringUtils.hasText(applianceName)) {
                predicates.add(criteriaBuilder.like(
                        criteriaBuilder.lower(applianceJoin.get("name")),
                        "%" + applianceName.toLowerCase() + "%"
                ));
            }
            if (StringUtils.hasText(modelName)) {
                predicates.add(criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("name")),
                        "%" + modelName.toLowerCase() + "%"
                ));
            }
            if (StringUtils.hasText(color)) {
                predicates.add(criteriaBuilder.equal(
                        root.get("color"),
                        color
                ));
            }
            if (minPrice != null && maxPrice != null) {
                predicates.add(criteriaBuilder.between(
                        root.get("price"),
                        minPrice,
                        maxPrice
                ));
            } else if (minPrice != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(
                        root.get("price"),
                        minPrice
                ));
            } else if (maxPrice != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(
                        root.get("price"),
                        maxPrice
                ));
            }
            if (StringUtils.hasText(category)) {
                predicates.add(criteriaBuilder.equal(
                        root.get("category"),
                        category
                ));
            }
            if (StringUtils.hasText(processorType)) {
                predicates.add(criteriaBuilder.equal(
                        root.get("processorType"),
                        processorType
                ));
            }
            if (doorsCount != null) {
                predicates.add(criteriaBuilder.equal(
                        root.get("doorsCount"),
                        doorsCount
                ));
            }
            if (StringUtils.hasText(compressorType)) {
                predicates.add(criteriaBuilder.equal(
                        root.get("compressorType"),
                        compressorType
                ));
            }
            if (memory != null) {
                predicates.add(criteriaBuilder.equal(
                        root.get("memory"),
                        memory
                ));
            }

            if (camerasCount != null) {
                predicates.add(criteriaBuilder.equal(
                        root.get("camerasCount"),
                        camerasCount
                ));
            }

            if (StringUtils.hasText(technology)) {
                predicates.add(criteriaBuilder.equal(
                        root.get("technology"),
                        technology
                ));
            }

            if (dustBagVolume != null) {
                predicates.add(criteriaBuilder.equal(
                        root.get("dustBagVolume"),
                        dustBagVolume
                ));
            }

            if (modesCount != null) {
                predicates.add(criteriaBuilder.equal(
                        root.get("modesCount"),
                        modesCount
                ));
            }

            // Возвращаем конъюнкцию (AND) всех предикатов
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
