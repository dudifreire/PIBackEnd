package com.example.backend.pi.controllers;

import java.util.List;
import java.util.Optional;

import com.example.backend.pi.models.Colaborador;
import com.example.backend.pi.repositorys.ColaboradorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
// @RequestMapping("/colaboradores")
@CrossOrigin(origins = "*", allowedHeaders = "*") // (origins = "http://localhost:8100")
@RestController
public class ColaboradorController {

  @Autowired
  private final ColaboradorRepository colaboradorRepository;

  ColaboradorController(ColaboradorRepository colaboradorRepository) {
    this.colaboradorRepository = colaboradorRepository;
  }

  @CrossOrigin(origins = "*")
  @PostMapping("/colaboradores")
  Colaborador newColaborador(@RequestBody Colaborador colaborador) {
    return colaboradorRepository.save(colaborador);
  }
  @CrossOrigin(origins = "*")
  @GetMapping("/colaboradores")
  List<Colaborador> all() {
    return colaboradorRepository.findAll();
  }

  @GetMapping("/colaboradores/{id}")
  Optional<Colaborador> one(@PathVariable Long id) {
  
      return colaboradorRepository.findById(id);
    }
  
    @PutMapping("/colaboradores/{id}")
    Colaborador replaceColaborador(@RequestBody Colaborador novoColaborador, @PathVariable Long id) {
  
      return colaboradorRepository.findById(id)
        .map(employee -> {
          employee.setNome(novoColaborador.getNome());
          return colaboradorRepository.save(employee);
        })
        .orElseGet(() -> {
          return colaboradorRepository.save(novoColaborador);
        });
    }
  
    @DeleteMapping("/colaboradores/{id}")
    void deleteEmployee(@PathVariable Long id) {
      colaboradorRepository.deleteById(id);
    }
  
    /*@RequestMapping(method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE
    , produces=MediaType.APPLICATION_JSON_VALUE, path= "/colaboradores")
    void addUser(@RequestBody Colaborador colaborador) {
        try{
        colaboradorRepository.save(colaborador);
        System.out.println("funcionou"); 
        }catch(Exception e) {
 
			System.out.println(e); 
		}
    }
    
    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.GET, path= "/colaboradores")
     public void teste(){
        System.out.println("teste");
     }
     
     @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.GET, path= "/teste")
     public void teste2(){
        System.out.println("teste");
     }
     */
}
