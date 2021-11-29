package com.project.boot.model;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
public class History {

    @Column(name = "client_id")
    private String client_id;

    @Id
    @Column(updatable = false, nullable = false, unique = true)
    private String purchase_id = UUID.randomUUID().toString();

    private Integer value;

    @Column(length = 15)
    private String date;

    @Column(length = 16)
    private String card_number;

}
