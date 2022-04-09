package com.code.techmart.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.code.techmart.model.Supplier;
import com.code.techmart.services.AgentService;
import com.code.techmart.services.SupplierService;
 

public class SupplierController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SupplierController() {

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String action = request.getParameter("action");
		
		if(action.equals("all")) {
			getAllSuppliers(request, response);
		}
		
		else {
			getSupplier(request, response);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("suppliers.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");

		if(action.equals("add")){
			addSupplier(request, response);

		}
		else if(action.equals("update")){
			updateSupplier(request, response);
		}

		else if(action.equals("delete")){
			deleteSupplier(request, response);
		}

		else if(action.equals("login")){
			supplierLogin(request, response);
		}
	

	}

	private void getAllSuppliers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message ="";
		SupplierService service = new SupplierService();
		try {
			List<Supplier> suppliers = service.getAllSuppliers();
			
			if(suppliers.isEmpty()) {
				message = "No Suppliers found";
			}
			
			request.setAttribute("supplierList", suppliers);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			
			message = e.getMessage();
		}
		
		request.setAttribute("message", message);
		
		RequestDispatcher rd = request.getRequestDispatcher("suppliers.jsp");
		rd.forward(request, response);
	}

	private void getSupplier(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message ="";
		SupplierService service = new SupplierService();
		int supplierID = Integer.parseInt(request.getParameter("supplierCode"));
		
		Supplier supplier = new Supplier();
		try {
			supplier = service.getSupplierByID(supplierID);
			if(supplier.getfName().isEmpty()) {
				message = "There's No Supplier Under the ID" + supplierID;
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			message= e.getMessage();
		}
		
		request.setAttribute("message", message);
		request.setAttribute("supplier", supplier);

		
		RequestDispatcher rd = request.getRequestDispatcher("search-edit-supplier.jsp");
		rd.forward(request, response);
	}

	private void addSupplier(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message = "";
		SupplierService service = new SupplierService();
		
		Supplier supplier = new Supplier();
		supplier.setfName(request.getParameter("fname"));
		supplier.setlName(request.getParameter("lname"));
		supplier.setContact(request.getParameter("contact"));
		supplier.setBranch(request.getParameter("branch"));
		supplier.setEmail(request.getParameter("email"));
		supplier.setPassword(request.getParameter("password"));
		
		try {
			boolean result = service.addSupplier(supplier);
			if(result) {
				message = "Supplier Added, Supplier Name : " +supplier.getfName();
			}
			
			else {
				message = "Supplier Add Failed! Supplier Name : " +supplier.getfName();
			}
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("add-supplier.jsp");
		
		rd.forward(request, response);
	}

	private void updateSupplier(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message = "";
		SupplierService service = new SupplierService();
		
		Supplier supplier = new Supplier();
		supplier.setfName(request.getParameter("fname"));
		supplier.setlName(request.getParameter("lname"));
		supplier.setContact(request.getParameter("contact"));
		supplier.setBranch(request.getParameter("branch"));
		supplier.setEmail(request.getParameter("email"));
		supplier.setPassword(request.getParameter("password"));
		supplier.setSupplierID(Integer.parseInt(request.getParameter("supplierID")));
		
		try {
			boolean result = service.updateSupplier(supplier);
			if(result) {
				message = "Supplier ID : "  + supplier.getSupplierID() + " has been modified";
			}
			
			else {
				message = "Failed to update Supplier! ID : " + supplier.getSupplierID();
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
			
		}
		
		
		request.setAttribute("message", message);
		
		RequestDispatcher rd = request.getRequestDispatcher("search-edit-supplier.jsp");
		rd.forward(request, response);
		
	}

	private void deleteSupplier(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String message = "";
		int supplierID = Integer.parseInt(request.getParameter("supplierID"));
		SupplierService service = new SupplierService();
		try {
			service.deleteSupplier(supplierID);
		} catch (ClassNotFoundException | SQLException e) {
			
			message=e.getMessage();
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("deleteMsg", message);
		
		response.sendRedirect("/techmart/getSupplier?action=all");
	}

	public void supplierLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		SupplierService service = new SupplierService();
		Supplier supplier = new Supplier();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String type = "supplier";
		String userID = null;
		
		String message ="";
		
		try 
		{
			supplier = service.searchUser(username, password);
			HttpSession session = request.getSession();
			
			if(supplier !=null) {
				
				session.setAttribute("sessionusername", username);
				session.setAttribute("sessiontype", type);
				session.setAttribute("sessionUserID", supplier.getSupplierID());
				session.setAttribute("sessionBranch", supplier.getBranch());
				
			
				
				System.out.println(session.getAttribute("sessionUserID"));
				System.out.println(session.getAttribute("sessionBranch"));
				
				 session.setMaxInactiveInterval(30*60);
				  
				 Cookie userName = new Cookie("sessionusername", username);
				 userName.setMaxAge(30*60); response.addCookie(userName);
				 
				 Cookie atype = new Cookie("sessiontype", type);
				 atype.setMaxAge(30*60); response.addCookie(atype);
				 
				 Cookie userid = new Cookie("sessionUserID", userID);
				 userid.setMaxAge(30*60); response.addCookie(userid);
		
				response.sendRedirect("supplier-dashboard.jsp");
			}
	
			else 
			{
				try 
				{
					response.sendRedirect("supplier-login.jsp");
					message = "Please Check Username and Password";	
				} catch (IOException es) {
					
					message = es.getMessage();
				}	
			}
			
			session.setAttribute("loginMessage", message);
			
		} 
		catch (ClassNotFoundException | SQLException e) {
		
			message = e.getMessage();
		}
		
		 
	}
}