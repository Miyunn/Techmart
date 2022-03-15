package com.code.techmart.model;

public class Inventory {
    
    private String branchName;
    private int itemID;
    private String itemName;
    private int quanity;
   
    public Inventory() {
        
    }

    public Inventory(String branchName, int itemID, String itemName, int quanity) {
        this.branchName = branchName;
        this.itemID = itemID;
        this.itemName = itemName;
        this.quanity = quanity;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuanity() {
        return quanity;
    }

    public void setQuanity(int quanity) {
        this.quanity = quanity;
    }

    
}
