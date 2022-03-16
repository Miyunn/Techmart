package com.code.techmart.services;

import java.sql.SQLException;
import java.util.List;

import com.code.techmart.dao.RequestManager;
import com.code.techmart.model.Request;

public class RequestService {

	public Request getRequestByID(int requestID) throws ClassNotFoundException, SQLException {
		return RequestManager.getRequestByID(requestID);
	}

	public List<Request> getBranchRequests(String branch) throws ClassNotFoundException, SQLException {
		return RequestManager.getBranchRequests(branch);
	}

	public List<Request> getSupplierRequests(int supplier) throws ClassNotFoundException, SQLException {
		return RequestManager.getSupplierRequests(supplier);
	}
	
	public List<Request> getAllRequests() throws ClassNotFoundException, SQLException{
	
		return RequestManager.getAllRequests();
	}
	
	public boolean addRequest(Request request) throws ClassNotFoundException, SQLException {
		
		return RequestManager.addRequest(request);
	}
	
	public boolean deleteRequest(int requestID) throws ClassNotFoundException, SQLException {
		
		return RequestManager.deleteRequest(requestID);
	}
	
	public boolean acceptRequest(int requestID) throws ClassNotFoundException, SQLException {
		
		return RequestManager.acceptRequest(requestID);
	}

	public boolean rejectRequest(int requestID) throws ClassNotFoundException, SQLException {
		
		return RequestManager.rejectRequest(requestID);
	}
}
