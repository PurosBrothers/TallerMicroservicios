package com.taller.ahenao_joanorduz_prietojoshua.repository;

import java.util.HashMap;
import java.util.Map;
import com.taller.ahenao_joanorduz_prietojoshua.model.Estudiante;

import org.springframework.stereotype.Repository;

@Repository
public class EstudianteRepository {

    private final Map<Long, Estudiante> estudiantes = new HashMap<>();
    private Long currentId = 1L;

    public Estudiante save(Estudiante estudiante) {
        if (estudiante.getId() == 0) {
            estudiante.setId((Long) currentId++);
        }
        estudiantes.put(estudiante.getId(), estudiante);
        return estudiante;
    }

    public Map<Long, Estudiante> findAll() {
        return estudiantes;
    }

    public Estudiante findById(Long id) {
        return estudiantes.get(id);
    }

}
