package com.resgatandoanas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.resgatandoanas.model.Curso;
import com.resgatandoanas.service.CursoService;

@RestController
@RequestMapping("/api/cursos")

public class CursoController {

    @Autowired
    private CursoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Curso createCurso(@RequestBody Curso curso) {
        return service.addCurso(curso);
    }

    @GetMapping
    public List<Curso> getCursos() {
        return service.findAllCursos();
    }

    @GetMapping("/{cursoId}")
    public Curso getCurso(@PathVariable String cursoId) {
        return service.getCursoByCursoId(cursoId);
    }

    @GetMapping("/tipo/{tipo}")
    public List<Curso> findCursoUsingTipo(@PathVariable String tipo) {
        return service.getCursoByTipo(tipo);
    }

    @PatchMapping
    public Curso modifyCurso(@RequestBody Curso curso) {
        return service.updateCurso(curso);
    }

    @DeleteMapping("/{cursoId}")
    public String deleteCurso(@PathVariable String cursoId) {
        return service.deleteCurso(cursoId);
    }

}
