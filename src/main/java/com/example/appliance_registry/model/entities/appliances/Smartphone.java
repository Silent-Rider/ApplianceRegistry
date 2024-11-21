package com.example.appliance_registry.model.entities.appliances;

import java.util.List;
import com.example.appliance_registry.model.entities.models.SmartphoneModel;
import jakarta.persistence.*;

/**
 * @author silent_rider
 */

@Entity
@Table(name = "smartphones")
public class Smartphone extends Appliance {

    @OneToMany(mappedBy = "smartphone", cascade = CascadeType.ALL)
    private List<SmartphoneModel> models;

    public List<SmartphoneModel> getModels() {
        return models;
    }

    public void setModels(List<SmartphoneModel> models) {
        this.models = models;
    }
    
} 
