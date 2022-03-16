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

import com.code.techmart.model.Inventory;
import com.code.techmart.services.InventoryService;


public class InventoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public InventoryController() {
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action.equals("all")) {
			getAllInventorys(request, response);
		}
		
		else {
			getInventory(request, response);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("inventorys.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");

		if(action.equals("add")){
			addInventory(request, response);

		}
		else if(action.equals("update")){
			updateInventory(request, response);
		}

		else if(action.equals("delete")){
			deleteInventory(request, response);
		}
	}

	private void getAllInventorys(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message ="";
		InventoryService service = new InventoryService();
		try {
			List<Inventory> inventorys = service.getAllInventorys();
			
			if(inventorys.isEmpty()) {
				message = "No Inventorys found";
			}
			
			request.setAttribute("inventoryList", inventorys);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			
			message = e.getMessage();
		}
		
		request.setAttribute("message", message);
		
		RequestDispatcher rd = request.getRequestDispatcher("inventory.jsp");
		rd.forward(request, response);
	}

	private void getInventory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message ="";
		InventoryService service = new InventoryService();
		int recordID = Integer.parseInt(request.getParameter("recordID"));
		
		Inventory inventory = new Inventory();
		try {
			inventory = service.getInventoryByID(recordID);
			if(inventory.getBranchName().isEmpty()) {
				message = "There's No Inventory Under the Record ID :" + recordID;
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			message= e.getMessage();
		}
		
		request.setAttribute("message", message);
		request.setAttribute("inventory", inventory);

		
		RequestDispatcher rd = request.getRequestDispatcher("search-edit-inventory.jsp");
		rd.forward(request, response);
	}

	 private void addInventory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	 	String message = "";
	 	InventoryService service = new InventoryService();
		
	 	Inventory inventory = new Inventory();
	 	inventory.setBranchName(request.getParameter("branch"));
	 	inventory.setItemID(request.getParameter("itemID"));
	 	inventory.setQuanity(request.getParameter("quantity"));
		
	 	try {
	 		boolean result = service.addInventory(inventory);
	 		if(result) {
	 			message = "Inventory Record Added";
	 		}
			
	 		else {
	 			message = "Inventory Record could not be added";
	 		}
	 	} catch (ClassNotFoundException | SQLException e) {
	 		message = e.getMessage();
	 	}
		
	 	request.setAttribute("message", message);
	 	RequestDispatcher rd = request.getRequestDispatcher("add-inventory.jsp");
		
	 	rd.forward(request, response);
	 }

	 private void updateInventory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	 	String message = "";
	 	InventoryService service = new InventoryService();
		
	 	Inventory inventory = new Inventory();
	 	inventory.setBranchName(request.getParameter("branch"));
	 	inventory.setItemID(request.getParameter("itemID"));
	 	inventory.setQuanity(request.getParameter("quantity"));
	 	inventory.setRecordID(Integer.parseInt(request.getParameter("recordID")));
		
	 	try {
	 		boolean result = service.updateInventory(inventory);
	 		if(result) {
	 			message = "Inventory ID : "  + inventory.getRecordID() + " has been modified";
	 		}
			
	 		else {
	 			message = "Failed to update Inventory! ID : " + inventory.getRecordID();
	 		}
			
	 	} catch (ClassNotFoundException | SQLException e) {
	 		message = e.getMessage();
			
	 	}
		
		
	 	request.setAttribute("message", message);
		
	 	RequestDispatcher rd = request.getRequestDispatcher("search-edit-inventory.jsp");
	 	rd.forward(request, response);
		
	 }

	 private void deleteInventory(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
	 	String message = "";
	 	int recordID = Integer.parseInt(request.getParameter("recordID"));
	 	InventoryService service = new InventoryService();
	 	try {
	 		service.deleteInventory(recordID);
	 	} catch (ClassNotFoundException | SQLException e) {
			
	 		message=e.getMessage();
	 	}
		
	 	HttpSession session = request.getSession();
	 	session.setAttribute("deleteMsg", message);
		
	 	response.sendRedirect("/techmart/getInventory?action=all");
	 }

}


