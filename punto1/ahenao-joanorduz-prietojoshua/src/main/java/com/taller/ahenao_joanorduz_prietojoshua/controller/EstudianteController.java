package com.taller.ahenao_joanorduz_prietojoshua.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taller.ahenao_joanorduz_prietojoshua.model.Estudiante;
import com.taller.ahenao_joanorduz_prietojoshua.service.EstudianteService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/taller")
public class EstudianteController {

    @Autowired
    EstudianteService service;
    Estudiante estudiante;

    @GetMapping("/person")
    public ResponseEntity<List<Estudiante>> getAll() {
        List<Estudiante> estudiantes = service.getAllEstudiantes();
        return estudiantes.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(estudiantes);
    }

    @GetMapping("/person/{id}")
    public ResponseEntity<Estudiante> getById(@org.springframework.web.bind.annotation.PathVariable Long id) {
        estudiante = service.getEstudianteById(id);
        return estudiante == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(estudiante);
    }
}
