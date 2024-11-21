package com.example.appliance_registry.model.entities.appliances;

import java.util.List;
import com.example.appliance_registry.model.entities.models.ComputerModel;
import jakarta.persistence.*;

/**
 * @author silent_rider
 */

@Entity
@Table(name = "computers")
public class Computer extends Appliance {

    @OneToMany(mappedBy = "computer", cascade = CascadeType.ALL)
    private List<ComputerModel> models;

    public List<ComputerModel> getModels() {
        return models;
    }

    public void setModels(List<ComputerModel> models) {
        this.models = models;
    }    
}
