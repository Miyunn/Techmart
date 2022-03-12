package com.code.techmart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.code.techmart.model.Product;

public class ProductManager {
	
	public static Product getProductByID(int productID) throws ClassNotFoundException, SQLException{
		
		DbConnector connector = new DbConnectorImplMySQL();
		Connection connection = connector.getConnecion();
		
		String query = "SELECT * FROM techmart.products WHERE productID=?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, productID);
		
		ResultSet rs = ps.executeQuery();
		
		Product product = new Product();
		
		if(rs.next()) {
			
			product.setId(rs.getInt("productID"));
			product.setName(rs.getString("name"));
			product.setModel(rs.getString("model"));
			product.setType(rs.getString("type"));
			product.setPrice(rs.getDouble("price"));
			product.setImage(rs.getString("image"));
			product.setDisplay(rs.getBoolean("display"));
		}
		
		rs.close();
		connection.close();
		
		return product;
	}
	
	public static List<Product> getAllProducts() throws ClassNotFoundException, SQLException{
		
		DbConnector connector = new DbConnectorImplMySQL();
		Connection connection = connector.getConnecion();
		
		String query = "SELECT * FROM techmart.products";
		Statement st = connection.createStatement();
		
		ResultSet rs = st.executeQuery(query);
		
		List<Product> products = new ArrayList<Product>();
		
		while(rs.next()) {
			Product product = new Product(rs.getInt("productID"), rs.getString("name"), 
					rs.getString("model"), rs.getBoolean("display"), rs.getString("type"), 
					rs.getDouble("price"), rs.getString("image"));
			
			products.add(product);
		}
		
		st.close();
		connection.close();
	
		
		return products;
	}
	
	 public static boolean addProduct(Product product) throws ClassNotFoundException, SQLException {
		
		DbConnector connector = new DbConnectorImplMySQL();
		Connection connection = connector.getConnecion();
		
		String query = "INSERT INTO products (name, model, display, type, price, image) VALUES (?,?,?,?,?,?)";
		
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, product.getName());
		ps.setString(2, product.getModel());
		ps.setBoolean(3, product.getDisplay());
		ps.setString(4, product.getType());
		ps.setDouble(5, product.getPrice());
		ps.setString(6, product.getImage());
		
		boolean result = ps.executeUpdate() >0;

		ps.close();
		connection.close();
		 
		 return result;
	 }
	 
	 public static boolean updateProduct(Product product) throws ClassNotFoundException, SQLException {

		DbConnector connector = new DbConnectorImplMySQL();
		Connection connection = connector.getConnecion();

		String query = "UPDATE products set(name=?, model=?, display=?, type=?, price=?, image=?) WHERE id=?";

		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, product.getName());
		ps.setString(2, product.getModel());
		ps.setBoolean(3, product.getDisplay());
		ps.setString(4, product.getType());
		ps.setDouble(5, product.getPrice());
		ps.setString(6, product.getImage());
		ps.setInt(7, product.getId());
		
		boolean result = ps.executeUpdate() >0;

		ps.close();
		connection.close();
		 
		 return result;
	 }
	 
	 public static boolean deleteProduct(int productID) throws ClassNotFoundException, SQLException {
		
		DbConnector connector = new DbConnectorImplMySQL();
		Connection connection = connector.getConnecion();

		String query = "DELETE FROM products WHERE productID=?";
		PreparedStatement ps = connection.prepareStatement(query);

		ps.setInt(1, productID);

		boolean result = ps.executeUpdate() > 0;

		ps.close();
		connection.close();

		 return result;
	 }

}
