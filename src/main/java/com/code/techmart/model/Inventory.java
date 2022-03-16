package com.code.techmart.model;

public class Inventory {
    
    private int recordID;
    private String branchName;
    private String itemID;
    private String itemName;
    private String quanity;
    
    public Inventory() {
    
    }

    public Inventory(int recordID, String branchName, String itemID, String itemName, String quanity) {
        this.recordID = recordID;
        this.branchName = branchName;
        this.itemID = itemID;
        this.itemName = itemName;
        this.quanity = quanity;
    }

    public int getRecordID() {
        return recordID;
    }

    public void setRecordID(int recordID) {
        this.recordID = recordID;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getQuanity() {
        return quanity;
    }

    public void setQuanity(String quanity) {
        this.quanity = quanity;
    }
   


    
}
