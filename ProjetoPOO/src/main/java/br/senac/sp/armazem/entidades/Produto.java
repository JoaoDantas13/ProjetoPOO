/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.armazem.entidades;

import br.senac.sp.armazem.interfaces.InterfaceEntidades;
import java.lang.reflect.Method;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author saulo.ambezerra
 */
@Getter
@Setter
public class Produto extends Entidade implements InterfaceEntidades {
    
    private float quantidade;

    public Produto(String nome, String setor, float quantidade) {
        super(nome, setor);
        this.quantidade = quantidade;
    }

  

    @Override
    public String[] getTabela(){
        String[] tabela = {"produto", "id", "nome", "setor", "quantidade"};
        
        return tabela;
    }

    @Override
    public Method[] getMetodos() throws NoSuchMethodException{
        Method[] metodos = {Produto.class.getMethod("getId"),Produto.class.getMethod("getNome"),Produto.class.getMethod("getSetor"), Produto.class.getMethod("quantidade")};
        
        return metodos;
    }
    
}
