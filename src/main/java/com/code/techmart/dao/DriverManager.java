package com.code.techmart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.code.techmart.model.Driver;

public class DriverManager {
	
	public static Driver getDriverByID(int driverID) throws ClassNotFoundException, SQLException{
		
		DbConnector connector = new DbConnectorImplMySQL();
		Connection connection = connector.getConnecion();
		
		String query = "SELECT * FROM techmart.drivers WHERE driverID=?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, driverID);
		
		ResultSet rs = ps.executeQuery();
		
		Driver driver = new Driver();
		
		if(rs.next()) {
			
			driver.setDriverID(rs.getInt("driverID"));
			driver.setfName(rs.getString("firstName"));
			driver.setlName(rs.getString("lastName"));
			driver.setAddress(rs.getString("address"));
			driver.setContact(rs.getString("telno"));
			driver.setBranch(rs.getString("location"));
		}
		
		rs.close();
		connection.close();
		
		return driver;
	}
	
	public static List<Driver> getAllDrivers() throws ClassNotFoundException, SQLException{
		
		DbConnector connector = new DbConnectorImplMySQL();
		Connection connection = connector.getConnecion();
		
		String query = "SELECT * FROM techmart.drivers";
		Statement st = connection.createStatement();
		
		ResultSet rs = st.executeQuery(query);
		
		List<Driver> drivers = new ArrayList<Driver>();
		
		while(rs.next()) {
			Driver driver = new Driver(rs.getInt("driverID"), rs.getString("firstName"), 
					rs.getString("lastName"), rs.getString("location"), rs.getString("address"), 
					rs.getString("telno"));
			
			drivers.add(driver);
		}
		
		st.close();
		connection.close();
	
		
		return drivers;
	}
	
	 public static boolean addDriver(Driver driver) throws ClassNotFoundException, SQLException {
		
		DbConnector connector = new DbConnectorImplMySQL();
		Connection connection = connector.getConnecion();
		
		String query = "INSERT INTO drivers (firstName, lastName, location, address, telno) VALUES (?,?,?,?,?)";
		
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, driver.getfName());
		ps.setString(2, driver.getlName());
		ps.setString(4, driver.getAddress());
		ps.setString(5, driver.getContact());
		ps.setString(3, driver.getBranch());
		
		boolean result = ps.executeUpdate() >0;

		ps.close();
		connection.close();
		 
		 return result;
	 }
	 
	 public static boolean updateDriver(Driver driver) throws ClassNotFoundException, SQLException {

		DbConnector connector = new DbConnectorImplMySQL();
		Connection connection = connector.getConnecion();

		String query = "UPDATE techmart.drivers SET firstName=?, lastName=?, location=?, address=?, telno=? WHERE driverID=?";

		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, driver.getfName());
		ps.setString(2, driver.getlName());
		ps.setString(4, driver.getAddress());
		ps.setString(5, driver.getContact());
		ps.setString(3, driver.getBranch());
		ps.setInt(6, driver.getDriverID());
		
		boolean result = ps.executeUpdate() >0;

		ps.close();
		connection.close();
		 
		 return result;
	 }
	 
	 public static boolean deleteDriver(int driverID) throws ClassNotFoundException, SQLException {
		
		DbConnector connector = new DbConnectorImplMySQL();
		Connection connection = connector.getConnecion();

		String query = "DELETE FROM drivers WHERE driverID=?";
		PreparedStatement ps = connection.prepareStatement(query);

		ps.setInt(1, driverID);

		boolean result = ps.executeUpdate() > 0;

		ps.close();
		connection.close();

		 return result;
	 }

}
