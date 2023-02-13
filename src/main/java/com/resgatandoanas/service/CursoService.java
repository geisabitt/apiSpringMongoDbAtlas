package com.resgatandoanas.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resgatandoanas.model.Curso;
import com.resgatandoanas.repository.CursoRepository;

@Service
public class CursoService {

    @Autowired
    private CursoRepository repository;

    // CRUD CREAT , READ , UPDATE , DELETE

    public Curso addCurso(Curso curso) {
        curso.setCursoId(UUID.randomUUID().toString().split("-")[0]);
        return repository.save(curso);
    }

    public List<Curso> findAllCursos() {
        return repository.findAll();
    }

    public Curso getCursoByCursoId(String cursoId) {
        return repository.findById(cursoId).get();
    }

    public List<Curso> getCursoByTipo(String tipo) {
        return repository.findByTipo(tipo);
    }

    public Curso updateCurso(Curso cursoRequest) {
        Curso existingCurso = repository.findById(cursoRequest.getCursoId()).get();
        existingCurso.setNome(cursoRequest.getNome());
        existingCurso.setTipo(cursoRequest.getTipo());
        existingCurso.setDescricao(cursoRequest.getDescricao());
        existingCurso.setValor(cursoRequest.getValor());
        return repository.save(existingCurso);
    }

    public String deleteCurso(String cursoId) {
        repository.deleteById(cursoId);
        return cursoId + " Curso removido do sistema ";
    }

}
