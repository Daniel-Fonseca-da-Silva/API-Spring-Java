package com.project.boot.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductList {

    private String title;
    private Integer price;
    private String zipcode;
    private String seller;
    private String thumbnailHd;
    private String date;

}
