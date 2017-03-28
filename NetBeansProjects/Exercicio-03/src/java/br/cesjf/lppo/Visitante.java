/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.lppo;

import java.util.Date;

/**
 *
 * @author Adriano
 */
public class Visitante {
    private Long id;
    private String nome;
    private int idade;
    private Date entrada;
    private Date saida;
    
    public Visitante(){
}

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the idade
     */
    public int getIdade() {
        return idade;
    }

    /**
     * @param idade the idade to set
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }

    /**
     * @return the entrada
     */
    public Date getEntrada() {
        return entrada;
    }

    /**
     * @param entrada the entrada to set
     */
    public void setEntrada(Date entrada) {
        this.entrada = entrada;
    }

    /**
     * @return the saida
     */
    public Date getSaida() {
        return saida;
    }

    /**
     * @param saida the saida to set
     */
    public void setSaida(Date saida) {
        this.saida = saida;
    }
}
