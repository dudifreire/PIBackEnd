package com.example.backend.pi.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.backend.pi.models.Aluno;
import com.example.backend.pi.models.Chamada;
import com.example.backend.pi.repositorys.AlunoRepository;
import com.example.backend.pi.repositorys.ChamadaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ChamadaController {

    @Autowired
    private final ChamadaRepository chamadaRepository;
    @Autowired
    private final AlunoRepository alunoRepository;
    
    ChamadaController(ChamadaRepository chamadaRepository, AlunoRepository alunoRepository) {
        this.chamadaRepository = chamadaRepository;
        this.alunoRepository = alunoRepository;
    } 
    
    @CrossOrigin(origins = "*")
    @PostMapping("/chamadas")
    Chamada novaChamada(@RequestBody Chamada chamada) {
     //   Aluno OriginalAluno = new Aluno(OriginalAluno.getId(), OriginalAluno.getNome(), OriginalAluno.getPresente());

       // ArrayList<Aluno> chamadaAluno = new ArrayList<>();
       for (Aluno aluno : chamada.getAluno()) {
            System.out.println(aluno.getPresente());
           alunoRepository.chamadaUpdate(aluno.getId(),aluno.getPresente());
        }
        
        return chamadaRepository.save(chamada);
    }
    public Aluno returnAluno(Aluno aluno) {
        return aluno; 
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/chamadas")
    List<Chamada> all() {
        return chamadaRepository.findAll();

    }

    @GetMapping("/chamadas/{id}")
    Optional<Chamada> one(@PathVariable Long id) {

        return chamadaRepository.findById(id);
    }

}

/*
 * @RequestMapping(value="/api/contextsource/soldier",method=
 * RequestMethod.POST) public Soldier addPeptide(@RequestBody Soldier soldier) {
 * for(Medal s: soldier.getMedals()) { Medal ss =
 * medalService.getMedalById(s.getId()); ss.getMedals().add(soldier);
 * medalService.addMedal(ss); } return null;
 * 
 * } // System.out.println(chamada.getAluno().size()); // ArrayList<Aluno>
 * chamadaAluno = new ArrayList<>(); // for (Aluno aluno : chamada.getAluno()) {
 * // chamadaAluno.add(new
 * Aluno(aluno.getId(),aluno.getNome(),aluno.getPresente())); // } //
 * chamada.setAluno(chamadaAluno);
 */