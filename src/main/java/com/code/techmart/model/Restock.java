package com.code.techmart.model;

public class Restock {

    private int id;
    private String branch;
    private int supplier;
    private int productID;
    private int quantity;
    private String status;

   
    public Restock() {
        
    }

    public Restock(int id, String branch, int supplier, int productID, int quantity, String status) {
        this.id = id;
        this.branch = branch;
        this.supplier = supplier;
        this.productID = productID;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getSupplier() {
        return supplier;
    }

    public void setSupplier(int supplier) {
        this.supplier = supplier;
    }
    
    
}
