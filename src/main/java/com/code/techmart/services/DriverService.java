package com.code.techmart.services;

import java.sql.SQLException;
import java.util.List;

import com.code.techmart.dao.DriverManager;
import com.code.techmart.model.Driver;

public class DriverService {

	public Driver getDriverByID(int driverID) throws ClassNotFoundException, SQLException {
		return DriverManager.getDriverByID(driverID);
	}
	
	public List<Driver> getAllDrivers() throws ClassNotFoundException, SQLException{
	
		return DriverManager.getAllDrivers();
	}
	
	public boolean addDriver(Driver driver) throws ClassNotFoundException, SQLException {
		
		return DriverManager.addDriver(driver);
	}
	
	public boolean updateDriver(Driver driver) throws ClassNotFoundException, SQLException {
		
		return DriverManager.updateDriver(driver);
	}
	
	public boolean deleteDriver(int driverID) throws ClassNotFoundException, SQLException {
		
		return DriverManager.deleteDriver(driverID);
	}
	
}
