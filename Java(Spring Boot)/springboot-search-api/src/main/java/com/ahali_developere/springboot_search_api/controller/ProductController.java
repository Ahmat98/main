package com.ahali_developere.springboot_search_api.controller;

import com.ahali_developere.springboot_search_api.entity.Product;
import com.ahali_developere.springboot_search_api.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam("query") String query){
        return ResponseEntity.ok(productService.searchProducts(query));
    }

    //@PostMapping
    //public ResponseEntity<Product> createProduct(@RequestBody Product product){
    //    return new ResponseEntity<>(productService.createProduct(product), HttpStatus.CREATED);
    //}


    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        System.out.println("PRODUCT = " + product);
        return new ResponseEntity<>(productService.createProduct(product), HttpStatus.CREATED);
    }

}
