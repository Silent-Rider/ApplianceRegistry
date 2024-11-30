package com.example.appliance_registry.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import com.example.appliance_registry.dto.*;
import com.example.appliance_registry.model.entities.Appliance;
import com.example.appliance_registry.model.entities.Type;
import com.example.appliance_registry.model.entities.Model;
import com.example.appliance_registry.services.ApplianceService;
import com.example.appliance_registry.services.FilterManager;
import com.example.appliance_registry.services.ModelService;
import com.example.appliance_registry.services.filters.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

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
    @Operation(summary = "Поиск моделей приборов",
           description = "Позволяет искать модели по различным фильтрам.",
           responses = {
               @ApiResponse(responseCode = "200", description = "Результаты поиска моделей"),
               @ApiResponse(responseCode = "400", description = "Неверные параметры запроса")
           })
    @PostMapping("/models")    
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
            @RequestParam(required = false, defaultValue = "ASC") String sortDirection,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "30") int size){
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
                Sort sort;
                if(StringUtils.hasText(sortColumn)){
                    sort = Sort.by(sortColumn);
                    sort = sortDirection.equalsIgnoreCase("DESC") ? sort.descending() : sort.ascending();
                }
                else sort = Sort.by("id").ascending();
                PageRequest pageRequest = PageRequest.of(page, size, sort);
                Page<Model> models = modelService.findAllModels(spec, pageRequest);
                return ResponseEntity.ok(models);

    }

    @Operation(summary = "Добавить новую модель прибора",
            description = "Добавляет новый модель прибора по указанному в пути типу прибора и " +
            "наименованию линейки, указанной в качестве параметра запроса",
            responses = {
                @ApiResponse(responseCode = "201", description = "Модель успешно добавлена в БД"),
                @ApiResponse(responseCode = "400", description = "Неверный тип прибора")
            })
    @PostMapping("/models")   
    public ResponseEntity<Model> addModel(@RequestParam String applianceName, @RequestBody Model model){
        String type = model.getType().toUpperCase().trim();
        Type applianceType;
        Model savedModel;
        try{
            applianceType = Type.valueOf(type);
            Appliance appliance = applianceService.getApplianceByTypeAndName(applianceType, applianceName);
            if (appliance == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            model.setAppliance(appliance);
            savedModel = modelService.saveModel(model);
        } catch (IllegalArgumentException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(savedModel, HttpStatus.CREATED);
    }
}
