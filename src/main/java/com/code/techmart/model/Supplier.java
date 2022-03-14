package com.code.techmart.model;

public class Supplier {
	
	private int supplierID;
	private String fName;
	private String lName;
	private String contact;
	private String branch;
	private String email;
	private String password;

	
	public Supplier() {
	}


	public Supplier(int supplierID, String fName, String lName, String contact, String branch,
			String email, String password) {
		this.supplierID = supplierID;
		this.fName = fName;
		this.lName = lName;
		this.contact = contact;
		this.branch = branch;
		this.email = email;
		this.password = password;
	}


	public int getSupplierID() {
		return supplierID;
	}


	public void setSupplierID(int supplierID) {
		this.supplierID = supplierID;
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

