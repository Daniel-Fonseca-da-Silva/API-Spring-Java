package com.project.boot.service;

import com.project.boot.model.*;
import com.project.boot.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {

    @Autowired
    ProductRepository repo;

    public void createProduct(Product product) {
        product.setId(null);
        repo.save(product);
    }

    @Cacheable(value = "getProducts")
    public List<Product> getProducts() {
        return repo.findAll();
    }

    public List<ProductList> getListProduct() {

        List<Product> products = getProducts();
        List<ProductList> savedList = new ArrayList<>();

        ProductList[] product = new ProductList[products.size()];

        for (int i = 0; i < products.size(); i++) {

            product[i] = new ProductList(products.get(i).getTitle(),
                    products.get(i).getPrice(),
                    products.get(i).getZipcode(),
                    products.get(i).getSeller(),
                    products.get(i).getThumbnailHd(),
                    products.get(i).getDate()
            );

            savedList.add(product[i]);
        }

        return savedList;

    }

}
