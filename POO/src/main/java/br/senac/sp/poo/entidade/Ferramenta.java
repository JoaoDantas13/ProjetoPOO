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
public class Ferramenta extends Produto {

    private final int unidades;

    public Ferramenta(String nome, String endereco, String metrica, int unidades) {
        super(nome, endereco, metrica);
        this.unidades = unidades;
    }

    @Override
    public String[] getTabela() {
        String[] tabela = {"produto", "nome", "endereco", "metrica", "quantidade"};

        return tabela;
    }

    @Override
    public Method[] getMetodos() throws NoSuchMethodException {
        Method[] metodos = {Produto.class.getMethod("getNome"), Produto.class.getMethod("getEndereco"), Produto.class.getMethod("getMetrica"), Ferramenta.class.getMethod("getUnidades")};

        return metodos;
    }

    @Override
    public String toString() {
        return String.format("<br/> %s <br/> Unidades: %d <br/>",
                super.toString(), unidades);
    }
}
