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
			//addInventory(request, response);

		}
		else if(action.equals("update")){
			//updateInventory(request, response);
		}

		else if(action.equals("delete")){
			//deleteInventory(request, response);
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
		String branchName = request.getParameter("branch");
		int itemID = Integer.parseInt(request.getParameter("itemID"));
		
		Inventory inventory = new Inventory();
		try {
			inventory = service.getInventoryByID(branchName, itemID);
			if(inventory.getBranchName().isEmpty()) {
				message = "There's No Inventory Under the Branch :" + branchName + " with the ID ->" + itemID;
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			message= e.getMessage();
		}
		
		request.setAttribute("message", message);
		request.setAttribute("inventory", inventory);

		
		RequestDispatcher rd = request.getRequestDispatcher("search-edit-inventory.jsp");
		rd.forward(request, response);
	}

	// private void addInventory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	// 	String message = "";
	// 	InventoryService service = new InventoryService();
		
	// 	Inventory inventory = new Inventory();
	// 	inventory.setfName(request.getParameter("fname"));
	// 	inventory.setlName(request.getParameter("lname"));
	// 	inventory.setAddress(request.getParameter("address"));
	// 	inventory.setContact(request.getParameter("contact"));
	// 	inventory.setBranch(request.getParameter("branch"));
		
	// 	try {
	// 		boolean result = service.addInventory(inventory);
	// 		if(result) {
	// 			message = "Inventory Added, Inventory Name : " +inventory.getfName();
	// 		}
			
	// 		else {
	// 			message = "Inventory Add Failed! Inventory Name : " +inventory.getfName();
	// 		}
	// 	} catch (ClassNotFoundException | SQLException e) {
	// 		message = e.getMessage();
	// 	}
		
	// 	request.setAttribute("message", message);
	// 	RequestDispatcher rd = request.getRequestDispatcher("add-inventory.jsp");
		
	// 	rd.forward(request, response);
	// }

	// private void updateInventory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	// 	String message = "";
	// 	InventoryService service = new InventoryService();
		
	// 	Inventory inventory = new Inventory();
	// 	inventory.setfName(request.getParameter("fname"));
	// 	inventory.setlName(request.getParameter("lname"));
	// 	inventory.setAddress(request.getParameter("address"));
	// 	inventory.setContact(request.getParameter("contact"));
	// 	inventory.setBranch(request.getParameter("branch"));
	// 	inventory.setInventoryID(Integer.parseInt(request.getParameter("inventoryID")));
		
	// 	try {
	// 		boolean result = service.updateInventory(inventory);
	// 		if(result) {
	// 			message = "Inventory ID : "  + inventory.getInventoryID() + " has been modified";
	// 		}
			
	// 		else {
	// 			message = "Failed to update Inventory! ID : " + inventory.getInventoryID();
	// 		}
			
	// 	} catch (ClassNotFoundException | SQLException e) {
	// 		message = e.getMessage();
			
	// 	}
		
		
	// 	request.setAttribute("message", message);
		
	// 	RequestDispatcher rd = request.getRequestDispatcher("search-edit-inventory.jsp");
	// 	rd.forward(request, response);
		
	// }

	// private void deleteInventory(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
	// 	String message = "";
	// 	int inventoryID = Integer.parseInt(request.getParameter("inventoryID"));
	// 	InventoryService service = new InventoryService();
	// 	try {
	// 		service.deleteInventory(inventoryID);
	// 	} catch (ClassNotFoundException | SQLException e) {
			
	// 		message=e.getMessage();
	// 	}
		
	// 	HttpSession session = request.getSession();
	// 	session.setAttribute("deleteMsg", message);
		
	// 	response.sendRedirect("/techmart/getInventory?action=all");
	// }

}


