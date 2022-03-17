package com.code.techmart.services;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.code.techmart.model.Agent;

class AgentServiceTest {

	@Test
	void testGetAgentByID() throws ClassNotFoundException, SQLException {
		
		AgentService as = new AgentService();
		
		Assertions.assertNotNull(as.getAgentByID(1));
	}

	@Test
	void testGetAllAgents() throws ClassNotFoundException, SQLException {
		AgentService as = new AgentService();
		
		Assertions.assertNotNull(as.getAllAgents());
	}

	@Test
	void testAddAgent() throws ClassNotFoundException, SQLException {
		AgentService as = new AgentService();
        Agent agent = new Agent();
        
        agent.setfName("testName");
        agent.setlName("testName");
        agent.setBranch("testBranch");
        agent.setContact("827123");
        agent.setPassword("testpassword");
        agent.setEmail("testemail");
        
        boolean expected = true;
        boolean actual =  as.addAgent(agent);

        assertEquals(expected, actual ,"New Agent should be added");

	}

}
