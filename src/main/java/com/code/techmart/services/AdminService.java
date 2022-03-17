package com.code.techmart.services;

import java.sql.SQLException;

import com.code.techmart.dao.AdminManager;
import com.code.techmart.model.Admin;

public class AdminService {
	
	private static AdminService service;
	
	private AdminService() {
		
	}
	
	public static AdminService getAdminServiceInstance() {
		if(service == null) {
			service = new AdminService();
		}
		return service;
	}
	
	public Admin searchUser(String username, String password) throws ClassNotFoundException, SQLException {
		
		return AdminManager.searchuser(username, password);
	}
	 
}
