package com.code.techmart.services;

import java.sql.SQLException;
import java.util.List;

import com.code.techmart.dao.TransactionManager;
import com.code.techmart.model.Transaction;

public class TransactionService {

	public Transaction getTransactionByID(int transactionID) throws ClassNotFoundException, SQLException {
		return TransactionManager.getTransactionByID(transactionID);
	}
	
	public List<Transaction> getAllTransactions() throws ClassNotFoundException, SQLException{
	
		return TransactionManager.getAllTransactions();
	}
	
	public List<Transaction> getAgentTransactions(String branch) throws ClassNotFoundException, SQLException{
		
		return TransactionManager.getAllTransactionsOnBranch(branch);
	}
	
	
	public boolean addTransaction(Transaction transaction) throws ClassNotFoundException, SQLException {
		
		return TransactionManager.addTransaction(transaction);
	}
	
	public boolean updateTransaction(Transaction transaction) throws ClassNotFoundException, SQLException {
		
		return TransactionManager.updateTransaction(transaction);
	}
	
	public boolean deleteTransaction(int transactionID) throws ClassNotFoundException, SQLException {
		
		return TransactionManager.deleteTransaction(transactionID);
	}
	
	
	public boolean acceptTransaction(int transactionID) throws ClassNotFoundException, SQLException {
		
		return TransactionManager.acceptTransaction(transactionID);
	}
	
}
