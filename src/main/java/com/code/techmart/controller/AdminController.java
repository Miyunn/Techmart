package com.code.techmart.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.code.techmart.model.Admin;
import com.code.techmart.services.AdminService;


public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AdminController() {

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String action = request.getParameter("action");
		
		if(action.equals("login")){
			adminLogin(request, response);
		}

	}

	public void adminLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		AdminService service = AdminService.getAdminServiceInstance();
		
		Admin admin = new Admin();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String type = "admin";
		
		String message ="";
		
		try 
		{
			admin = service.searchUser(username, password);
			HttpSession session = request.getSession();
			
			if(admin !=null) {
				
				session.setAttribute("sessionusername", username);
				session.setAttribute("type", type);
				
				 session.setMaxInactiveInterval(30*60);
				  
				 Cookie userName = new Cookie("sessionusername", username);
				 userName.setMaxAge(30*60); response.addCookie(userName);
				 
				 Cookie atype = new Cookie("sessiontype", type);
				 atype.setMaxAge(30*60); response.addCookie(atype);
				
				try 
				{
					response.sendRedirect("admin-dashboard.jsp");
				} 
				catch (IOException e) 
				{
					message = e.getMessage();
				}
				
			}
			else 
			{
				try 
				{
					response.sendRedirect("admin-login.jsp");
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
