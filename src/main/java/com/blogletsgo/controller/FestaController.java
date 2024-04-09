package com.blogletsgo.controller;

import org.springframework.web.bind.annotation.RestController;
import com.blogletsgo.model.Festa;
import com.blogletsgo.service.FestaService;

import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    private FestaService service;

    @GetMapping
    public ResponseEntity<List<Festa>> getFindAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @PostMapping
    public ResponseEntity<Festa> save(@RequestBody Festa festaP) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(festaP));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Festa> findById(@PathVariable Long id){
        Festa festa = service.findByid(id);
        return ResponseEntity.status(HttpStatus.OK).body(festa);
    }       
}
