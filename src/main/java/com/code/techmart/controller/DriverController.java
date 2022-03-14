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

import com.code.techmart.model.Driver;
import com.code.techmart.services.DriverService;



public class DriverController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DriverController() {

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action.equals("all")) {
			getAllDrivers(request, response);
		}
		
		else {
			getDriver(request, response);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("drivers.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");

		if(action.equals("add")){
			addDriver(request, response);

		}
		else if(action.equals("update")){
			updateDriver(request, response);
		}

		else if(action.equals("delete")){
			deleteDriver(request, response);
		}
	}

	private void getAllDrivers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message ="";
		DriverService service = new DriverService();
		try {
			List<Driver> drivers = service.getAllDrivers();
			
			if(drivers.isEmpty()) {
				message = "No Drivers found";
			}
			
			request.setAttribute("driverList", drivers);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			
			message = e.getMessage();
		}
		
		request.setAttribute("message", message);
		
		RequestDispatcher rd = request.getRequestDispatcher("drivers.jsp");
		rd.forward(request, response);
	}

	private void getDriver(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message ="";
		DriverService service = new DriverService();
		int driverID = Integer.parseInt(request.getParameter("driverCode"));
		
		Driver driver = new Driver();
		try {
			driver = service.getDriverByID(driverID);
			if(driver.getfName().isEmpty()) {
				message = "There's No Driver Under the ID" + driverID;
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			message= e.getMessage();
		}
		
		request.setAttribute("message", message);
		request.setAttribute("driver", driver);

		
		RequestDispatcher rd = request.getRequestDispatcher("search-edit-driver.jsp");
		rd.forward(request, response);
	}

	private void addDriver(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message = "";
		DriverService service = new DriverService();
		
		Driver driver = new Driver();
		driver.setfName(request.getParameter("fname"));
		driver.setlName(request.getParameter("lname"));
		driver.setAddress(request.getParameter("address"));
		driver.setContact(request.getParameter("contact"));
		driver.setBranch(request.getParameter("branch"));
		
		try {
			boolean result = service.addDriver(driver);
			if(result) {
				message = "Driver Added, Driver Name : " +driver.getfName();
			}
			
			else {
				message = "Driver Add Failed! Driver Name : " +driver.getfName();
			}
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("add-driver.jsp");
		
		rd.forward(request, response);
	}

	private void updateDriver(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message = "";
		DriverService service = new DriverService();
		
		Driver driver = new Driver();
		driver.setfName(request.getParameter("fname"));
		driver.setlName(request.getParameter("lname"));
		driver.setAddress(request.getParameter("address"));
		driver.setContact(request.getParameter("contact"));
		driver.setBranch(request.getParameter("branch"));
		driver.setDriverID(Integer.parseInt(request.getParameter("driverID")));
		
		try {
			boolean result = service.updateDriver(driver);
			if(result) {
				message = "Driver ID : "  + driver.getDriverID() + " has been modified";
			}
			
			else {
				message = "Failed to update Driver! ID : " + driver.getDriverID();
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
			
		}
		
		
		request.setAttribute("message", message);
		
		RequestDispatcher rd = request.getRequestDispatcher("search-edit-driver.jsp");
		rd.forward(request, response);
		
	}

	private void deleteDriver(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String message = "";
		int driverID = Integer.parseInt(request.getParameter("driverID"));
		DriverService service = new DriverService();
		try {
			service.deleteDriver(driverID);
		} catch (ClassNotFoundException | SQLException e) {
			
			message=e.getMessage();
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("deleteMsg", message);
		
		response.sendRedirect("/techmart/getDriver?action=all");
	}

}
