package com.code.techmart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.code.techmart.model.Admin;

public class AdminManager {
	
	 public static Admin searchuser(String username, String password) throws SQLException, ClassNotFoundException {
		 
			DbConnector connector = new DbConnectorImplMySQL();
			Connection connection = connector.getConnecion();
			
			String query = "CALL getAdminLogin(?,?)";

			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
		
			Admin admin = null;
			if(rs.next()) {
				admin = new Admin();
				admin.setUsername("username");
				admin.setPassword("password");
			}
			
			ps.close();
			connection.close();
			
			return admin;
	 }
}
