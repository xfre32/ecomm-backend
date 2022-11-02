package com.ecom.starter.requests;

public class AddToCartRequest {
    public String username;
    public String prodID;

    public AddToCartRequest(String username, String prodID) {
        this.username = username;
        this.prodID = prodID;
    }
}
