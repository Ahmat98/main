package com.ahali_developere.springboot_search_api.service;

import com.ahali_developere.springboot_search_api.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> searchProducts(String query);

    Product createProduct(Product product);
}
