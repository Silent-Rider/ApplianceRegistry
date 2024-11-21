package com.example.appliance_registry.model.entities.models;

import com.example.appliance_registry.model.entities.appliances.Computer;

import jakarta.persistence.*;

/**
 * @author silent_rider
 */

@Entity
@Table(name = "computer_models")
public class ComputerModel extends Model {

    @Column(nullable = false)
    private String category;

    @Column(name = "processor_type", nullable = false)
    private String processorType;

    @ManyToOne
    @JoinColumn(name = "computer_id", nullable = false)
    private Computer computer;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProcessorType() {
        return processorType;
    }

    public void setProcessorType(String processorType) {
        this.processorType = processorType;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }
}
