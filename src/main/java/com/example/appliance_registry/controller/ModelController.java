package com.example.appliance_registry.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.appliance_registry.model.FilterManager;
import com.example.appliance_registry.model.entities.Appliance;
import com.example.appliance_registry.model.entities.Model;
import com.example.appliance_registry.model.filters.ComputerFilter;
import com.example.appliance_registry.model.filters.Filter;
import com.example.appliance_registry.model.filters.FridgeFilter;
import com.example.appliance_registry.model.filters.SmartphoneFilter;
import com.example.appliance_registry.model.filters.TVFilter;
import com.example.appliance_registry.model.filters.VacuumFilter;
import com.example.appliance_registry.services.ApplianceService;
import com.example.appliance_registry.services.ModelService;

/**
 * @author silent_rider
 */
@RequestMapping("/registry")
@RestController
public class ModelController {

    private final ModelService modelService;
    private final ApplianceService applianceService;    

    public ModelController(ModelService modelService, ApplianceService applianceService) {
        this.modelService = modelService;
        this.applianceService = applianceService;
    }
    @GetMapping("/models")    
    public ResponseEntity<Page<Model>> search( @RequestParam(required = false) String applianceName,
            @RequestParam(required = false) String modelName,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String color,
            @RequestParam(required = false) Integer minPrice,
            @RequestParam(required = false) Integer maxPrice,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String processorType,
            @RequestParam(required = false) Integer doorsCount,
            @RequestParam(required = false) String compressorType,
            @RequestParam(required = false) Integer memory,
            @RequestParam(required = false) Integer camerasCount,
            @RequestParam(required = false) String technology,
            @RequestParam(required = false) Double dustBagVolume,
            @RequestParam(required = false) Integer modesCount,
            @RequestParam(required = false) String sortColumn,
            @RequestParam(required = false) String sortDirection,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size){
                Filter filter = new Filter(type, applianceName, modelName, color, minPrice, maxPrice);
                if(type != null && StringUtils.hasText(type)){
                    type = type.toUpperCase();
                    switch(type){
                        case "COMPUTER" -> filter = new ComputerFilter(type, applianceName, modelName, 
                        color, minPrice, maxPrice, category, processorType);
                        case "FRIDGE" -> filter = new FridgeFilter(type, applianceName, modelName, 
                        color, minPrice, maxPrice, doorsCount, compressorType);
                        case "SMARTPHONE" -> filter = new SmartphoneFilter(type, applianceName, 
                        modelName, color, minPrice, maxPrice, memory, camerasCount);
                        case "TV" -> filter = new TVFilter(type, applianceName, modelName, 
                        color, minPrice, maxPrice, category, technology);
                        case "VACUUM" -> filter = new VacuumFilter(type, applianceName, modelName, 
                        color, minPrice, maxPrice, dustBagVolume, modesCount);
                    }
                }
                Specification<Model> spec = FilterManager.byFilters(filter);
                Sort sort = Sort.by(sortColumn);
                sort = sortDirection.equalsIgnoreCase("DESC") ? sort.descending() : sort.ascending();
                PageRequest pageRequest = PageRequest.of(page, size, sort);
                Page<Model> models = modelService.findAll(spec, pageRequest);
                return ResponseEntity.ok(models);

    }

    @PostMapping("/{type}/{applianceName}/models")   
    public ResponseEntity<String> addModel(@PathVariable("type") String type,
    @PathVariable("applianceName") String applianceName, @RequestBody String entity){
        Appliance appliance = applianceService.getApplianceByTypeAndName(type, applianceName);
        
    }
}
