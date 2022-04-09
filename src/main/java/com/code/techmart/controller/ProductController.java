package com.code.techmart.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import org.eclipse.jdt.internal.compiler.ast.Annotation.AnnotationTargetAllowed;

import com.code.techmart.model.Product;
import com.code.techmart.services.ProductService;

/**
 * Servlet implementation class ProductController
 */
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action.equals("all")) {
			getAllProducts(request, response);
		}

		else if(action.equals("store-all")){
			getStoreProducts(request, response);
		}
		
		else if(action.equals("agent")){
			getAllAgentProducts(request, response);
		}
		
		else {
			getProduct(request, response);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("products.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");

		if(action.equals("add")){
			addProduct(request, response);

		}
		else if(action.equals("update")){
			updateProduct(request, response);
		}

		else if(action.equals("delete")){
			deleteProduct(request, response);
		}
	}
	
	private void getAllProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message ="";
		ProductService service = new ProductService();
		try {
			List<Product> products = service.getAllProducts();
			
			if(products.isEmpty()) {
				message = "No Products found";
			}
			
			request.setAttribute("productList", products);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			
			message = e.getMessage();
		}
		
		request.setAttribute("message", message);
		
		RequestDispatcher rd = request.getRequestDispatcher("products.jsp");
		rd.forward(request, response);
	}

	private void getStoreProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message ="";
		ProductService service = new ProductService();
		try {
			List<Product> products = service.getAllProducts();
			
			if(products.isEmpty()) {
				message = "No Products found";
			}
			
			request.setAttribute("productList", products);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			
			message = e.getMessage();
		}
		
		request.setAttribute("message", message);
		
		RequestDispatcher rd = request.getRequestDispatcher("store.jsp");
		rd.forward(request, response);
	}

	private void getAllAgentProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message ="";
		ProductService service = new ProductService();
		try {
			List<Product> products = service.getAllProducts();
			
			if(products.isEmpty()) {
				message = "No Products found";
			}
			
			request.setAttribute("productList", products);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			
			message = e.getMessage();
		}
		
		request.setAttribute("message", message);
		
		RequestDispatcher rd = request.getRequestDispatcher("agent-product.jsp");
		rd.forward(request, response);
	}
	
	private void getProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message ="";
		ProductService service = new ProductService();
		int productID = Integer.parseInt(request.getParameter("productCode"));
		
		Product product = new Product();
		try {
			product = service.getProductByID(productID);
			if(product.getName().isEmpty()) {
				message = "There's No Product Under the ID" + productID;
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			message= e.getMessage();
		}
		
		request.setAttribute("message", message);
		request.setAttribute("product", product);

		System.out.println(product.getDisplay());
		
		RequestDispatcher rd = request.getRequestDispatcher("search-edit-product.jsp");
		rd.forward(request, response);
	}

	private void addProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message = "";
		ProductService service = new ProductService();
		
		Product product = new Product();
		product.setName(request.getParameter("productName"));
		product.setModel(request.getParameter("productModel"));
		product.setType(request.getParameter("productType"));
		product.setDisplay(Boolean.parseBoolean(request.getParameter("productDisplay")));
		product.setPrice(Double.parseDouble(request.getParameter("Price")));
		product.setImage(request.getParameter("image"));
		
		try {
			boolean result = service.addProduct(product);
			if(result) {
				message = "Product Added, Product Name : " +product.getName();
			}
			
			else {
				message = "Product Added Failed! Product Name : " +product.getName();
			}
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("add-product.jsp");
		
		rd.forward(request, response);
	}
	
	private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message = "";
		ProductService service = new ProductService();
		
		Product product = new Product();
		product.setId(Integer.parseInt(request.getParameter("productID")));
		product.setName(request.getParameter("productName"));
		product.setModel(request.getParameter("productModel"));
		product.setPrice(Double.parseDouble(request.getParameter("Price")));
		product.setType(request.getParameter("productType"));
		product.setDisplay(Boolean.parseBoolean(request.getParameter("productDisplay")));
		product.setImage(request.getParameter("image"));
		
		try {
			boolean result = service.updateProduct(product);
			if(result) {
				message = "Product ID :" + product.getId() + "has been modified";
			}
			
			else {
				message = "Failed to update Product! ID : " + product.getId();
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
			
		}
		
		
		request.setAttribute("message", message);
		
		RequestDispatcher rd = request.getRequestDispatcher("search-edit-product.jsp");
		rd.forward(request, response);
		
	}
	
	private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String message = "";
		int productID = Integer.parseInt(request.getParameter("productID"));
		ProductService service = new ProductService();
		try {
			service.deleteProduct(productID);
		} catch (ClassNotFoundException | SQLException e) {
			
			message=e.getMessage();
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("deleteMsg", message);
		
		response.sendRedirect("/techmart/getProduct?action=all");
	}
}
