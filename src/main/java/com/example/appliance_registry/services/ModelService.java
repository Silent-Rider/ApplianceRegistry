package com.example.appliance_registry.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.example.appliance_registry.model.entities.Model;
import com.example.appliance_registry.model.entities.models.Computer;
import com.example.appliance_registry.model.entities.models.Fridge;
import com.example.appliance_registry.model.entities.models.Smartphone;
import com.example.appliance_registry.model.entities.models.TV;
import com.example.appliance_registry.model.entities.models.Vacuum;
import com.example.appliance_registry.model.repositories.ComputerRepository;
import com.example.appliance_registry.model.repositories.FridgeRepository;
import com.example.appliance_registry.model.repositories.SmartphoneRepository;
import com.example.appliance_registry.model.repositories.TVRepository;
import com.example.appliance_registry.model.repositories.VacuumRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class ModelService {

    private final ComputerRepository computerRepository;
    private final FridgeRepository fridgeRepository;
    private final TVRepository tvRepository;
    private final SmartphoneRepository smartphoneRepository;
    private final VacuumRepository vacuumRepository;

    public Page<Computer> findAllComputers(Specification<Computer> spec, PageRequest pageRequest){
        return computerRepository.findAll(spec, pageRequest);
    }

    public Page<Fridge> findAllFridges(Specification<Fridge> spec, PageRequest pageRequest){
        return fridgeRepository.findAll(spec, pageRequest);
    }

    public Page<TV> findAllTVs(Specification<TV> spec, PageRequest pageRequest){
        return tvRepository.findAll(spec, pageRequest);
    }

    public Page<Smartphone> findAllSmartphones(Specification<Smartphone> spec, PageRequest pageRequest){
        return smartphoneRepository.findAll(spec, pageRequest);
    }

    public Page<Vacuum> findAllVacuums(Specification<Vacuum> spec, PageRequest pageRequest){
        return vacuumRepository.findAll(spec, pageRequest);
    }

    public Model saveModel(Model model) {
        Model savedModel;
        switch(model){
            case Computer computer -> savedModel = computerRepository.save(computer);
            case Fridge fridge -> savedModel = fridgeRepository.save(fridge);
            case TV tv -> savedModel = tvRepository.save(tv);
            case Smartphone smartphone -> savedModel = smartphoneRepository.save(smartphone);
            case Vacuum vacuum -> savedModel = vacuumRepository.save(vacuum);
            default -> {
                log.error("Unknown type of appliance");
                throw new IllegalArgumentException();
            }
        }
        return savedModel;
    }
}
