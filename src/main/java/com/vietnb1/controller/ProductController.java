package com.vietnb1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vietnb1.entity.Product;
import com.vietnb1.repository.ProductRepository;

@RestController
@RequestMapping(value = "/api/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Product> getAllProduct() {
        System.out.println("product");
        return productRepository.getAllProduct();
    }

}
