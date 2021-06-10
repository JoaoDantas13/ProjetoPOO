/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.poo.interfaces;

import java.lang.reflect.Method;

/**
 *
 * @author saulo.ambezerra
 */
public interface InterfaceEntidades {
    public abstract Method[] getMetodos() throws NoSuchMethodException;
    public abstract String[] getTabela();
}
