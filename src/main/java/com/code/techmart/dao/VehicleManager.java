package com.code.techmart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.code.techmart.model.Vehicle;

public class VehicleManager {
	
	public static Vehicle getVehicleByID(String vehicleID) throws ClassNotFoundException, SQLException{
		
		DbConnector connector = new DbConnectorImplMySQL();
		Connection connection = connector.getConnecion();
		
		String query = "SELECT * FROM techmart.vehicles WHERE vehicleID=?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, vehicleID);
		
		ResultSet rs = ps.executeQuery();
		
		Vehicle vehicle = new Vehicle();
		
		if(rs.next()) {
			
			vehicle.setVehicleLicenseNo(rs.getString("vehicleID"));
			vehicle.setModel(rs.getString("model"));
			vehicle.setBranch(rs.getString("location"));
		}
		
		rs.close();
		connection.close();
		
		return vehicle;
	}
	
	public static List<Vehicle> getAllVehicles() throws ClassNotFoundException, SQLException{
		
		DbConnector connector = new DbConnectorImplMySQL();
		Connection connection = connector.getConnecion();
		
		String query = "SELECT * FROM techmart.vehicles";
		Statement st = connection.createStatement();
		
		ResultSet rs = st.executeQuery(query);
		
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		
		while(rs.next()) {
			Vehicle vehicle = new Vehicle(rs.getString("vehicleID"), rs.getString("model"), 
					rs.getString("location"));
			
			vehicles.add(vehicle);
		}
		
		st.close();
		connection.close();
	
		
		return vehicles;
	}
	
	 public static boolean addVehicle(Vehicle vehicle) throws ClassNotFoundException, SQLException {
		
		DbConnector connector = new DbConnectorImplMySQL();
		Connection connection = connector.getConnecion();
		
		String query = "INSERT INTO vehicles (vehicleID, model, location) VALUES (?,?,?)";
		
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, vehicle.getVehicleLicenseNo());
		ps.setString(2, vehicle.getModel());
		ps.setString(3, vehicle.getBranch());
		
		boolean result = ps.executeUpdate() >0;

		ps.close();
		connection.close();
		 
		 return result;
	 }
	 
	 public static boolean updateVehicle(Vehicle vehicle) throws ClassNotFoundException, SQLException {

		DbConnector connector = new DbConnectorImplMySQL();
		Connection connection = connector.getConnecion();

		String query = "UPDATE techmart.vehicles SET vehicleID=?, model=?, location=? WHERE vehicleID=?";

		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, vehicle.getVehicleLicenseNo());
		ps.setString(2, vehicle.getModel());
		ps.setString(3, vehicle.getBranch());
		ps.setString(4, vehicle.getVehicleLicenseNo());
		
		boolean result = ps.executeUpdate() >0;

		ps.close();
		connection.close();
		 
		 return result;
	 }
	 
	 public static boolean deleteVehicle(String vehicleID) throws ClassNotFoundException, SQLException {
		
		DbConnector connector = new DbConnectorImplMySQL();
		Connection connection = connector.getConnecion();

		String query = "DELETE FROM vehicles WHERE vehicleID=?";
		PreparedStatement ps = connection.prepareStatement(query);

		ps.setString(1, vehicleID);

		boolean result = ps.executeUpdate() > 0;

		ps.close();
		connection.close();

		 return result;
	 }

}
