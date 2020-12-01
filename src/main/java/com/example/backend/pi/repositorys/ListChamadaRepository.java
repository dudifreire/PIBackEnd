package com.example.backend.pi.repositorys;

import com.example.backend.pi.models.AlunoChamada;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ListChamadaRepository extends JpaRepository<AlunoChamada, Long> {
    
}
