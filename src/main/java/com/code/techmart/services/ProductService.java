package com.code.techmart.services;

import java.sql.SQLException;
import java.util.List;

import com.code.techmart.dao.ProductManager;
import com.code.techmart.model.Product;

public class ProductService {

	public Product getProductByID(int productID) throws ClassNotFoundException, SQLException {
		return ProductManager.getProductByID(productID);
	}
	
	public List<Product> getAllProducts() throws ClassNotFoundException, SQLException{
	
		return ProductManager.getAllProducts();
	}
	
	public boolean addProduct(Product product) throws ClassNotFoundException, SQLException {
		
		return ProductManager.addProduct(product);
	}
	
	public boolean updateProduct(Product product) throws ClassNotFoundException, SQLException {
		
		return ProductManager.updateProduct(product);
	}
	
	public boolean deleteProduct(int productID) throws ClassNotFoundException, SQLException {
		
		return ProductManager.deleteProduct(productID);
	}
	
}
