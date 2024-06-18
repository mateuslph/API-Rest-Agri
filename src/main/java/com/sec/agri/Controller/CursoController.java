package com.sec.agri.Controller;

import com.sec.agri.Model.Curso;
import com.sec.agri.Service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/curso")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    // Create a new curso
    @PostMapping
    public ResponseEntity<Curso> createCurso(@RequestBody Curso curso) {
        Curso createdCurso = cursoService.saveCurso(curso);
        return new ResponseEntity<>(createdCurso, HttpStatus.CREATED);
    }

    // Get all cursos
    @GetMapping
    public ResponseEntity<List<Curso>> getAllCursos() {
        List<Curso> cursos = cursoService.getAllCursos();
        return new ResponseEntity<>(cursos, HttpStatus.OK);
    }

    // Get a curso by ID
    @GetMapping("/{id}")
    public ResponseEntity<Curso> getCursoById(@PathVariable Long id) {
        Curso curso = cursoService.getCursoById(id);
        if (curso == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(curso, HttpStatus.OK);
    }

    // Update a curso
    @PutMapping("/{id}")
    public ResponseEntity<Curso> updateCurso(@PathVariable Long id, @RequestBody Curso curso) {
        curso.setId(id); // Ensure ID matches path variable
        Curso updatedCurso = cursoService.saveCurso(curso);
        if (updatedCurso == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedCurso, HttpStatus.OK);
    }

    // Delete a curso
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCurso(@PathVariable Long id) {
        cursoService.deleteCursoById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
