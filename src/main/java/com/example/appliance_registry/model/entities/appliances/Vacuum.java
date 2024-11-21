package com.example.appliance_registry.model.entities.appliances;

import java.util.List;
import com.example.appliance_registry.model.entities.models.VacuumModel;
import jakarta.persistence.*;

/**
 * @author silent_rider
 */

@Entity
@Table(name = "vacuums")
public class Vacuum extends Appliance {
    
    @OneToMany(mappedBy = "vacuum", cascade = CascadeType.ALL)
    private List<VacuumModel> models;

    public List<VacuumModel> getModels() {
        return models;
    }

    public void setModels(List<VacuumModel> models) {
        this.models = models;
    }
}
