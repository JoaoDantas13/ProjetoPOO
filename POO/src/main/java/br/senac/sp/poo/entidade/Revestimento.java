/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.poo.entidade;

import java.lang.reflect.Method;
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
    public String[] getTabela() {
        String[] tabela = {"produto", "nome", "endereco", "metrica", "quantidade"};

        return tabela;
    }

    @Override
    public Method[] getMetodos() throws NoSuchMethodException {
        Method[] metodos = {Produto.class.getMethod("getNome"), Produto.class.getMethod("getEndereco"), Produto.class.getMethod("getMetrica"), Revestimento.class.getMethod("getM2")};

        return metodos;
    }
    
    @Override
    public String toString(){
        return String.format("<br/> %s <br/> M²: %f <br/>", 
                super.toString(), m2);        
    }
}
