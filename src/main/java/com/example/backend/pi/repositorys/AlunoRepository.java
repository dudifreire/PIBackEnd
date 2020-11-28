package com.example.backend.pi.repositorys;

import javax.transaction.Transactional;

import com.example.backend.pi.models.Aluno;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

@Transactional
@Modifying   
@Query("update Aluno a set a.presente = :presente WHERE a.id = :customerId")
    void chamadaUpdate(@Param("customerId") Long id, @Param("presente") String presente);
    
}
