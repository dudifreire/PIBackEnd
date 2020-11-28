package com.example.backend.pi.controllers;

import java.util.List;


import com.example.backend.pi.models.Aluno;
import com.example.backend.pi.repositorys.AlunoRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*") // (origins = "http://localhost:8100")
@RestController
public class AlunoController {

    @Autowired
    private final AlunoRepository alunoRepository;

    AlunoController(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/alunos")
    Aluno newAluno(@RequestBody Aluno aluno) {
       return alunoRepository.save(aluno);
        
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/alunos")
    List<Aluno> all() {
       return alunoRepository.findAll();
        
    }

}
