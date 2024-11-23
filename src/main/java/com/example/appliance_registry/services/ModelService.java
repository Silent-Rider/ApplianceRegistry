package com.example.appliance_registry.services;

import org.springframework.stereotype.Service;

import com.example.appliance_registry.model.entities.Model;
import com.example.appliance_registry.model.repositories.ModelRepository;

@Service
public class ModelService {

    private final ModelRepository modelRepository;

    public ModelService(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    public Model saveModel(Model model) {
        return modelRepository.save(model);
    }
}
