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

import com.code.techmart.model.Agent;
import com.code.techmart.services.AgentService;


public class AgentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AgentController() {
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String action = request.getParameter("action");
		
		if(action.equals("all")) {
			getAllAgents(request, response);
		}
		
		else {
			getAgent(request, response);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("agents.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");

		if(action.equals("add")){
			addAgent(request, response);

		}
		else if(action.equals("update")){
			updateAgent(request, response);
		}

		else if(action.equals("delete")){
			deleteAgent(request, response);
		}

		else if(action.equals("login")){
			agentLogin(request, response);
		}

	}

	private void getAllAgents(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message ="";
		AgentService service = new AgentService();
		try {
			List<Agent> agents = service.getAllAgents();
			
			if(agents.isEmpty()) {
				message = "No Agents found";
			}
			
			request.setAttribute("agentList", agents);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			
			message = e.getMessage();
		}
		
		request.setAttribute("message", message);
		
		RequestDispatcher rd = request.getRequestDispatcher("agents.jsp");
		rd.forward(request, response);
	}

	private void getAgent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message ="";
		AgentService service = new AgentService();
		int agentID = Integer.parseInt(request.getParameter("agentCode"));
		
		Agent agent = new Agent();
		try {
			agent = service.getAgentByID(agentID);
			if(agent.getfName().isEmpty()) {
				message = "There's No Agent Under the ID" + agentID;
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			message= e.getMessage();
		}
		
		request.setAttribute("message", message);
		request.setAttribute("agent", agent);

		
		RequestDispatcher rd = request.getRequestDispatcher("search-edit-agent.jsp");
		rd.forward(request, response);
	}

	private void addAgent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message = "";
		AgentService service = new AgentService();
		
		Agent agent = new Agent();
		agent.setfName(request.getParameter("fname"));
		agent.setlName(request.getParameter("lname"));
		agent.setContact(request.getParameter("contact"));
		agent.setBranch(request.getParameter("branch"));
		agent.setEmail(request.getParameter("email"));
		agent.setPassword(request.getParameter("password"));
		
		try {
			boolean result = service.addAgent(agent);
			if(result) {
				message = "Agent Added, Agent Name : " +agent.getfName();
			}
			
			else {
				message = "Agent Add Failed! Agent Name : " +agent.getfName();
			}
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("add-agent.jsp");
		
		rd.forward(request, response);
	}

	private void updateAgent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message = "";
		AgentService service = new AgentService();
		
		Agent agent = new Agent();
		agent.setfName(request.getParameter("fname"));
		agent.setlName(request.getParameter("lname"));
		agent.setContact(request.getParameter("contact"));
		agent.setBranch(request.getParameter("branch"));
		agent.setEmail(request.getParameter("email"));
		agent.setPassword(request.getParameter("password"));
		agent.setAgentID(Integer.parseInt(request.getParameter("agentID")));
		
		try {
			boolean result = service.updateAgent(agent);
			if(result) {
				message = "Agent ID : "  + agent.getAgentID() + " has been modified";
			}
			
			else {
				message = "Failed to update Agent! ID : " + agent.getAgentID();
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
			
		}
		
		
		request.setAttribute("message", message);
		
		RequestDispatcher rd = request.getRequestDispatcher("search-edit-agent.jsp");
		rd.forward(request, response);
		
	}

	private void deleteAgent(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String message = "";
		int agentID = Integer.parseInt(request.getParameter("agentID"));
		AgentService service = new AgentService();
		try {
			service.deleteAgent(agentID);
		} catch (ClassNotFoundException | SQLException e) {
			
			message=e.getMessage();
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("deleteMsg", message);
		
		response.sendRedirect("/techmart/getAgent?action=all");
	}

	public void agentLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		AgentService service = new AgentService();
		
		Agent agent = new Agent();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String type = "agent";
		
		String message ="";
		
		try 
		{
			agent = service.searchUser(username, password);
			HttpSession session = request.getSession();
			
			if(agent !=null) {
				
				session.setAttribute("sessionusername", username);
				session.setAttribute("type", type);
				
				 session.setMaxInactiveInterval(30*60);
				  
				 Cookie userName = new Cookie("sessionusername", username);
				 userName.setMaxAge(30*60); response.addCookie(userName);
				 
				 Cookie atype = new Cookie("sessiontype", type);
				 atype.setMaxAge(30*60); response.addCookie(atype);
				
				try 
				{
					response.sendRedirect("agent-dashboard.jsp");
				} 
				catch (IOException e) 
				{
					message = e.getMessage();
				}
				
				/*
				 * try { response.sendRedirect("index.jsp?sessionuname="+uname+"");
				 * //response.sendRedirect("doctorAddRecord.jsp?sessionuname="+uname+""); }
				 * catch (IOException ex) {
				 * 
				 * message = ex.getMessage(); }
				 */
			}
			else 
			{
				try 
				{
					response.sendRedirect("agent-login.jsp");
					message = "No User Found!";	
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
