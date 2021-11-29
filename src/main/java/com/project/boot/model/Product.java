package com.project.boot.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Product extends AbstractEntity<Long> {

    @Column(unique = true, nullable = false, length = 60)
    private String title;

    private Integer price;

    @Column(nullable = false)
    private String zipcode;

    @Column(nullable = false, length = 60)
    private String seller;

    @Column(nullable = false)
    private String thumbnailHd;

    @Column(nullable = false, length = 10)
    private String date;

}
