package com.project.boot.model;

import lombok.*;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    @Id
    @Column(updatable = false, nullable = false, unique = true)
    private String client_id;

    @Column(nullable = false, length = 20)
    private String client_name;

    @Column(nullable = false)
    private Integer total_to_pay;

    @Transient
    Date generate = new Date();

    @Column(length = 10)
    String date = new SimpleDateFormat("dd/MM/yyyy").format(generate);

    @OneToMany(targetEntity = CreditCard.class, mappedBy = "card_number", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CreditCard> creditCard;

}
