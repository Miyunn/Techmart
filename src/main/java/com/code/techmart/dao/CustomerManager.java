package com.code.techmart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.code.techmart.model.Customer;

public class CustomerManager {
	
	public static Customer getCustomerByID(int customerID) throws ClassNotFoundException, SQLException{
		
		DbConnector connector = new DbConnectorImplMySQL();
		Connection connection = connector.getConnecion();
		
		String query = "SELECT * FROM techmart.customers WHERE customerID=?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, customerID);
		
		ResultSet rs = ps.executeQuery();
		
		Customer customer = new Customer();
		
		if(rs.next()) {
			
			customer.setCustomerID(rs.getInt("customerID"));
			customer.setfName(rs.getString("firstName"));
			customer.setlName(rs.getString("lastName"));
			customer.setAddress(rs.getString("address"));
			customer.setContact(rs.getString("telno"));
			customer.setBranch(rs.getString("location"));
			customer.setEmail(rs.getString("email"));
			customer.setPassword(rs.getString("password"));
		}
		
		rs.close();
		connection.close();
		
		return customer;
	}
	
	public static List<Customer> getAllCustomers() throws ClassNotFoundException, SQLException{
		
		DbConnector connector = new DbConnectorImplMySQL();
		Connection connection = connector.getConnecion();
		
		String query = "SELECT * FROM techmart.customers";
		Statement st = connection.createStatement();
		
		ResultSet rs = st.executeQuery(query);
		
		List<Customer> customers = new ArrayList<Customer>();
		
		while(rs.next()) {
			Customer customer = new Customer(rs.getInt("customerID"), rs.getString("firstName"), 
					rs.getString("lastName"), rs.getString("location"), rs.getString("address"), 
					rs.getString("telno"), rs.getString("email"), rs.getString("password"));
			
			customers.add(customer);
		}
		
		st.close();
		connection.close();
	
		
		return customers;
	}
	
	 public static boolean addCustomer(Customer customer) throws ClassNotFoundException, SQLException {
		
		DbConnector connector = new DbConnectorImplMySQL();
		Connection connection = connector.getConnecion();
		
		String query = "INSERT INTO customers (firstName, lastName, location, address, telno, email, password) VALUES (?,?,?,?,?,?,?)";
		
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, customer.getfName());
		ps.setString(2, customer.getlName());
		ps.setString(4, customer.getAddress());
		ps.setString(5, customer.getContact());
		ps.setString(3, customer.getBranch());
		ps.setString(6, customer.getEmail());
		ps.setString(7, customer.getPassword());
		
		boolean result = ps.executeUpdate() >0;

		ps.close();
		connection.close();
		 
		 return result;
	 }
	 
	 public static boolean updateCustomer(Customer customer) throws ClassNotFoundException, SQLException {

		DbConnector connector = new DbConnectorImplMySQL();
		Connection connection = connector.getConnecion();

		String query = "UPDATE techmart.customers SET firstName=?, lastName=?, location=?, address=?, telno=?, email=?, password=? WHERE customerID=?";

		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, customer.getfName());
		ps.setString(2, customer.getlName());
		ps.setString(4, customer.getAddress());
		ps.setString(5, customer.getContact());
		ps.setString(3, customer.getBranch());
		ps.setString(6, customer.getEmail());
		ps.setString(7, customer.getPassword());
		ps.setInt(8, customer.getCustomerID());
		
		boolean result = ps.executeUpdate() >0;

		ps.close();
		connection.close();
		 
		 return result;
	 }
	 
	 public static boolean deleteCustomer(int customerID) throws ClassNotFoundException, SQLException {
		
		DbConnector connector = new DbConnectorImplMySQL();
		Connection connection = connector.getConnecion();

		String query = "DELETE FROM customers WHERE customerID=?";
		PreparedStatement ps = connection.prepareStatement(query);

		ps.setInt(1, customerID);

		boolean result = ps.executeUpdate() > 0;

		ps.close();
		connection.close();

		 return result;
	 }

}
