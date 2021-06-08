/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.poo.entidade;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Eduardo Silva
 */


@Getter
@Setter
public class Produto {
    private String nome;
    private String endereco;
    private String metrica;
    
    public Produto(String nome, String endereco, String metrica){
        this.nome = nome;
        this.endereco = endereco;
        this.metrica = metrica;
    }
    
    @Override
    public String toString(){
        return String.format("<br/> Nome: %s <br/> Endereco: %s <br/> Métrica: %s <br/>", 
                nome,endereco,metrica);
        }
}
