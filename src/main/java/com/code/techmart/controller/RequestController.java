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

import com.code.techmart.model.Request;
import com.code.techmart.services.RequestService;

public class RequestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public RequestController() {
     
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action.equals("all")) {
			getAllRequests(request, response);
		}
		
		else if(action.equals("branch")) {
			getRequest(request, response);
		}

		else if(action.equals("supplier")) {
			getRequest(request, response);
		}

		else{
			getRequest(request, response);
		}
		
		//RequestDispatcher rd = request.getRequestDispatcher("requests.jsp");
		//rd.forward(request, response);
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");

		if(action.equals("add")){
			addRequest(request, response);

		}
		else if(action.equals("accept")){
			updateRequest(request, response);
		}

		else if(action.equals("reject")){
			updateRequest(request, response);
		}

		else if(action.equals("delete")){
			deleteRequest(request, response);
		}
	}

	private void getAllRequests(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message ="";
		RequestService service = new RequestService();
		try {
			List<Request> requests = service.getAllRequests();
			
			if(requests.isEmpty()) {
				message = "No Requests found";
			}
			
			request.setAttribute("requestList", requests);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			
			message = e.getMessage();
		}
		
		request.setAttribute("message", message);
		
		RequestDispatcher rd = request.getRequestDispatcher("requests.jsp");
		rd.forward(request, response);
	}

	private void getRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message ="";
		RequestService service = new RequestService();
		int requestID = Integer.parseInt(request.getParameter("requestCode"));
		
		Request request = new Request();
		try {
			request = service.getRequestByID(requestID);
			if(request.getfName().isEmpty()) {
				message = "There's No Request Under the ID" + requestID;
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			message= e.getMessage();
		}
		
		request.setAttribute("message", message);
		request.setAttribute("request", request);

		
		RequestDispatcher rd = request.getRequestDispatcher("search-edit-request.jsp");
		rd.forward(request, response);
	}

	private void addRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message = "";
		RequestService service = new RequestService();
		
		Request request = new Request();
		request.setfName(request.getParameter("fname"));
		request.setlName(request.getParameter("lname"));
		request.setAddress(request.getParameter("address"));
		request.setContact(request.getParameter("contact"));
		request.setBranch(request.getParameter("branch"));
		request.setEmail(request.getParameter("email"));
		request.setPassword(request.getParameter("password"));
		
		try {
			boolean result = service.addRequest(request);
			if(result) {
				message = "Request Added, Request Name : " +request.getfName();
			}
			
			else {
				message = "Request Add Failed! Request Name : " +request.getfName();
			}
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("add-request.jsp");
		
		rd.forward(request, response);
	}

	private void updateRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message = "";
		RequestService service = new RequestService();
		
		Request request = new Request();
		request.setfName(request.getParameter("fname"));
		request.setlName(request.getParameter("lname"));
		request.setAddress(request.getParameter("address"));
		request.setContact(request.getParameter("contact"));
		request.setBranch(request.getParameter("branch"));
		request.setEmail(request.getParameter("email"));
		request.setPassword(request.getParameter("password"));
		request.setRequestID(Integer.parseInt(request.getParameter("requestID")));
		
		try {
			boolean result = service.updateRequest(request);
			if(result) {
				message = "Request ID : "  + request.getRequestID() + " has been modified";
			}
			
			else {
				message = "Failed to update Request! ID : " + request.getRequestID();
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
			
		}
		
		
		request.setAttribute("message", message);
		
		RequestDispatcher rd = request.getRequestDispatcher("search-edit-request.jsp");
		rd.forward(request, response);
		
	}

	private void deleteRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String message = "";
		int requestID = Integer.parseInt(request.getParameter("requestID"));
		RequestService service = new RequestService();
		try {
			service.deleteRequest(requestID);
		} catch (ClassNotFoundException | SQLException e) {
			
			message=e.getMessage();
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("deleteMsg", message);
		
		response.sendRedirect("/techmart/getRequest?action=all");
	}

}
