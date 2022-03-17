package com.code.techmart.services;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;


import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;
import com.code.techmart.model.Product;

class ProductServiceTest {

	@Test
	void testGetProductByID() throws ClassNotFoundException, SQLException {
		ProductService ps = new ProductService();
		
		Assertions.assertNotNull(ps.getProductByID(1));
	}

	@Test
	void testGetAllProducts() throws ClassNotFoundException, SQLException {
		ProductService ps = new ProductService();
		
		Assertions.assertNotNull(ps.getAllProducts());
	}

	@Test
	void testAddProduct() throws ClassNotFoundException, SQLException {
		
		ProductService ps = new ProductService();
        Product product = new Product();

        product.setName("testName");
        product.setModel("testModel");
        product.setPrice(5000);
        product.setImage("testimageurl");;
        product.setDisplay(true);
        product.setType("testType");

        boolean expected = true;
        boolean actual =  ps.addProduct(product);

        assertEquals(expected, actual ,"New Product should be added");
	}

	@Test
	void testDeleteProduct() throws ClassNotFoundException, SQLException {
		
		ProductService ps = new ProductService();

		boolean expected = true;
		boolean actual = ps.deleteProduct(8);
		
		assertEquals(expected, actual ,"Product Should be deleted");

	}

}
