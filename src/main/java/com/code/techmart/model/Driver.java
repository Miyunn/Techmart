package com.code.techmart.model;

public class Driver {
	
	private int driverID;
	private String fName;
	private String lName;
	private String address;
	private String contact;
	private String branch;

	
	public Driver() {
	}


	public Driver(int driverID, String fName, String lName, String address, String contact, String branch) {
		this.driverID = driverID;
		this.fName = fName;
		this.lName = lName;
		this.address = address;
		this.contact = contact;
		this.branch = branch;
	}


	public int getDriverID() {
		return driverID;
	}


	public void setDriverID(int driverID) {
		this.driverID = driverID;
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
	
}

