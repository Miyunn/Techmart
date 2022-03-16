package com.code.techmart.services;

import java.sql.SQLException;
import java.util.List;

import com.code.techmart.dao.InventoryManager;
import com.code.techmart.model.Inventory;

public class InventoryService {

	public Inventory getInventoryByID(int recordID) throws ClassNotFoundException, SQLException {
		return InventoryManager.getInventoryByID(recordID);
	}
	
	public List<Inventory> getAllInventorys() throws ClassNotFoundException, SQLException{
	
		return InventoryManager.getAllInventorys();
	}
	
	public boolean addInventory(Inventory inventory) throws ClassNotFoundException, SQLException {
		
		return InventoryManager.addInventory(inventory);
	}
	
	public boolean updateInventory(Inventory inventory) throws ClassNotFoundException, SQLException {
		
		return InventoryManager.updateInventory(inventory);
	}
	
	public boolean deleteInventory(int recordID) throws ClassNotFoundException, SQLException {
		
		return InventoryManager.deleteInventory(recordID);
	}
	
}
