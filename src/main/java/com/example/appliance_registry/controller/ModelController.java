package com.example.appliance_registry.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import com.example.appliance_registry.model.entities.Appliance;
import com.example.appliance_registry.model.entities.Model;
import com.example.appliance_registry.model.entities.Type;
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
    @PostMapping("/models/get")    
    public ResponseEntity<Page<? extends Model>> search(@RequestBody Filter filter,
            @RequestParam(required = false) String sortColumn,
            @RequestParam(required = false, defaultValue = "ASC") String sortDirection,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "30") int size){
                Sort sort;
                if(StringUtils.hasText(sortColumn)){
                    sort = Sort.by(sortColumn);
                    sort = sortDirection.equalsIgnoreCase("DESC") ? sort.descending() : sort.ascending();
                }
                else sort = Sort.by("id").ascending();
                PageRequest pageRequest = PageRequest.of(page, size, sort);
                Page<? extends Model> models = null;
                String type = filter.getType();
                if(type != null && StringUtils.hasText(type)){
                    type = type.toUpperCase();
                    switch(type){
                        case "COMPUTER" -> {
                            var spec = FilterManager.byComputerFilter((ComputerFilter)filter);
                            models = modelService.findAllComputers(spec, pageRequest);
                        }
                        case "FRIDGE" -> {
                            var spec = FilterManager.byFridgeFilter((FridgeFilter)filter);
                            models = modelService.findAllFridges(spec, pageRequest);
                        }
                        case "SMARTPHONE" -> {
                            var spec = FilterManager.bySmartphoneFilter((SmartphoneFilter)filter);
                            models = modelService.findAllSmartphones(spec, pageRequest);
                        }
                        case "TV" -> {
                            var spec = FilterManager.byTVFilter((TVFilter)filter);
                            models = modelService.findAllTVs(spec, pageRequest);
                        }
                        case "VACUUM" -> {
                            var spec = FilterManager.byVacuumFilter((VacuumFilter)filter);
                            models = modelService.findAllVacuums(spec, pageRequest);
                        }
                    } 
                } else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
                return ResponseEntity.ok(models);

    }

    @Operation(summary = "Добавить новую модель прибора",
            description = "Добавляет новый модель прибора по указанному в пути типу прибора и " +
            "наименованию линейки, указанной в качестве параметра запроса",
            responses = {
                @ApiResponse(responseCode = "201", description = "Модель успешно добавлена в БД"),
                @ApiResponse(responseCode = "400", description = "Неверный тип прибора")
            })
    @PostMapping("/models/post")   
    public ResponseEntity<Model> addModel(@RequestBody Model model){
        String type = model.getType().toUpperCase().trim();
        String applianceName = model.getApplianceName();
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
