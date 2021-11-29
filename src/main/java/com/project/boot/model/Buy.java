package com.project.boot.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Buy {

    private CreditCard creditCard;
    private Client client;

}
