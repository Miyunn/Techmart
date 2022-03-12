package com.code.techmart.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnectorImplMySQL implements DbConnector {

	@Override
	public Connection getConnecion() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/techmart";
		String userName = "root";
		String password = "1234";
		return DriverManager.getConnection(url, userName, password);
		
	}

}
