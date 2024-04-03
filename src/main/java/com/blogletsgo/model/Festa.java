package com.blogletsgo.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Festa
 */
@Entity
@Table(name = "festas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Festa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 60)
    private String nome;
    private String descricao;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate data_criada;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate data_prevista;
    private Boolean status;
    private int limite_participantes;   
}