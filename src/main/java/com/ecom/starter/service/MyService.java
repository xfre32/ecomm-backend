package com.ecom.starter.service;

import com.ecom.starter.model.ProductItem;
import com.ecom.starter.model.UserData;
import com.ecom.starter.repositories.ProductTable;
import com.ecom.starter.repositories.UserTable;
import com.ecom.starter.requests.AddToCartRequest;
import com.ecom.starter.requests.LoginRequest;
import com.ecom.starter.requests.UpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyService {
    @Autowired
    public ProductTable productTable;
    @Autowired
    public UserTable userTable;
    public List<ProductItem> getAll() {
        return productTable.findAll();

    }

//    Insert operation
    public void put(ProductItem product) {
        productTable.insert(product);
    }

//    Delete operation
    public void delete(String prodID) {
        productTable.deleteByProdID(prodID);

    }

//    Update operation -> update name alone
    public void update(UpdateRequest updateRequest) {
        ProductItem prod = productTable.findByProdID(updateRequest.prodID);
        prod.prodName = updateRequest.prodName;
        productTable.deleteByProdID(updateRequest.prodID);
        productTable.save(prod);
    }

//    register
    public void register(UserData user) {
            userTable.insert(user);
    }

//    login
    public boolean login(LoginRequest login) {
        UserData user = userTable.findByUsername(login.username);
        if (user == null)
            return false;
        return user.password.equals(login.password);
    }

//    add product to cart
    public void addToCart(AddToCartRequest addToCartRequest) {
        ProductItem prod = productTable.findByProdID(addToCartRequest.prodID);
        UserData user = userTable.findByUsername(addToCartRequest.username);
        user.getOrderList().add(prod);
        userTable.deleteByUsername(addToCartRequest.username);
        userTable.save(user);
    }

    public void delFromCart(String username, String prodID) {
        UserData user = userTable.findByUsername(username);
        user.setOrderList(user.getOrderList().stream().filter(prod -> prod.prodID.equals(prodID)).toList());
        userTable.deleteByUsername(username);
        userTable.save(user);
    }

}
