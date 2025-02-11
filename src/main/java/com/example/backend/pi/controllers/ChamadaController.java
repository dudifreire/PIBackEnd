package com.example.backend.pi.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.backend.pi.models.Aluno;
import com.example.backend.pi.models.AlunoChamada;
import com.example.backend.pi.models.Chamada;
import com.example.backend.pi.repositorys.AlunoRepository;
import com.example.backend.pi.repositorys.ChamadaRepository;
import com.example.backend.pi.repositorys.ListChamadaRepository;

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
    @Autowired
    private final ListChamadaRepository listChamadaRepository;
    
    ChamadaController(ChamadaRepository chamadaRepository, AlunoRepository alunoRepository,ListChamadaRepository listChamadaRepository ) {
        this.chamadaRepository = chamadaRepository;
        this.alunoRepository = alunoRepository;
        this.listChamadaRepository = listChamadaRepository;
    } 
    
    @CrossOrigin(origins = "*")
    @PostMapping("/chamadas")
    Chamada novaChamada(@RequestBody Chamada chamada) {
     //   Aluno OriginalAluno = new Aluno(OriginalAluno.getId(), OriginalAluno.getNome(), OriginalAluno.getPresente());
       
       // ArrayList<Aluno> chamadaAluno = new ArrayList<>();
       ArrayList<AlunoChamada> chamadaAluno = new ArrayList<>();
       System.out.println(chamada);
       for (Aluno aluno : chamada.getAluno()) {
           
        AlunoChamada listChamada = new AlunoChamada();
        listChamada.setAlunoId(aluno.getId());
        listChamada.setAlunoPresente(aluno.getPresente());
        listChamada.setAlunoNome(aluno.getNome());
        listChamada.setTimestamp(chamada.getData());
        listChamada.setAlunoCategoria(aluno.getCategoria());
        System.out.println(aluno.getCategoria());
        listChamadaRepository.save(listChamada);
        chamadaAluno.add(new AlunoChamada(listChamada.getListChamadaId(), aluno.getId(),aluno.getNome(),aluno.getPresente(),chamada.getData(),aluno.getCategoria())); 
        
        
        
    }   
        chamada.setListChamada(chamadaAluno);
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