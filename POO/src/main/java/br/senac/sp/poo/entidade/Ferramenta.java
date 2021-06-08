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
public class Ferramenta extends Produto{
    private final int unidades;
    
    public Ferramenta (String nome, String endereco, String metrica, int unidades){
        super(nome, endereco, metrica);
        this.unidades = unidades;
    }
    
    @Override
    public String toString(){
        return String.format("<br/> %s <br/> Unidades: %d <br/>", 
                super.toString(), unidades);        
    }
}
