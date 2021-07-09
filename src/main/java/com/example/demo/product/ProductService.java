package com.example.demo.product;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService
{
    public List<Product> getProduct(){
        return List.of(
                new Product(1L,"yeet",1,"small"),
                new Product( 1L,"yeet2",2,"medium")
        );
    }
}
