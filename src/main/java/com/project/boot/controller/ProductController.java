package com.project.boot.controller;

import com.project.boot.model.*;
import com.project.boot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/starstore/")
public class ProductController {

    @Autowired
    private ProductService service;

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
    }

    @PostMapping("/product")
    @Secured({ "ROLE_USER" })
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        service.createProduct(product);
        URI location = getUri(product.getId());
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/products")
    @Secured({ "ROLE_USER" })
    public ResponseEntity<List<ProductList>> getProducts() {
        List<ProductList> productList = service.getListProduct();
        return productList.isEmpty() ? ResponseEntity.noContent().build(): ResponseEntity.ok(productList);
    }

}
