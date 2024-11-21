package com.example.appliance_registry.model.entities.appliances;

import java.util.List;
import com.example.appliance_registry.model.entities.models.FridgeModel;
import jakarta.persistence.*;

/**
 * @author silent_rider
 */

@Entity
@Table(name = "fridges")
public class Fridge extends Appliance {
    
    @OneToMany(mappedBy = "fridge", cascade = CascadeType.ALL)
    private List<FridgeModel> models;

    public List<FridgeModel> getModels() {
        return models;
    }

    public void setModels(List<FridgeModel> models) {
        this.models = models;
    }
    
}
