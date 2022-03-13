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

import com.code.techmart.model.Customer;
import com.code.techmart.services.CustomerService;

public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CustomerController() {

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action.equals("all")) {
			getAllCustomers(request, response);
		}
		
		else {
			getCustomer(request, response);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("customers.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");

		if(action.equals("add")){
			addCustomer(request, response);

		}
		else if(action.equals("update")){
			updateCustomer(request, response);
		}

		else if(action.equals("delete")){
			deleteCustomer(request, response);
		}
	}

	private void getAllCustomers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message ="";
		CustomerService service = new CustomerService();
		try {
			List<Customer> customers = service.getAllCustomers();
			
			if(customers.isEmpty()) {
				message = "No Customers found";
			}
			
			request.setAttribute("customerList", customers);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			
			message = e.getMessage();
		}
		
		request.setAttribute("message", message);
		
		RequestDispatcher rd = request.getRequestDispatcher("customers.jsp");
		rd.forward(request, response);
	}

	private void getCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message ="";
		CustomerService service = new CustomerService();
		int customerID = Integer.parseInt(request.getParameter("customerCode"));
		
		Customer customer = new Customer();
		try {
			customer = service.getCustomerByID(customerID);
			if(customer.getfName().isEmpty()) {
				message = "There's No Customer Under the ID" + customerID;
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			message= e.getMessage();
		}
		
		request.setAttribute("message", message);
		request.setAttribute("customer", customer);

		
		RequestDispatcher rd = request.getRequestDispatcher("search-edit-customer.jsp");
		rd.forward(request, response);
	}

	private void addCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message = "";
		CustomerService service = new CustomerService();
		
		Customer customer = new Customer();
		customer.setfName(request.getParameter("fname"));
		customer.setlName(request.getParameter("lname"));
		customer.setAddress(request.getParameter("address"));
		customer.setContact(request.getParameter("contact"));
		customer.setBranch(request.getParameter("branch"));
		customer.setEmail(request.getParameter("email"));
		customer.setPassword(request.getParameter("password"));
		
		try {
			boolean result = service.addCustomer(customer);
			if(result) {
				message = "Customer Added, Customer Name : " +customer.getfName();
			}
			
			else {
				message = "Customer Add Failed! Customer Name : " +customer.getfName();
			}
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("add-customer.jsp");
		
		rd.forward(request, response);
	}

	private void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message = "";
		CustomerService service = new CustomerService();
		
		Customer customer = new Customer();
		customer.setfName(request.getParameter("fname"));
		customer.setlName(request.getParameter("lname"));
		customer.setAddress(request.getParameter("address"));
		customer.setContact(request.getParameter("contact"));
		customer.setBranch(request.getParameter("branch"));
		customer.setEmail(request.getParameter("email"));
		customer.setPassword(request.getParameter("password"));
		customer.setCustomerID(Integer.parseInt(request.getParameter("customerID")));
		
		try {
			boolean result = service.updateCustomer(customer);
			if(result) {
				message = "Customer ID : "  + customer.getCustomerID() + " has been modified";
			}
			
			else {
				message = "Failed to update Customer! ID : " + customer.getCustomerID();
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
			
		}
		
		
		request.setAttribute("message", message);
		
		RequestDispatcher rd = request.getRequestDispatcher("search-edit-customer.jsp");
		rd.forward(request, response);
		
	}

	private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String message = "";
		int customerID = Integer.parseInt(request.getParameter("customerID"));
		CustomerService service = new CustomerService();
		try {
			service.deleteCustomer(customerID);
		} catch (ClassNotFoundException | SQLException e) {
			
			message=e.getMessage();
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("deleteMsg", message);
		
		response.sendRedirect("/techmart/getCustomer?action=all");
	}

}
