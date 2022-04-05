package com.vietnb1.repository;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.vietnb1.entity.Product;

public interface ProductRepository {

    @Select("SELECT * FROM product")
    public List<Product> getAllProduct();
}
