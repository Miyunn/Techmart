package com.code.techmart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.code.techmart.model.Request;

public class RequestManager {
	
	public static Request getRequestByID(int requestID) throws ClassNotFoundException, SQLException{
		
		DbConnector connector = new DbConnectorImplMySQL();
		Connection connection = connector.getConnecion();
		
		String query = "SELECT * FROM techmart.requests WHERE requestID=?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, requestID);
		
		ResultSet rs = ps.executeQuery();
		
		Request request = new Request();
		
		if(rs.next()) {
			
			request.setId(rs.getInt("requestID"));
			request.setBranch(rs.getString("branch"));
			request.setProductID(rs.getInt("productID"));
			request.setQuantity(rs.getInt("quantity"));
			request.setStatus(rs.getString("Status"));
		}
		
		rs.close();
		connection.close();
		
		return request;
	}
	
	public static List<Request> getAllRequests() throws ClassNotFoundException, SQLException{
		
		DbConnector connector = new DbConnectorImplMySQL();
		Connection connection = connector.getConnecion();
		
		String query = "SELECT * FROM techmart.requests";
		Statement st = connection.createStatement();
		
		ResultSet rs = st.executeQuery(query);
		
		List<Request> requests = new ArrayList<Request>();
		
		while(rs.next()) {
			Request request = new Request(rs.getInt("requestID"), rs.getString("branch"), 
			rs.getInt("supplier"), rs.getInt("productID"), rs.getInt("quantity"), rs.getString("Status"));
			requests.add(request);
		}
		
		st.close();
		connection.close();
	
		
		return requests;
	}

	public static List<Request> getBranchRequests(String branch) throws ClassNotFoundException, SQLException{
		
		DbConnector connector = new DbConnectorImplMySQL();
		Connection connection = connector.getConnecion();
		
		String query = "SELECT * FROM techmart.requests WHERE branch=?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, branch);
		
		ResultSet rs = ps.executeQuery();
		
		List<Request> requests = new ArrayList<Request>();
		
		while(rs.next()) {
			Request request = new Request(rs.getInt("requestID"), rs.getString("branch"), 
			rs.getInt("supplier"), rs.getInt("productID"), rs.getInt("quantity"), rs.getString("Status"));
			
			requests.add(request);
		}
		
		ps.close();
		connection.close();
	
		
		return requests;
	}

	public static List<Request> getSupplierRequests(int supplier) throws ClassNotFoundException, SQLException{
		
		DbConnector connector = new DbConnectorImplMySQL();
		Connection connection = connector.getConnecion();
		
		String query = "SELECT * FROM techmart.requests WHERE supplier=?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, supplier);
		
		ResultSet rs = ps.executeQuery();
		
		List<Request> requests = new ArrayList<Request>();
		
		while(rs.next()) {
			Request request = new Request(rs.getInt("requestID"), rs.getString("branch"), 
					rs.getInt("supplier"), rs.getInt("productID"), rs.getInt("quantity"), rs.getString("Status"));
			
			requests.add(request);
		}
		
		ps.close();
		connection.close();
	
		
		return requests;
	}
	
	 public static boolean addRequest(Request request) throws ClassNotFoundException, SQLException {
		
		DbConnector connector = new DbConnectorImplMySQL();
		Connection connection = connector.getConnecion();
		
		String query = "INSERT INTO requests (branch, productID, quantity, Status) VALUES (?,?,?,?)";
		
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, request.getId());
		ps.setString(2, request.getBranch());
		ps.setInt(3, request.getQuantity());
		ps.setString(4, request.getStatus());
		
		boolean result = ps.executeUpdate() >0;

		ps.close();
		connection.close();
		 
		 return result;
	 }
	 
	 public static boolean acceptRequest(int requestID)throws ClassNotFoundException, SQLException {

		DbConnector connector = new DbConnectorImplMySQL();
		Connection connection = connector.getConnecion();

		String status = "Accepted";
		String query = "UPDATE techmart.requests SET Status=? WHERE requestID=?";
		PreparedStatement ps = connection.prepareStatement(query);

		ps.setString(1, status);
		ps.setInt(2, requestID);

		boolean result = ps.executeUpdate() > 0;

		ps.close();
		connection.close();

		 return result;
	 }

	 public static boolean rejectRequest(int requestID)throws ClassNotFoundException, SQLException {

		DbConnector connector = new DbConnectorImplMySQL();
		Connection connection = connector.getConnecion();

		String status = "Rejected";
		String query = "UPDATE techmart.requests SET Status=? WHERE requestID=?";
		PreparedStatement ps = connection.prepareStatement(query);

		ps.setString(1, status);
		ps.setInt(2, requestID);

		boolean result = ps.executeUpdate() > 0;

		ps.close();
		connection.close();

		 return result;
	 }
	 
	 
	 public static boolean deleteRequest(int requestID) throws ClassNotFoundException, SQLException {
		
		DbConnector connector = new DbConnectorImplMySQL();
		Connection connection = connector.getConnecion();

		String query = "DELETE FROM requests WHERE requestID=?";
		PreparedStatement ps = connection.prepareStatement(query);

		ps.setInt(1, requestID);

		boolean result = ps.executeUpdate() > 0;

		ps.close();
		connection.close();

		 return result;
	 }

}
