package com.jlv.petstore.tests;

import com.jlv.petstore.dto.ProductDTO;
import com.jlv.petstore.entities.Category;
import com.jlv.petstore.entities.Product;

import java.time.Instant;

public class Factory {

    public static Product createProduct(){
        Product product = new Product(1L,
                "Ração",
                "Descrição",
                100.0,
                "https://img.com/img.png",
                Instant.parse("2023-07-02T03:00:00Z"));

        product.getCategories().add(new Category(2L,"Eletronics"));

        return  product;
    }

    public static ProductDTO createProductDTO(){
        Product product = createProduct();
        return new ProductDTO(product,product.getCategories());
    }
}
