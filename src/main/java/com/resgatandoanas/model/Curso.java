package com.resgatandoanas.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "cursos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Curso {

    @Id
    private String cursoId;
    private String nome;
    private String tipo;
    private String descricao;
    private Number valor;
}