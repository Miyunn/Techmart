package com.code.techmart.model;

public class Transaction {
    
    private int transactionID;
    private int customerID;
    private int productID;
    private String branch;
    private int quantity;
    private double unitprice;
    private double total;
    private String status;
   
    public Transaction() {
    }

    public Transaction(int transactionID, int customerID, int productID, String branch, int quantity, double unitprice,
            double total, String status) {
        this.transactionID = transactionID;
        this.customerID = customerID;
        this.productID = productID;
        this.branch = branch;
        this.quantity = quantity;
        this.unitprice = unitprice;
        this.total = total;
        this.status = status;
    }

    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(double unitprice) {
        this.unitprice = unitprice;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
}
