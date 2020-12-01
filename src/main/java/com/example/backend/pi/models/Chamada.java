package com.example.backend.pi.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "chamada")
public class Chamada implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "chamada_id")
    private long id;
    
   
  //  @ManyToMany(mappedBy = "chamada")
  //  private List<Aluno> aluno = new ArrayList<>();
  // @JsonProperty
   @ManyToMany(fetch = FetchType.LAZY)
   //@JsonIgnoreProperties("chamada")
   @JoinTable(name = "chamada_aluno",
       joinColumns = @JoinColumn(name = "chamada_id"),
       inverseJoinColumns = @JoinColumn(name = "aluno_id"))
    private List<Aluno> aluno;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "list_chamada_aluno",
       joinColumns = @JoinColumn(name = "chamada_id"),
       inverseJoinColumns = @JoinColumn(name = "ListChamada_id"))
    private List<AlunoChamada> listChamada;

    @Column(name = "chamada_professor")
    private String professor;

    @Column(name = "chamada_data")
    private String data;

    @Column(name = "chamada_obs")
    private String obs;

    public Chamada() {
    }

    public Chamada(Long id) {
        this.id = id;

    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public List<Aluno> getAluno() {
        return aluno;
    }

    public void setAluno(List<Aluno> aluno) {
        this.aluno = aluno;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    @Override
    public String toString() {
        return "Chamada [aluno=" + aluno + ", data=" + data + ", id=" + id + ", obs=" + obs + ", professor=" + professor
                + "]";
    }

    public List<AlunoChamada> getListChamada() {
        return listChamada;
    }

    public void setListChamada(List<AlunoChamada> listChamada) {
        this.listChamada = listChamada;
    }

}
