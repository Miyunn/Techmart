package com.code.techmart.services;

import java.sql.SQLException;
import java.util.List;

import com.code.techmart.dao.RestockManager;
import com.code.techmart.model.Restock;

public class RestockService {

	public Restock getRestockByID(int restockID) throws ClassNotFoundException, SQLException {
		return RestockManager.getRestockByID(restockID);
	}

	public List<Restock> getBranchRestocks(String branch) throws ClassNotFoundException, SQLException {
		return RestockManager.getBranchRestocks(branch);
	}

	public List<Restock> getSupplierRestocks(int supplier) throws ClassNotFoundException, SQLException {
		return RestockManager.getSupplierRestocks(supplier);
	}
	
	public List<Restock> getAllRestocks() throws ClassNotFoundException, SQLException{
	
		return RestockManager.getAllRestocks();
	}
	
	public boolean addRestock(Restock restock) throws ClassNotFoundException, SQLException {
		
		return RestockManager.addRestock(restock);
	}
	
	public boolean deleteRestock(int restockID) throws ClassNotFoundException, SQLException {
		
		return RestockManager.deleteRestock(restockID);
	}
	
	public boolean acceptRestock(int restockID) throws ClassNotFoundException, SQLException {
		
		return RestockManager.acceptRestock(restockID);
	}

	public boolean rejectRestock(int restockID) throws ClassNotFoundException, SQLException {
		
		return RestockManager.rejectRestock(restockID);
	}
}
