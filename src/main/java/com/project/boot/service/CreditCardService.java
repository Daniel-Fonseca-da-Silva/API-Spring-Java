package com.project.boot.service;

import com.project.boot.model.CreditCard;
import com.project.boot.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditCardService {

    @Autowired
    CreditCardRepository repo;

    public void createCreditCard(CreditCard creditCard) {
        repo.save(creditCard);
    }

}
