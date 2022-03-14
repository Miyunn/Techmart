package com.code.techmart.services;

import java.sql.SQLException;
import java.util.List;

import com.code.techmart.dao.AgentManager;
import com.code.techmart.model.Agent;

public class AgentService {

	public Agent getAgentByID(int agentID) throws ClassNotFoundException, SQLException {
		return AgentManager.getAgentByID(agentID);
	}
	
	public List<Agent> getAllAgents() throws ClassNotFoundException, SQLException{
	
		return AgentManager.getAllAgents();
	}
	
	public boolean addAgent(Agent agent) throws ClassNotFoundException, SQLException {
		
		return AgentManager.addAgent(agent);
	}
	
	public boolean updateAgent(Agent agent) throws ClassNotFoundException, SQLException {
		
		return AgentManager.updateAgent(agent);
	}
	
	public boolean deleteAgent(int agentID) throws ClassNotFoundException, SQLException {
		
		return AgentManager.deleteAgent(agentID);
	}
	
}
