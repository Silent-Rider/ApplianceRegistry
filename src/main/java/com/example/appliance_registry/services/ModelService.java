package com.example.appliance_registry.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.example.appliance_registry.model.entities.Model;
import com.example.appliance_registry.model.repositories.ModelRepository;

@Service
public class ModelService {

    private final ModelRepository modelRepository;

    public ModelService(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    public Page<Model> findAllModels(Specification<Model> spec, PageRequest pageRequest){
        return modelRepository.findAll(spec, pageRequest);
    }

    public Model saveModel(Model model) {
        return modelRepository.save(model);
    }
}
