package com.code.techmart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.code.techmart.model.Restock;

public class RestockManager {
	
	public static Restock getRestockByID(int restockID) throws ClassNotFoundException, SQLException{
		
		DbConnector connector = new DbConnectorImplMySQL();
		Connection connection = connector.getConnecion();
		
		String query = "SELECT * FROM techmart.restocks WHERE restockID=?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, restockID);
		
		ResultSet rs = ps.executeQuery();
		
		Restock restock = new Restock();
		
		if(rs.next()) {
			
			restock.setId(rs.getInt("restockID"));
			restock.setBranch(rs.getString("branch"));
			restock.setProductID(rs.getInt("productID"));
			restock.setQuantity(rs.getInt("quantity"));
			restock.setStatus(rs.getString("Status"));
		}
		
		rs.close();
		connection.close();
		
		return restock;
	}
	
	public static List<Restock> getAllRestocks() throws ClassNotFoundException, SQLException{
		
		DbConnector connector = new DbConnectorImplMySQL();
		Connection connection = connector.getConnecion();
		
		String query = "SELECT * FROM techmart.restocks";
		Statement st = connection.createStatement();
		
		ResultSet rs = st.executeQuery(query);
		
		List<Restock> restocks = new ArrayList<Restock>();
		
		while(rs.next()) {
			Restock restock = new Restock(rs.getInt("restockID"), rs.getString("branch"), 
			rs.getInt("supplier"), rs.getInt("productID"), rs.getInt("quantity"), rs.getString("Status"));
			restocks.add(restock);
		}
		
		st.close();
		connection.close();
	
		
		return restocks;
	}

	public static List<Restock> getBranchRestocks(String branch) throws ClassNotFoundException, SQLException{
		
		DbConnector connector = new DbConnectorImplMySQL();
		Connection connection = connector.getConnecion();
		
		String query = "SELECT * FROM techmart.restocks WHERE branch=?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, branch);
		
		ResultSet rs = ps.executeQuery();
		
		List<Restock> restocks = new ArrayList<Restock>();
		
		while(rs.next()) {
			Restock restock = new Restock(rs.getInt("restockID"), rs.getString("branch"), 
			rs.getInt("supplier"), rs.getInt("productID"), rs.getInt("quantity"), rs.getString("Status"));
			
			restocks.add(restock);
		}
		
		ps.close();
		connection.close();
	
		
		return restocks;
	}

	public static List<Restock> getSupplierRestocks(int supplier) throws ClassNotFoundException, SQLException{
		
		DbConnector connector = new DbConnectorImplMySQL();
		Connection connection = connector.getConnecion();
		
		String query = "SELECT * FROM techmart.restocks WHERE supplier=?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, supplier);
		
		ResultSet rs = ps.executeQuery();
		
		List<Restock> restocks = new ArrayList<Restock>();
		
		while(rs.next()) {
			Restock restock = new Restock(rs.getInt("restockID"), rs.getString("branch"), 
					rs.getInt("supplier"), rs.getInt("productID"), rs.getInt("quantity"), rs.getString("status"));
			
			restocks.add(restock);
		}
		
		ps.close();
		connection.close();
	
		
		return restocks;
	}
	
	 public static boolean addRestock(Restock restock) throws ClassNotFoundException, SQLException {
		
		DbConnector connector = new DbConnectorImplMySQL();
		Connection connection = connector.getConnecion();
		
		String query = "INSERT INTO restocks (branch, productID, quantity, Status) VALUES (?,?,?,?)";
		
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, restock.getId());
		ps.setString(2, restock.getBranch());
		ps.setInt(3, restock.getQuantity());
		ps.setString(4, restock.getStatus());
		
		boolean result = ps.executeUpdate() >0;

		ps.close();
		connection.close();
		 
		 return result;
	 }
	 
	 public static boolean acceptRestock(int restockID)throws ClassNotFoundException, SQLException {

		DbConnector connector = new DbConnectorImplMySQL();
		Connection connection = connector.getConnecion();

		String status = "Accepted";
		String query = "UPDATE techmart.restocks SET Status=? WHERE restockID=?";
		PreparedStatement ps = connection.prepareStatement(query);

		ps.setString(1, status);
		ps.setInt(2, restockID);

		boolean result = ps.executeUpdate() > 0;

		ps.close();
		connection.close();

		 return result;
	 }

	 public static boolean rejectRestock(int restockID)throws ClassNotFoundException, SQLException {

		DbConnector connector = new DbConnectorImplMySQL();
		Connection connection = connector.getConnecion();

		String status = "Rejected";
		String query = "UPDATE techmart.restocks SET Status=? WHERE restockID=?";
		PreparedStatement ps = connection.prepareStatement(query);

		ps.setString(1, status);
		ps.setInt(2, restockID);

		boolean result = ps.executeUpdate() > 0;

		ps.close();
		connection.close();

		 return result;
	 }
	 
	 
	 public static boolean deleteRestock(int restockID) throws ClassNotFoundException, SQLException {
		
		DbConnector connector = new DbConnectorImplMySQL();
		Connection connection = connector.getConnecion();

		String query = "DELETE FROM restocks WHERE restockID=?";
		PreparedStatement ps = connection.prepareStatement(query);

		ps.setInt(1, restockID);

		boolean result = ps.executeUpdate() > 0;

		ps.close();
		connection.close();

		 return result;
	 }

}
