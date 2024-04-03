package com.blogletsgo.controller;

import org.springframework.web.bind.annotation.RestController;
import com.blogletsgo.model.Festa;
import com.blogletsgo.repository.FestaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/festas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FestaController {

    @Autowired
    private FestaRepository repository;

    @GetMapping
    public ResponseEntity<List<Festa>> getFindAll() {
        List<Festa> list = repository.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<Festa> save(@RequestBody Festa entity) {
        Festa festasave =  entity;
        festasave.setData_criada((LocalDate.now(ZoneId.systemDefault())));
        festasave.setStatus(true);
        repository.save(festasave);
        return ResponseEntity.status(HttpStatus.CREATED).body(festasave);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Festa> findById(@PathVariable Long id){
        Festa festa = repository.findById(id).orElseThrow();
        return ResponseEntity.status(HttpStatus.OK).body(festa);
    }       
}
