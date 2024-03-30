package com.blogletsgo.controller;

import org.springframework.web.bind.annotation.RestController;
import com.blogletsgo.model.Festa;
import com.blogletsgo.repository.FestaRepository;

import jakarta.websocket.server.PathParam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/festas")
public class FestaController {

    @Autowired
    private FestaRepository repository;

    @GetMapping
    public ResponseEntity<List<Festa>> getFindAll() {
        List<Festa> list = repository.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public Festa postMethodName(@RequestParam Festa entity) {
        return repository.save(entity);
    }
    
}
