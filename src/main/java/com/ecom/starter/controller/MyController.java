package com.ecom.starter.controller;

import com.ecom.starter.model.ProductItem;
import com.ecom.starter.model.UserData;
import com.ecom.starter.requests.AddToCartRequest;
import com.ecom.starter.requests.LoginRequest;
import com.ecom.starter.requests.UpdateRequest;
import com.ecom.starter.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {
    @Autowired
    public MyService myService;

    @RequestMapping("/health")
    public String heathCheck(){
        return "healthy!";
    }

//    retrieve all products
    @RequestMapping("/all")
    public List<ProductItem> getAll(){
        return myService.getAll();
    }

//    insert one product -> pass in all the key-value pairs of a product
    @PostMapping("/put")
    public void putProd(@RequestBody ProductItem product){
        myService.put(product);
    }

//    update name of the product
    @PostMapping("/update")
    public void updateProd(@RequestBody UpdateRequest updateRequest) {
        myService.update(updateRequest);
    }

//    delete one product - pass the prodID value of a product as part of the endpoint (Eg.: /delete/ww12)
    @DeleteMapping("/delete/{prodID}")
    public void delProd(@PathVariable String prodID) {
        myService.delete(prodID);
    }

//      register user
    @PostMapping("/register")
    public void registerUser(@RequestBody UserData user) {
        myService.register(user);
    }

//    login user
    @PostMapping("/login")
    public boolean loginUser(@RequestBody LoginRequest login) {
        return myService.login(login);
    }

//    add product to a cart
    @PostMapping("/addToCart")
    public void addToCart(@RequestBody AddToCartRequest addToCartRequest) {
        myService.addToCart(addToCartRequest);
    }

//  delete from cart
    @DeleteMapping("/delFromCart/{username}/{prodID}")
    public void delFromCart(@PathVariable String username, @PathVariable String prodID) {
        System.out.println(username + prodID);
        myService.delFromCart(username, prodID);
    }

}
