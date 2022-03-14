package com.code.techmart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.code.techmart.model.Agent;

public class AgentManager {
	
	public static Agent getAgentByID(int agentID) throws ClassNotFoundException, SQLException{
		
		DbConnector connector = new DbConnectorImplMySQL();
		Connection connection = connector.getConnecion();
		
		String query = "SELECT * FROM techmart.agents WHERE agentID=?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, agentID);
		
		ResultSet rs = ps.executeQuery();
		
		Agent agent = new Agent();
		
		if(rs.next()) {
			
			agent.setAgentID(rs.getInt("agentID"));
			agent.setfName(rs.getString("firstName"));
			agent.setlName(rs.getString("lastName"));
			agent.setContact(rs.getString("telno"));
			agent.setBranch(rs.getString("location"));
			agent.setEmail(rs.getString("email"));
			agent.setPassword(rs.getString("password"));
		}
		
		rs.close();
		connection.close();
		
		return agent;
	}
	
	public static List<Agent> getAllAgents() throws ClassNotFoundException, SQLException{
		
		DbConnector connector = new DbConnectorImplMySQL();
		Connection connection = connector.getConnecion();
		
		String query = "SELECT * FROM techmart.agents";
		Statement st = connection.createStatement();
		
		ResultSet rs = st.executeQuery(query);
		
		List<Agent> agents = new ArrayList<Agent>();
		
		while(rs.next()) {
			Agent agent = new Agent(rs.getInt("agentID"), rs.getString("firstName"), 
					rs.getString("lastName"), rs.getString("location"), 
					rs.getString("telno"), rs.getString("email"), rs.getString("password"));
			
			agents.add(agent);
		}
		
		st.close();
		connection.close();
	
		
		return agents;
	}
	
	 public static boolean addAgent(Agent agent) throws ClassNotFoundException, SQLException {
		
		DbConnector connector = new DbConnectorImplMySQL();
		Connection connection = connector.getConnecion();
		
		String query = "INSERT INTO agents (firstName, lastName, location, telno, email, password) VALUES (?,?,?,?,?,?)";
		
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, agent.getfName());
		ps.setString(2, agent.getlName());
		ps.setString(4, agent.getContact());
		ps.setString(3, agent.getBranch());
		ps.setString(5, agent.getEmail());
		ps.setString(6, agent.getPassword());
		
		boolean result = ps.executeUpdate() >0;

		ps.close();
		connection.close();
		 
		 return result;
	 }
	 
	 public static boolean updateAgent(Agent agent) throws ClassNotFoundException, SQLException {

		DbConnector connector = new DbConnectorImplMySQL();
		Connection connection = connector.getConnecion();

		String query = "UPDATE techmart.agents SET firstName=?, lastName=?, location=?, telno=?, email=?, password=? WHERE agentID=?";

		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, agent.getfName());
		ps.setString(2, agent.getlName());
		ps.setString(4, agent.getContact());
		ps.setString(3, agent.getBranch());
		ps.setString(5, agent.getEmail());
		ps.setString(6, agent.getPassword());
		ps.setInt(7, agent.getAgentID());
		
		boolean result = ps.executeUpdate() >0;

		ps.close();
		connection.close();
		 
		 return result;
	 }
	 
	 public static boolean deleteAgent(int agentID) throws ClassNotFoundException, SQLException {
		
		DbConnector connector = new DbConnectorImplMySQL();
		Connection connection = connector.getConnecion();

		String query = "DELETE FROM agents WHERE agentID=?";
		PreparedStatement ps = connection.prepareStatement(query);

		ps.setInt(1, agentID);

		boolean result = ps.executeUpdate() > 0;

		ps.close();
		connection.close();

		 return result;
	 }

}
