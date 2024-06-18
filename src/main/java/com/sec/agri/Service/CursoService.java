package com.sec.agri.Service;

import com.sec.agri.Model.Curso;
import com.sec.agri.Repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    // Save a curso
    public Curso saveCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    // Get all cursos
    public List<Curso> getAllCursos() {
        return cursoRepository.findAll();
    }

    // Get a curso by ID
    public Curso getCursoById(Long id) {
        return cursoRepository.findById(id).orElse(null);
    }

    // Delete a curso by ID
    public void deleteCursoById(Long id) {
        cursoRepository.deleteById(id);
    }

}
