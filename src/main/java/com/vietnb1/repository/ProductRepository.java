package com.vietnb1.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.vietnb1.entity.Product;

@Mapper
public interface ProductRepository {

    @Select("SELECT * FROM product")
    public List<Product> getAllProduct();
}
