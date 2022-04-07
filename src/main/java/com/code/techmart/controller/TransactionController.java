package com.code.techmart.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.code.techmart.model.Transaction;
import com.code.techmart.services.TransactionService;

public class TransactionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public TransactionController() {

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action.equals("all")) {
			getAllTransactions(request, response);
		}
		
		else {
			getTransaction(request, response);
		}
		
		//RequestDispatcher rd = request.getRequestDispatcher("transactions.jsp");
		//rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");

		if(action.equals("add")){
			addTransaction(request, response);

		}
		else if(action.equals("update")){
			updateTransaction(request, response);
		}

		else if(action.equals("delete")){
			deleteTransaction(request, response);
		}
	}

	private void getAllTransactions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message ="";
		TransactionService service = new TransactionService();
		try {
			List<Transaction> transactions = service.getAllTransactions();
			
			if(transactions.isEmpty()) {
				message = "No Transactions found";
			}
			
			request.setAttribute("transactionList", transactions);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			
			message = e.getMessage();
		}
		
		request.setAttribute("message", message);
		
		RequestDispatcher rd = request.getRequestDispatcher("transactions.jsp");
		rd.forward(request, response);
	}

	private void getTransaction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message ="";
		TransactionService service = new TransactionService();
		int transactionID = Integer.parseInt(request.getParameter("transactionCode"));
		
		Transaction transaction = new Transaction();
		try {
			transaction = service.getTransactionByID(transactionID);
			if(transaction.getBranch().isEmpty()) {
				message = "There's No Transaction Under the ID" + transactionID;
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			message= e.getMessage();
		}
		
		request.setAttribute("message", message);
		request.setAttribute("transaction", transaction);

		
		RequestDispatcher rd = request.getRequestDispatcher("search-edit-transaction.jsp");
		rd.forward(request, response);
	}

	private void addTransaction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message = "";
		TransactionService service = new TransactionService();

		//int quantity = Integer.parseInt(request.getParameter("quantity"));
		String status = "Pending";

		
		Transaction transaction = new Transaction();
		transaction.setCustomerID(request.getParameter("customerID"));
		transaction.setProductID(Integer.parseInt(request.getParameter("productID")));
		transaction.setBranch(request.getParameter("branch"));
		transaction.setQuantity(1);
		transaction.setUnitprice(request.getParameter("total"));
		transaction.setTotal(request.getParameter("total"));
		transaction.setStatus(status);
		
		try {
			boolean result = service.addTransaction(transaction);
			if(result) {
				message = "<br> Product ID : "+transaction.getProductID()+ "<br>  Product Price : "+ transaction.getUnitprice()+ "<br> Quantity : "+ transaction.getQuantity()+ "<br>  Total : "+ transaction.getTotal()+ "<br>  Status : "+ transaction.getStatus();
			}
			
			else {
				message = "Transaction Add Failed! Transaction for Cutomer : " +transaction.getCustomerID();
			}
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("transaction-summary.jsp");	
		
		rd.forward(request, response);
	}

	private void updateTransaction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message = "";
		TransactionService service = new TransactionService();

		int quantity = Integer.parseInt(request.getParameter("quantity"));
		//double unitprice = (request.getParameter("unitprice"));
		//double total = quantity * unitprice;

		
		Transaction transaction = new Transaction();
		transaction.setCustomerID(request.getParameter("customerID"));
		transaction.setProductID(Integer.parseInt(request.getParameter("productID")));
		transaction.setBranch(request.getParameter("branch"));
		transaction.setQuantity(quantity);
		//transaction.setUnitprice(unitprice);
		//transaction.setTotal(total);
		transaction.setStatus(request.getParameter("status"));
		transaction.setTransactionID(Integer.parseInt(request.getParameter("transactionID")));
		
		try {
			boolean result = service.updateTransaction(transaction);
			if(result) {
				message = "Transaction ID : "  + transaction.getTransactionID() + " has been modified";
			}
			
			else {
				message = "Failed to update Transaction! ID : " + transaction.getTransactionID();
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
			
		}
		
		
		request.setAttribute("message", message);
		
		RequestDispatcher rd = request.getRequestDispatcher("search-edit-transaction.jsp");
		rd.forward(request, response);
		
	}

	private void deleteTransaction(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String message = "";
		int transactionID = Integer.parseInt(request.getParameter("transactionID"));
		TransactionService service = new TransactionService();
		try {
			service.deleteTransaction(transactionID);
		} catch (ClassNotFoundException | SQLException e) {
			
			message=e.getMessage();
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("deleteMsg", message);
		
		response.sendRedirect("/techmart/getTransaction?action=all");
	}

}
