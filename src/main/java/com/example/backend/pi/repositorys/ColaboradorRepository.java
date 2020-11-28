package com.example.backend.pi.repositorys;

import com.example.backend.pi.models.Colaborador;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.repository.CrudRepository;


public interface ColaboradorRepository  extends JpaRepository<Colaborador, Long> { //CrudRepository<Colaborador, Long> {
    
}