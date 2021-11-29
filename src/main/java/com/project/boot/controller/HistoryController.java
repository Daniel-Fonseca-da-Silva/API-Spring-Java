package com.project.boot.controller;

import com.project.boot.model.History;
import com.project.boot.service.HistoryService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/starstore/history")
public class HistoryController {

    @Autowired
    HistoryService service;

    private URI getUri(Object id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
    }

    @PostMapping
    @Secured({ "ROLE_USER" })
    public ResponseEntity<History> createHistory(@RequestBody History history) {
        service.createHistory(history);
        URI location = getUri(history.getPurchase_id());
        return ResponseEntity.created(location).build();
    }

    @GetMapping
    @Secured({ "ROLE_USER" })
    public ResponseEntity<List<History>> getAllHistory() {
        List<History> historyList = service.getAllHistory();
        return historyList.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(historyList);
    }

    @GetMapping("/{client_id}")
    @Secured({ "ROLE_USER" })
    public ResponseEntity<List<History>> findByClientId(@PathVariable("client_id") String client_id) {
        List<History> histories = (List<History>) service.getClientId(client_id);
        return histories.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(histories);
    }

}
