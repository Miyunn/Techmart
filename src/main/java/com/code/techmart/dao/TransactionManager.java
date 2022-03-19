package com.code.techmart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.code.techmart.model.Transaction;

public class TransactionManager {
	
	public static Transaction getTransactionByID(int transactionID) throws ClassNotFoundException, SQLException{
		
		DbConnector connector = new DbConnectorImplMySQL();
		Connection connection = connector.getConnecion();
		
		String query = "SELECT * FROM techmart.transactions WHERE transactionID=?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, transactionID);
		
		ResultSet rs = ps.executeQuery();
		
		Transaction transaction = new Transaction();
		
		if(rs.next()) {
			
			transaction.setTransactionID(rs.getInt("transactionID"));
			transaction.setCustomerID(rs.getString("customerID"));
			transaction.setProductID(rs.getInt("productID"));
			transaction.setBranch(rs.getString("branch"));
			transaction.setQuantity(rs.getInt("quantity"));
			transaction.setUnitprice(rs.getString("unitprice"));
			transaction.setTotal(rs.getString("total"));
			transaction.setStatus(rs.getString("status"));
		}
		
		rs.close();
		connection.close();
		
		return transaction;
	}
	
	public static List<Transaction> getAllTransactions() throws ClassNotFoundException, SQLException{
		
		DbConnector connector = new DbConnectorImplMySQL();
		Connection connection = connector.getConnecion();
		
		String query = "SELECT * FROM techmart.transactions";
		Statement st = connection.createStatement();
		
		ResultSet rs = st.executeQuery(query);
		
		List<Transaction> transactions = new ArrayList<Transaction>();
		
		while(rs.next()) {
			Transaction transaction = new Transaction(rs.getInt("transactionID"), rs.getString("customerID"), 
					rs.getInt("productID"), rs.getString("branch"), rs.getInt("quantity"), 
					rs.getString("unitprice"), rs.getString("total"), rs.getString("status"));
			
			transactions.add(transaction);
		}
		
		st.close();
		connection.close();
	
		
		return transactions;
	}

    public static List<Transaction> getAllTransactionsOnBranch(String branch) throws ClassNotFoundException, SQLException{
		
		DbConnector connector = new DbConnectorImplMySQL();
		Connection connection = connector.getConnecion();
		
		String query = "SELECT * FROM techmart.transactions WHERE branch=?";
        PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, branch);
		
		ResultSet rs = ps.executeQuery();
		
		List<Transaction> transactions = new ArrayList<Transaction>();
		
		while(rs.next()) {
			Transaction transaction = new Transaction(rs.getInt("transactionID"), rs.getString("customerID"), 
					rs.getInt("productID"), rs.getString("branch"), rs.getInt("quantity"), 
					rs.getString("unitprice"), rs.getString("total"), rs.getString("status"));
			
			transactions.add(transaction);
		}
		
		ps.close();
		connection.close();
	
		
		return transactions;
	}
	
	 public static boolean addTransaction(Transaction transaction) throws ClassNotFoundException, SQLException {
		
		DbConnector connector = new DbConnectorImplMySQL();
		Connection connection = connector.getConnecion();
		
		String query = "INSERT INTO transactions (customerID, productID, branch, quantity, unitprice, total, status) VALUES (?,?,?,?,?,?,?)";
		
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, transaction.getCustomerID());
		ps.setInt(2, transaction.getProductID());
		ps.setString(3, transaction.getBranch());
		ps.setInt(4, transaction.getQuantity());
		ps.setString(5, transaction.getUnitprice());
		ps.setString(6, transaction.getTotal());
		ps.setString(7, transaction.getStatus());
		
		boolean result = ps.executeUpdate() >0;

		ps.close();
		connection.close();
		 
		 return result;
	 }
	 
	 public static boolean updateTransaction(Transaction transaction) throws ClassNotFoundException, SQLException {

		DbConnector connector = new DbConnectorImplMySQL();
		Connection connection = connector.getConnecion();

		String query = "UPDATE techmart.transactions SET customerID=?, productID=?, branch=?, quantity=?, unitprice=?, total=?, status=? WHERE transactionID=?";

		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, transaction.getCustomerID());
		ps.setInt(2, transaction.getProductID());
		ps.setString(4, transaction.getBranch());
		ps.setInt(5, transaction.getQuantity());
		ps.setString(3, transaction.getUnitprice());
		ps.setString(6, transaction.getTotal());
		ps.setString(7, transaction.getStatus());
		
		boolean result = ps.executeUpdate() >0;

		ps.close();
		connection.close();
		 
		 return result;
	 }
	 
	 public static boolean deleteTransaction(int transactionID) throws ClassNotFoundException, SQLException {
		
		DbConnector connector = new DbConnectorImplMySQL();
		Connection connection = connector.getConnecion();

		String query = "DELETE FROM transactions WHERE transactionID=?";
		PreparedStatement ps = connection.prepareStatement(query);

		ps.setInt(1, transactionID);

		boolean result = ps.executeUpdate() > 0;

		ps.close();
		connection.close();

		 return result;
	 }

}
