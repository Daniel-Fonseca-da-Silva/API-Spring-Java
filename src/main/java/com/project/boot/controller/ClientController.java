package com.project.boot.controller;

import com.project.boot.model.Client;
import com.project.boot.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientService service;

    private URI getUri(Object id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
    }

    // Test if client exist!
    @GetMapping
    @Secured({ "ROLE_USER" })
    public List<Client> getClient() {
        return service.getClient();
    }

    @PostMapping
    @Secured({ "ROLE_USER" })
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        service.createClient(client);
        URI location = getUri(client.getClient_id());
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{purchase_id}")
    @Secured({ "ROLE_USER" })
    public ResponseEntity<?> getClient(@PathVariable("purchase_id") String purchase_id) {
        Optional<Client> client = service.getClientById(purchase_id);
        return client.isPresent() ? ResponseEntity.ok(client) : ResponseEntity.notFound().build();
    }

}
