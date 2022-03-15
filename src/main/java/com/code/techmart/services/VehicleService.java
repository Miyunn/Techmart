package com.code.techmart.services;

import java.sql.SQLException;
import java.util.List;

import com.code.techmart.dao.VehicleManager;
import com.code.techmart.model.Vehicle;

public class VehicleService {

	public Vehicle getVehicleByID(String vehicleID) throws ClassNotFoundException, SQLException {
		return VehicleManager.getVehicleByID(vehicleID);
	}
	
	public List<Vehicle> getAllVehicles() throws ClassNotFoundException, SQLException{
	
		return VehicleManager.getAllVehicles();
	}
	
	public boolean addVehicle(Vehicle vehicle) throws ClassNotFoundException, SQLException {
		
		return VehicleManager.addVehicle(vehicle);
	}
	
	public boolean updateVehicle(Vehicle vehicle) throws ClassNotFoundException, SQLException {
		
		return VehicleManager.updateVehicle(vehicle);
	}
	
	public boolean deleteVehicle(String vehicleID) throws ClassNotFoundException, SQLException {
		
		return VehicleManager.deleteVehicle(vehicleID);
	}
	
}
