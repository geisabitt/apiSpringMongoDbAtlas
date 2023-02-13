package com.resgatandoanas.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.resgatandoanas.model.Curso;

public interface CursoRepository extends MongoRepository<Curso, String> {

    List<Curso> findByTipo(String tipo);

}