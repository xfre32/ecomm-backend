package com.ecom.starter.requests;

public class UpdateRequest {
    public String prodID;
    public String prodName;

    public UpdateRequest(String prodID, String prodName) {
        this.prodID = prodID;
        this.prodName = prodName;
    }
}
