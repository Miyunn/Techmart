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

import com.code.techmart.model.Restock;
import com.code.techmart.services.RestockService;

/**
 * Servlet implementation class RestockController
 */
public class RestockController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action.equals("all")) {
			getAllRestocks(request, response);
		}

		else if(action.equals("branch")){
			//getStoreRestocks(request, response);
		}
		
		
		else {
			getRestock(request, response);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("restocks.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");

		if(action.equals("add")){
			addRestock(request, response);

		}
		else if(action.equals("accept")){
			updateRestock(request, response);
		}

		else if(action.equals("reject")){
			deleteRestock(request, response);
		}
	}
	
	private void getAllRestocks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message ="";
		RestockService service = new RestockService();
		try {
			List<Restock> restocks = service.getAllRestocks();
			
			if(restocks.isEmpty()) {
				message = "No Restocks found";
			}
			
			request.setAttribute("restockList", restocks);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			
			message = e.getMessage();
		}
		
		request.setAttribute("message", message);
		
		RequestDispatcher rd = request.getRequestDispatcher("restocks.jsp");
		rd.forward(request, response);
	}

	
	private void getRestock(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message ="";
		RestockService service = new RestockService();
	
		int supplierID = Integer.parseInt(request.getParameter("supplierID"));
		
		Restock restock = new Restock();
		try {
			restock = service.getRestockByID(supplierID);
			if(restock.getStatus().isEmpty()) {
				message = "There's No Stock Requests Under Supplier ID ID : " + supplierID;
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			message= e.getMessage();
		}
		
		request.setAttribute("message", message);
		request.setAttribute("restock", restock);

		
		RequestDispatcher rd = request.getRequestDispatcher("search-edit-restock.jsp");
		rd.forward(request, response);
	}

	private void addRestock(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message = "";
		RestockService service = new RestockService();
		
		Restock restock = new Restock();
		restock.setProductID(Integer.parseInt(request.getParameter("productID")));
		restock.setSupplier(Integer.parseInt(request.getParameter("supplier")));
		restock.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		restock.setBranch(request.getParameter("Branch"));
		restock.setStatus("Pending");

		
		try {
			boolean result = service.addRestock(restock);
			if(result) {
				message = "Restock Added, Restock Name : " +restock.getStatus();
			}
			
			else {
				message = "Restock Added Failed! Restock Name : " +restock.getStatus();
			}
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("add-restock.jsp");
		
		rd.forward(request, response);
	}
	
	private void updateRestock(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message = "";
		RestockService service = new RestockService();
		
		Restock restock = new Restock();
		restock.setId(Integer.parseInt(request.getParameter("restockID")));

		
	//	try {
			//boolean result = service.acceptRestock(restock);
			//if(result) {
				//message = "Restock ID :" + restock.getId() + "has been modified";
		//	}
			
			//else {
				//message = "Failed to update Restock! ID : " + restock.getId();
		//	}
			
	//	} //catch (ClassNotFoundException | SQLException e) {
			// = e.getMessage();
			
	//	}
		
		
//		request.setAttribute("message", message);
		
		//RequestDispatcher rd = request.getRequestDispatcher("search-edit-restock.jsp");
		//rd.forward(request, response);
		
	}
	
	private void deleteRestock(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String message = "";
		int restockID = Integer.parseInt(request.getParameter("restockID"));
		RestockService service = new RestockService();
		try {
			service.deleteRestock(restockID);
		} catch (ClassNotFoundException | SQLException e) {
			
			message=e.getMessage();
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("deleteMsg", message);
		
		response.sendRedirect("/techmart/getRestock?action=all");
	}
}
