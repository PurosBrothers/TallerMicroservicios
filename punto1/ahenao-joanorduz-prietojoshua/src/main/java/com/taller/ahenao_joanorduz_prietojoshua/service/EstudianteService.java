package com.taller.ahenao_joanorduz_prietojoshua.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taller.ahenao_joanorduz_prietojoshua.model.Estudiante;
import com.taller.ahenao_joanorduz_prietojoshua.repository.EstudianteRepository;

import jakarta.annotation.PostConstruct;

@Service
public class EstudianteService {
    @Autowired
    private EstudianteRepository repo;
    private Estudiante estudiante;

    @PostConstruct
    public void init() {
        repo.save(new Estudiante(0L, "Joshua Prieto", "prietojoshua@javeriana.edu.co"));
        repo.save(new Estudiante(0L, "Andres Henao", "ahenaon@javeriana.edu.co"));
        repo.save(new Estudiante(0L, "Joan Orduz", "joan_orduz@javeriana.edu.co"));
    }

    public List<Estudiante> getAllEstudiantes() {
        return repo.findAll().values().stream().toList();
    }

    public Estudiante getEstudianteById(Long id) {
        estudiante = repo.findById(id);
        Estudiante es = new Estudiante(estudiante.getNombre(), estudiante.getCorreo());
        return es;
    }

}
