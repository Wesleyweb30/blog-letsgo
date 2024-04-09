package com.blogletsgo.service;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogletsgo.model.Festa;
import com.blogletsgo.repository.FestaRepository;

@Service
public class FestaService {
    
    @Autowired
    private FestaRepository repository;

    public Festa save(Festa festaP){
        Festa festaObj = festaP;
        festaObj.setData_criada(LocalDate.now(ZoneId.systemDefault()));
        festaObj.setStatus(true);
        return repository.save(festaObj);
    }

    public List<Festa> findAll(){
        List<Festa> festas = repository.findAll();
        return festas;
    }

    public Festa findByid(Long id){
        Festa festa = repository.findById(id).orElseThrow();
        return festa;
    }

}
