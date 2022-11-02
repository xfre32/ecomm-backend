package com.ecom.starter.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("products")
public class ProductItem {
//   @Id
//   public String id;
   public String prodID;
   public String prodName;
   public String prodDes;
   public int prodPrice;
   public String prodImg;
   public int prodStock;

    public ProductItem(String prodID, String prodName, String prodDes, int prodPrice, String prodImg, int prodStock) {
        this.prodID = prodID;
        this.prodName = prodName;
        this.prodDes = prodDes;
        this.prodPrice = prodPrice;
        this.prodImg = prodImg;
        this.prodStock = prodStock;

    }

    public void setProdID(String prodID) {
        this.prodID = prodID;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public void setProdDes(String prodDes) {
        this.prodDes = prodDes;
    }

    public void setProdPrice(int prodPrice) {
        this.prodPrice = prodPrice;
    }

    public void setProdImg(String prodImg) {
        this.prodImg = prodImg;
    }

    public void setProdStock(int prodStock) {
        this.prodStock = prodStock;
    }
}
