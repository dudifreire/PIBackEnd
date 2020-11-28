package com.example.backend.pi.repositorys;

import javax.transaction.Transactional;

import com.example.backend.pi.models.Chamada;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface ChamadaRepository extends JpaRepository<Chamada, Long> {
   
 


 //@Modifying
 //@Query("update aluno a set a.aluno_nome = ?1, a.aluno_presente = ?2 where a.aluno_id = ?3")
 //void setUserInfoById(String aluno_nome, String presente, Integer aluno_id);
    
}
