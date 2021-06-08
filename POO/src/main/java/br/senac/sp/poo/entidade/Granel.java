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
public class Granel extends Produto{
    private final double m3;
    
    public Granel (String nome, String endereco, String metrica, double m3){
        super(nome, endereco, metrica);
        this.m3 = m3;
    }
    
    @Override
    public String toString(){
        return String.format("<br/> %s <br/> M³: %f <br/>", 
                super.toString(), m3);        
    }
}
