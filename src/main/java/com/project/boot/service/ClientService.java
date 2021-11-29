package com.project.boot.service;

import com.project.boot.model.Client;
import com.project.boot.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ClientService {

    @Autowired
    ClientRepository repo;

    public void createClient(Client client) {
        repo.save(client);
    }

    public List<Client> getClient() {
        return repo.findAll();
    }

    public Optional<Client> getClientById(String purchase_id) {
        return repo.findById(purchase_id);
    }
}
