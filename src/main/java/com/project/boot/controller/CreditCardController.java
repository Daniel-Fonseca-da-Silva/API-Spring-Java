package com.project.boot.controller;

import com.project.boot.model.CreditCard;
import com.project.boot.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/creditcard")
public class CreditCardController {

    @Autowired
    CreditCardService service;

    private URI getUri(String id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
    }

    @PostMapping
    @Secured({ "ROLE_USER" })
    ResponseEntity<CreditCard> createCreditCard(@RequestBody CreditCard creditCard) {
        service.createCreditCard(creditCard);
        URI location = getUri(creditCard.getCard_number());
        return ResponseEntity.created(location).build();
    }

}
