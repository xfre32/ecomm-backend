package com.ecom.starter.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document("users")
public class UserData {

//    @Id
//    public String id;
    public String firstName;
    public String lastName;
    public String username;
    public String type = "user";
    public String email;
    public String password;
    public long phone;
    public List<ProductItem> orderList = new ArrayList<>();

    public UserData(String firstName, String lastName, String username, String email, String password, long phone) {
//        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
//        this.type = type;
        this.email = email;
        this.password = password;
        this.phone = phone;
//        this.orderList = orderList;
    }

    public List<ProductItem> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<ProductItem> orderList) {
        this.orderList = orderList;
    }
}
