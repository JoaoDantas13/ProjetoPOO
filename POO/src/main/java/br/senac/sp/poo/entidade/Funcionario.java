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
 * @author HOME
 */
@Getter
@Setter
public class Funcionario extends Entidade {
    private int id;
    private String nome;
    private String setor;
    
    public Funcionario(int id, String nome, String setor){
        this.id = id;
        this.nome = nome;
        this.setor = setor;
    }
    
     @Override
    public String[] getTabela(){
        String[] tabela = {"Funcionario" ,"nome", "setor"};
        
        return tabela;
    }

    @Override
    public Method[] getMetodos() throws NoSuchMethodException{
        Method[] metodos = {Funcionario.class.getMethod("getNome"),Funcionario.class.getMethod("getSetor")};
        
        return metodos;
    }
    
    @Override
    public String toString(){
        return String.format("<br/> Id: %d <br/> Nome: %s <br/> Setor: %s <br/>", 
                id, nome, setor);        
    }
}
