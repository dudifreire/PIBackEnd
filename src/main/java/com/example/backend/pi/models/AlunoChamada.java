package com.example.backend.pi.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ListChamada")
public class AlunoChamada implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    //@OneToMany(mappedBy = "ListChamada", fetch = FetchType.LAZY)
    //public List<Chamada> chamada; 

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ListChamada_id")
    public Long ListchamadaId;
    
    @Column(name = "ListChamada_alunoId")
    public Long alunoId;

    @Column(name = "ListChamada_alunoNome")
    public String alunoNome;
    
    @Column(name = "ListChamada_alunoPresente")
    public String alunoPresente;
    
    @Column(name = "ListChamada_timestamp")
    public String timestamp;

    public Long getListChamadaId() {
        return ListchamadaId;
    }

    public void setAlunoId(long alunoId) {
        this.alunoId = alunoId;
    }

    public String getAlunoPresente() {
        return alunoPresente;
    }

    public void setAlunoPresente(String alunoPresente) {
        this.alunoPresente = alunoPresente;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String string) {
        this.timestamp = string;
    }
    public AlunoChamada() {
       
    }
    

    public AlunoChamada(Long listchamadaId, Long alunoId, String alunoNome, String alunoPresente, String timestamp) {
        this.ListchamadaId = listchamadaId;
        this.alunoId = alunoId;
        this.alunoNome = alunoNome;
        this.alunoPresente = alunoPresente;
        this.timestamp = timestamp;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Long getListchamadaId() {
        return ListchamadaId;
    }

    public void setListchamadaId(Long listchamadaId) {
        ListchamadaId = listchamadaId;
    }

    public void setAlunoId(Long alunoId) {
        this.alunoId = alunoId;
    }

    public String getAlunoNome() {
        return alunoNome;
    }

    public void setAlunoNome(String alunoNome) {
        this.alunoNome = alunoNome;
    }

    @Override
    public String toString() {
        return "AlunoChamada [ListchamadaId=" + ListchamadaId + ", alunoId=" + alunoId + ", alunoNome=" + alunoNome
                + ", alunoPresente=" + alunoPresente + ", timestamp=" + timestamp + "]";
    }
    
    
}
