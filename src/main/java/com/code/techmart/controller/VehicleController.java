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

import com.code.techmart.model.Vehicle;
import com.code.techmart.services.VehicleService;


public class VehicleController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public VehicleController() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action.equals("all")) {
			getAllVehicles(request, response);
		}
		
		else {
			getVehicle(request, response);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("vehicles.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");

		if(action.equals("add")){
			addVehicle(request, response);

		}
		else if(action.equals("update")){
			updateVehicle(request, response);
		}

		else if(action.equals("delete")){
			deleteVehicle(request, response);
		}
	}

	private void getAllVehicles(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message ="";
		VehicleService service = new VehicleService();
		try {
			List<Vehicle> vehicles = service.getAllVehicles();
			
			if(vehicles.isEmpty()) {
				message = "No Vehicles found";
			}
			
			request.setAttribute("vehicleList", vehicles);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			
			message = e.getMessage();
		}
		
		request.setAttribute("message", message);
		
		RequestDispatcher rd = request.getRequestDispatcher("vehicles.jsp");
		rd.forward(request, response);
	}

	private void getVehicle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message ="";
		VehicleService service = new VehicleService();
		String vehicleID = request.getParameter("vehicleCode");
		
		Vehicle vehicle = new Vehicle();
		try {
			vehicle = service.getVehicleByID(vehicleID);
			if(vehicle.getVehicleLicenseNo().isEmpty()) {
				message = "There's No Vehicle Under the ID" + vehicleID;
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			message= e.getMessage();
		}
		
		request.setAttribute("message", message);
		request.setAttribute("vehicle", vehicle);

		
		RequestDispatcher rd = request.getRequestDispatcher("search-edit-vehicle.jsp");
		rd.forward(request, response);
	}

	private void addVehicle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message = "";
		VehicleService service = new VehicleService();
		
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleLicenseNo(request.getParameter("vehicleID"));
		vehicle.setModel(request.getParameter("model"));
		vehicle.setBranch(request.getParameter("branch"));
		
		try {
			boolean result = service.addVehicle(vehicle);
			if(result) {
				message = "Vehicle Added, Vehicle Name : " +vehicle.getVehicleLicenseNo();
			}
			
			else {
				message = "Vehicle Add Failed! Vehicle Name : " +vehicle.getVehicleLicenseNo();
			}
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("add-vehicle.jsp");
		
		rd.forward(request, response);
	}

	private void updateVehicle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message = "";
		VehicleService service = new VehicleService();
		
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleLicenseNo(request.getParameter("vehicleID"));
		vehicle.setModel(request.getParameter("model"));
		vehicle.setBranch(request.getParameter("branch"));
		
		try {
			boolean result = service.updateVehicle(vehicle);
			if(result) {
				message = "Vehicle ID : "  + vehicle.getVehicleLicenseNo() + " has been modified";
			}
			
			else {
				message = "Failed to update Vehicle! ID : " + vehicle.getVehicleLicenseNo();
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
			
		}
		
		
		request.setAttribute("message", message);
		
		RequestDispatcher rd = request.getRequestDispatcher("search-edit-vehicle.jsp");
		rd.forward(request, response);
		
	}

	private void deleteVehicle(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String message = "";
		String vehicleID = request.getParameter("vehicleID");
		VehicleService service = new VehicleService();
		try {
			service.deleteVehicle(vehicleID);
		} catch (ClassNotFoundException | SQLException e) {
			
			message=e.getMessage();
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("deleteMsg", message);
		
		response.sendRedirect("/techmart/getVehicle?action=all");
	}

}
