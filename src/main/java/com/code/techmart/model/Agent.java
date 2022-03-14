package com.code.techmart.model;

public class Agent {
	
	private int agentID;
	private String fName;
	private String lName;
	private String contact;
	private String branch;
	private String email;
	private String password;

	
	public Agent() {
	}


	public Agent(int agentID, String fName, String lName, String contact, String branch,
			String email, String password) {
		this.agentID = agentID;
		this.fName = fName;
		this.lName = lName;
		this.contact = contact;
		this.branch = branch;
		this.email = email;
		this.password = password;
	}


	public int getAgentID() {
		return agentID;
	}


	public void setAgentID(int agentID) {
		this.agentID = agentID;
	}


	public String getfName() {
		return fName;
	}


	public void setfName(String fName) {
		this.fName = fName;
	}


	public String getlName() {
		return lName;
	}


	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getContact() {
		return contact;
	}


	public void setContact(String contact) {
		this.contact = contact;
	}


	public String getBranch() {
		return branch;
	}


	public void setBranch(String branch) {
		this.branch = branch;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	

}

