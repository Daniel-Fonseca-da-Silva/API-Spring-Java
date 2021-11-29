package com.project.boot.service;

import com.project.boot.model.History;
import com.project.boot.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryService {

    @Autowired
    HistoryRepository repo;

    public void createHistory(History history) {
        repo.save(history);
    }

    public List<History> getAllHistory() {
        return repo.findAll();
    }

    @Cacheable("getClientId")
    public Iterable<History> getClientId(String client_id) {
        return repo.findByClientId(client_id);
    }

}
