package com.example.appliance_registry.model.entities;

import jakarta.persistence.*;

/**
 * @author silent_rider
 */

@Entity
@Table(name = "models")
public class Model {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(name = "serial_number", nullable = false, unique = true)
    private String serialNumber;

    @Column(nullable = false)
    private String color;

    @Column(columnDefinition = "VARCHAR(50)", nullable = false)
    private String size;

    @Column(nullable = false)
    private Integer price;

    @Column(name = "in_stock", nullable = false)
    private Boolean inStock;

    @ManyToOne
    @JoinColumn(name = "appliance_id", nullable = false)
    private Appliance appliance;

    @Column(nullable = true)
    private String category;

    @Column(name = "processor_type", nullable = true)
    private String processorType;

    @Column(name = "doors_count", nullable = true)
    private Integer doorsCount;

    @Column(name = "compressor_type", nullable = true)
    private String compressorType;

    @Column(nullable = true)
    private Integer memory;

    @Column(name = "cameras_count", nullable = true)
    private Integer camerasCount;

    @Column(nullable = true)
    private String technology;

    @Column(name = "dust_bag_volume", nullable = true)
    private Double dustBagVolume;

    @Column(name = "modes_count", nullable = true)
    private Integer modesCount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Boolean getInStock() {
        return inStock;
    }

    public void setInStock(Boolean inStock) {
        this.inStock = inStock;
    }

    public Appliance getAppliance() {
        return appliance;
    }

    public void setAppliance(Appliance appliance) {
        this.appliance = appliance;
    }

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

    public Integer getDoorsCount() {
        return doorsCount;
    }

    public void setDoorsCount(Integer doorsCount) {
        this.doorsCount = doorsCount;
    }

    public String getCompressorType() {
        return compressorType;
    }

    public void setCompressorType(String compressorType) {
        this.compressorType = compressorType;
    }

    public Integer getMemory() {
        return memory;
    }

    public void setMemory(Integer memory) {
        this.memory = memory;
    }

    public Integer getCamerasCount() {
        return camerasCount;
    }

    public void setCamerasCount(Integer camerasCount) {
        this.camerasCount = camerasCount;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

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
}
