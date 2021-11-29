package com.project.boot.controller;

import com.project.boot.model.Buy;
import com.project.boot.model.Client;
import com.project.boot.model.CreditCard;
import com.project.boot.model.History;
import com.project.boot.service.ClientService;
import com.project.boot.service.CreditCardService;
import com.project.boot.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Controller
@RequestMapping("/starstores/buy")
public class BuyController {

    @Autowired
    ClientService clientService;

    @Autowired
    CreditCardService creditCardService;

    @Autowired
    HistoryService historyService;

    private URI getUri(Object id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
    }

    @PostMapping
    @Secured({ "ROLE_USER" })
    public ResponseEntity<Buy> createBuy(@RequestBody Buy buy) {

        History history = new History();

        CreditCard creditCard = buy.getCreditCard();
        Client client = buy.getClient();
        clientService.createClient(client);
        creditCardService.createCreditCard(creditCard);

        history.setCard_number(creditCard.getCard_number());
        history.setClient_id(client.getClient_id());
        history.setValue(creditCard.getValue());
        history.setDate(client.getDate());
        historyService.createHistory(history);

        URI location = getUri(client.getClient_id());

        return ResponseEntity.created(location).build();
    }

}
