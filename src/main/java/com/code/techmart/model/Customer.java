package com.code.techmart.model;

public class Customer {
	
	private int customerID;
	private String fName;
	private String lName;
	private String address;
	private String contact;
	private String branch;
	private String email;
	private String password;

	
	public Customer() {
	}


	public Customer(int customerID, String fName, String lName, String address, String contact, String branch,
			String email, String password) {
		this.customerID = customerID;
		this.fName = fName;
		this.lName = lName;
		this.address = address;
		this.contact = contact;
		this.branch = branch;
		this.email = email;
		this.password = password;
	}


	public int getCustomerID() {
		return customerID;
	}


	public void setCustomerID(int customerID) {
		this.customerID = customerID;
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


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
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

