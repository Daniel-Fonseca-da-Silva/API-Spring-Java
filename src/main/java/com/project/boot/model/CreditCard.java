package com.project.boot.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class CreditCard  {

    @Id
    @Column(updatable = false, unique = true, nullable = false, length = 16)
    private String card_number;

    @Column(length = 20)
    private String card_holder_name;

    private Integer value;

    @Column(nullable = false, length = 3)
    private Integer cvv;

    @Column(nullable = false, length = 5)
    private String exp_date;

    @ManyToOne
    private Client client;

}
