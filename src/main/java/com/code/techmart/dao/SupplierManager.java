package com.code.techmart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.code.techmart.model.Supplier;

public class SupplierManager {
	
	public static Supplier getSupplierByID(int supplierID) throws ClassNotFoundException, SQLException{
		
		DbConnector connector = new DbConnectorImplMySQL();
		Connection connection = connector.getConnecion();
		
		String query = "SELECT * FROM techmart.suppliers WHERE supplierID=?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, supplierID);
		
		ResultSet rs = ps.executeQuery();
		
		Supplier supplier = new Supplier();
		
		if(rs.next()) {
			
			supplier.setSupplierID(rs.getInt("supplierID"));
			supplier.setfName(rs.getString("firstName"));
			supplier.setlName(rs.getString("lastName"));
			supplier.setContact(rs.getString("telno"));
			supplier.setBranch(rs.getString("location"));
			supplier.setEmail(rs.getString("email"));
			supplier.setPassword(rs.getString("password"));
		}
		
		rs.close();
		connection.close();
		
		return supplier;
	}
	
	public static List<Supplier> getAllSuppliers() throws ClassNotFoundException, SQLException{
		
		DbConnector connector = new DbConnectorImplMySQL();
		Connection connection = connector.getConnecion();
		
		String query = "SELECT * FROM techmart.suppliers";
		Statement st = connection.createStatement();
		
		ResultSet rs = st.executeQuery(query);
		
		List<Supplier> suppliers = new ArrayList<Supplier>();
		
		while(rs.next()) {
			Supplier supplier = new Supplier(rs.getInt("supplierID"), rs.getString("firstName"), 
					rs.getString("lastName"), rs.getString("location"), 
					rs.getString("telno"), rs.getString("email"), rs.getString("password"));
			
			suppliers.add(supplier);
		}
		
		st.close();
		connection.close();
	
		
		return suppliers;
	}
	
	 public static boolean addSupplier(Supplier supplier) throws ClassNotFoundException, SQLException {
		
		DbConnector connector = new DbConnectorImplMySQL();
		Connection connection = connector.getConnecion();
		
		String query = "INSERT INTO suppliers (firstName, lastName, location, telno, email, password) VALUES (?,?,?,?,?,?)";
		
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, supplier.getfName());
		ps.setString(2, supplier.getlName());
		ps.setString(4, supplier.getContact());
		ps.setString(3, supplier.getBranch());
		ps.setString(5, supplier.getEmail());
		ps.setString(6, supplier.getPassword());
		
		boolean result = ps.executeUpdate() >0;

		ps.close();
		connection.close();
		 
		 return result;
	 }
	 
	 public static boolean updateSupplier(Supplier supplier) throws ClassNotFoundException, SQLException {

		DbConnector connector = new DbConnectorImplMySQL();
		Connection connection = connector.getConnecion();

		String query = "UPDATE techmart.suppliers SET firstName=?, lastName=?, location=?, telno=?, email=?, password=? WHERE supplierID=?";

		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, supplier.getfName());
		ps.setString(2, supplier.getlName());
		ps.setString(4, supplier.getContact());
		ps.setString(3, supplier.getBranch());
		ps.setString(5, supplier.getEmail());
		ps.setString(6, supplier.getPassword());
		ps.setInt(7, supplier.getSupplierID());
		
		boolean result = ps.executeUpdate() >0;

		ps.close();
		connection.close();
		 
		 return result;
	 }
	 
	 public static boolean deleteSupplier(int supplierID) throws ClassNotFoundException, SQLException {
		
		DbConnector connector = new DbConnectorImplMySQL();
		Connection connection = connector.getConnecion();

		String query = "DELETE FROM suppliers WHERE supplierID=?";
		PreparedStatement ps = connection.prepareStatement(query);

		ps.setInt(1, supplierID);

		boolean result = ps.executeUpdate() > 0;

		ps.close();
		connection.close();

		 return result;
	 }

	 public static Supplier searchuser(String username, String password) throws SQLException, ClassNotFoundException {
		 
		DbConnector connector = new DbConnectorImplMySQL();
		Connection connection = connector.getConnecion();
		
		String query = "SELECT * FROM techmart.suppliers WHERE email=? AND password=?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, username);
		ps.setString(2, password);
		
		ResultSet rs = ps.executeQuery();
	
		Supplier supplier = null;
		if(rs.next()) {
			supplier = new Supplier();
			supplier.setSupplierID(rs.getInt("supplierID"));
			supplier.setfName(rs.getString("firstName"));
			supplier.setlName(rs.getString("lastName"));
			supplier.setContact(rs.getString("telno"));
			supplier.setBranch(rs.getString("location"));
			supplier.setEmail(rs.getString("email"));
			supplier.setPassword(rs.getString("password"));
		}
		
		ps.close();
		connection.close();
		
		return supplier;
 }

}
