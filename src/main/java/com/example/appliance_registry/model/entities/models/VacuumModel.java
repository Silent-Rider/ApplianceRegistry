package com.example.appliance_registry.model.entities.models;

import com.example.appliance_registry.model.entities.appliances.Vacuum;

import jakarta.persistence.*;

/**
 * @author silent_rider
 */

@Entity
@Table(name = "vacuum_models")
public class VacuumModel extends Model {

    @Column(name = "dust_bag_volume", nullable = false)
    private Double dustBagVolume;

    @Column(name = "modes_count", nullable = false)
    private Integer modesCount;

    @ManyToOne
    @JoinColumn(name = "vacuum_id", nullable = false)
    private Vacuum vacuum;

    public Double getDustBagVolume() {
        return dustBagVolume;
    }

    public void setDustBagVolume(Double dustBagVolume) {
        this.dustBagVolume = dustBagVolume;
    }

    public Integer getModesCount() {
        return modesCount;
    }

    public void setModesCount(Integer modesCount) {
        this.modesCount = modesCount;
    }

    public Vacuum getVacuum() {
        return vacuum;
    }

    public void setVacuum(Vacuum vacuum) {
        this.vacuum = vacuum;
    }
}
