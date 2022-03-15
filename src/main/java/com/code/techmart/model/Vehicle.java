package com.code.techmart.model;

public class Vehicle {

    private String VehicleLicenseNo;
    private String Model;
    private String branch;

    public Vehicle(){

    }

    public Vehicle(String vehicleLicenseNo, String model, String branch) {
        VehicleLicenseNo = vehicleLicenseNo;
        Model = model;
        this.branch = branch;
    }

    public String getVehicleLicenseNo() {
        return VehicleLicenseNo;
    }

    public void setVehicleLicenseNo(String vehicleLicenseNo) {
        VehicleLicenseNo = vehicleLicenseNo;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    
}
