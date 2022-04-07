package com.code.techmart.services;

import java.sql.SQLException;
import java.util.List;

import com.code.techmart.dao.SupplierManager;
import com.code.techmart.model.Supplier;

public class SupplierService {

	public Supplier getSupplierByID(int supplierID) throws ClassNotFoundException, SQLException {
		return SupplierManager.getSupplierByID(supplierID);
	}
	
	public List<Supplier> getAllSuppliers() throws ClassNotFoundException, SQLException{
	
		return SupplierManager.getAllSuppliers();
	}
	
	public boolean addSupplier(Supplier supplier) throws ClassNotFoundException, SQLException {
		
		return SupplierManager.addSupplier(supplier);
	}
	
	public boolean updateSupplier(Supplier supplier) throws ClassNotFoundException, SQLException {
		
		return SupplierManager.updateSupplier(supplier);
	}
	
	public boolean deleteSupplier(int supplierID) throws ClassNotFoundException, SQLException {
		
		return SupplierManager.deleteSupplier(supplierID);
	}

	public Supplier searchUser(String username, String password) throws ClassNotFoundException, SQLException {
		
		return SupplierManager.searchuser(username, password);
	}
	
	
}
