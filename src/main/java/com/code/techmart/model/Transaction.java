package com.code.techmart.model;

public class Transaction {
    
    private int transactionID;
    private String customerID;
    private int productID;
    private String branch;
    private int quantity;
    private String unitprice;
    private String total;
    private String status;
   
    public Transaction() {
    }

    public Transaction(int transactionID, String customerID, int productID, String branch, int quantity, String unitprice,
    		String total, String status) {
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

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
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

    public String getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(String unitprice2) {
        this.unitprice = unitprice2;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
}
