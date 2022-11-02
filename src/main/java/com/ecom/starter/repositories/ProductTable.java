package com.ecom.starter.repositories;

import com.ecom.starter.model.ProductItem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductTable extends MongoRepository<ProductItem, String> {
    public void deleteByProdID(String prodID);
    public ProductItem findByProdID(String prodID);

}
