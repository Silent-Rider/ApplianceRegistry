package com.example.appliance_registry.dto;

import com.example.appliance_registry.model.entities.Model;

public abstract class ModelDTO {
    
    private String applianceType;
    private String applianceName;
    private String name;
    private String serialNumber;
    private String color;
    private String size;
    private Integer price;
    private Boolean inStock;

    public void loadFromModel(Model model){
        this.applianceType = model.getAppliance().getType().toString();
        this.applianceName = model.getAppliance().getName();
        this.name = model.getName();
        this.serialNumber = model.getSerialNumber();
        this.color = model.getColor();
        this.size = model.getSize();
        this.price = model.getPrice();
        this.inStock = model.getInStock();
    }

    public String getApplianceType() {
        return applianceType;
    }

    public void setApplianceType(String applianceType) {
        this.applianceType = applianceType;
    }

    public String getApplianceName() {
        return applianceName;
    }

    public void setApplianceName(String applianceName) {
        this.applianceName = applianceName;
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
}
