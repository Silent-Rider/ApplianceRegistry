package com.example.appliance_registry.model.entities.appliances;

import java.util.List;
import com.example.appliance_registry.model.entities.models.TVModel;
import jakarta.persistence.*;

/**
 * @author silent_rider
 */

@Entity
@Table(name = "tvs")
public class TV extends Appliance {
    
    @OneToMany(mappedBy = "tv", cascade = CascadeType.ALL)
    private List<TVModel> models;

    public List<TVModel> getModels() {
        return models;
    }

    public void setModels(List<TVModel> models) {
        this.models = models;
    }
}
