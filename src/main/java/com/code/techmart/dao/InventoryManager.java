package com.code.techmart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.code.techmart.model.Inventory;

public class InventoryManager {
	
	public static Inventory getInventoryByID(int recordID) throws ClassNotFoundException, SQLException{
		
		DbConnector connector = new DbConnectorImplMySQL();
		Connection connection = connector.getConnecion();
		
		String query = "SELECT inventory.recordID, inventory.branch, products.productID, products.name, inventory.quantity FROM inventory INNER JOIN products ON inventory.itemID=products.productID WHERE recordID=?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, recordID);
		
		ResultSet rs = ps.executeQuery();
		
		Inventory inventory = new Inventory();
		
		if(rs.next()) {
			
			inventory.setRecordID(rs.getInt("recordID"));
			inventory.setBranchName(rs.getString("branch"));
			inventory.setItemID(rs.getString("productID"));
			inventory.setItemName(rs.getString("name"));
			inventory.setQuanity(rs.getString("quantity"));
		}
		
		rs.close();
		connection.close();
		
		return inventory;
	}
	
	public static List<Inventory> getAllInventorys() throws ClassNotFoundException, SQLException{
		
		DbConnector connector = new DbConnectorImplMySQL();
		Connection connection = connector.getConnecion();
		
		String query = "SELECT inventory.recordID, inventory.branch, products.productID, products.name, inventory.quantity FROM inventory INNER JOIN products ON inventory.itemID=products.productID";
		Statement st = connection.createStatement();
		
		ResultSet rs = st.executeQuery(query);
		
		List<Inventory> inventorys = new ArrayList<Inventory>();
		
		while(rs.next()) {
			Inventory inventory = new Inventory(rs.getInt("recordID"), rs.getString("branch"), rs.getString("productID"), rs.getString("name"), 
					rs.getString("quantity"));
			
			inventorys.add(inventory);
		}
		
		st.close();
		connection.close();
	
		
		return inventorys;
	}

	public static List<Inventory> getAllInventoryByBranch(String branch) throws ClassNotFoundException, SQLException{
		
		DbConnector connector = new DbConnectorImplMySQL();
		Connection connection = connector.getConnecion();
		
		String query = "SELECT inventory.branch, products.productID, products.name, inventory.quantity FROM inventory INNER JOIN products ON inventory.itemID=products.productID WHERE branch?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, branch);
		
		ResultSet rs = ps.executeQuery();
		
		List<Inventory> inventorys = new ArrayList<Inventory>();
		
		while(rs.next()) {
			Inventory inventory = new Inventory(rs.getInt("recordID"), rs.getString("branch"),rs.getString("productID"), rs.getString("name"), 
					rs.getString("quantity"));
			
			inventorys.add(inventory);
		}
		
		ps.close();
		connection.close();
	
		
		return inventorys;
	}

	
	 public static boolean addInventory(Inventory inventory) throws ClassNotFoundException, SQLException {
		
		DbConnector connector = new DbConnectorImplMySQL();
		Connection connection = connector.getConnecion();
		
		String query = "INSERT INTO inventory (branch, itemID, quantity) VALUES (?,?,?)";
		
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, inventory.getBranchName());
		ps.setString(2, inventory.getItemID());
		ps.setString(3, inventory.getQuanity());
		
		boolean result = ps.executeUpdate() >0;

		ps.close();
		connection.close();
		 
		 return result;
	 }
	 
	 public static boolean updateInventory(Inventory inventory) throws ClassNotFoundException, SQLException {

		DbConnector connector = new DbConnectorImplMySQL();
		Connection connection = connector.getConnecion();

		String query = "UPDATE techmart.inventory SET branch=?, itemID=?, quantity=? WHERE recordID=?";

		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, inventory.getBranchName());
		ps.setString(2, inventory.getItemID());
		ps.setString(3, inventory.getQuanity());
		ps.setInt(4, inventory.getRecordID());
		
		boolean result = ps.executeUpdate() >0;

		ps.close();
		connection.close();
		 
		 return result;
	 }
	 
	 public static boolean deleteInventory(int recordID) throws ClassNotFoundException, SQLException {
		
		DbConnector connector = new DbConnectorImplMySQL();
		Connection connection = connector.getConnecion();

		String query = "DELETE FROM inventory WHERE recordID=?";
		PreparedStatement ps = connection.prepareStatement(query);

		ps.setInt(1, recordID);

		boolean result = ps.executeUpdate() > 0;

		ps.close();
		connection.close();

		 return result;
	 }

}
