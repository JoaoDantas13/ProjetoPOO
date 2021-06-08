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
public class Revestimento extends Produto{
    private final double m2;
    
    public Revestimento (String nome, String endereco, String metrica, double m2){
        super(nome, endereco, metrica);
        this.m2 = m2;
    }
    
    @Override
    public String toString(){
        return String.format("<br/> %s <br/> M²: %f <br/>", 
                super.toString(), m2);        
    }
}
