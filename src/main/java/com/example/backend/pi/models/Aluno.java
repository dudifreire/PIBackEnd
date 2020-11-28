package com.example.backend.pi.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name = "aluno")
public class Aluno implements Serializable{

	/**
	 *
	 */
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "aluno_id")
    private long id;
    
    @Column(name = "aluno_categoria")
    private String categoria;

    @Column(name = "aluno_nome")
    private String nome; 
    
    @Column(name = "aluno_responsavel")
    private String responsavel;

    @Column(name = "aluno_foneAluno")
    private Long foneAluno;
    
    @Column(name = "aluno_foneResponsavel")
    private Long foneResponsavel;
    
    @Column(name = "aluno_cep")
    private Long cep;

    @Column(name = "aluno_rua")
    private String rua;
    
    @Column(name = "aluno_numero")
    private Long numero;
    
    @Column(name = "aluno_bairro")
    private String bairro;
    
    @Column(name = "aluno_uf")
    private String uf;
    
    @Column(name = "aluno_date")
    private Date date;
    
    @Column(name = "aluno_presente")
    private String presente;

   // @ManyToMany
  //  @JoinTable(name = "chamada_aluno",
 //      joinColumns = @JoinColumn(name = "aluno_id"),
 //      inverseJoinColumns = @JoinColumn(name = "chamada_id")
//
//    )

   @ManyToMany(mappedBy = "aluno", fetch = FetchType.LAZY)
   @JsonIgnoreProperties("aluno")
   private List<Chamada> chamada; 
    
    public Aluno() {
	}
    

    public Aluno(long id, String nome, String presente) {
        this.id = id;
        this.nome = nome;
        this.presente = presente;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public Long getFoneAluno() {
        return foneAluno;
    }

    public void setFoneAluno(Long foneAluno) {
        this.foneAluno = foneAluno;
    }

    public Long getFoneResponsavel() {
        return foneResponsavel;
    }

    public void setFoneResponsavel(Long foneResponsavel) {
        this.foneResponsavel = foneResponsavel;
    }

    public Long getCep() {
        return cep;
    }

    public void setCep(Long cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPresente() {
        return presente;
    }

    public void setPresente(String presente) {
        this.presente = presente;
    }

    @Override
    public String toString() {
        return "Aluno [bairro=" + bairro + ", categoria=" + categoria + ", cep=" + cep
                + ", date=" + date + ", foneAluno=" + foneAluno + ", foneResponsavel=" + foneResponsavel + ", id=" + id
                + ", nome=" + nome + ", numero=" + numero + ", presente=" + presente + ", responsavel=" + responsavel
                + ", rua=" + rua + ", uf=" + uf + "]";
    }

   public List<Chamada> getChamada() {
        return chamada;
  }

    public void setChamada(List<Chamada> chamada) {
       this.chamada = chamada;
    }
 /*  public Chamada getChamada() {
       return chamada;
    }
    public void setChamada(Chamada chamada) {
           this.chamada = chamada;
     }
 */


    


}
