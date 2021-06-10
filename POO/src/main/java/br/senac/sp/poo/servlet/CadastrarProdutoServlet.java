/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.poo.servlet;

import br.senac.sp.poo.dao.ProdutoDAO;
import br.senac.sp.poo.entidade.Ferramenta;
import br.senac.sp.poo.entidade.Granel;
import br.senac.sp.poo.entidade.Revestimento;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Eduardo Silva
 */
public class CadastrarProdutoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String nome = request.getParameter("nome");
        String endereco = request.getParameter("endereco");
        String metrica = request.getParameter("metrica");
        boolean ok = false;
        
        if("unidades".equals(metrica) ){
            try {
                int quantidade = Integer.parseInt(request.getParameter("quantidade"));
                Ferramenta ferramenta = new Ferramenta(nome, endereco, metrica, quantidade);        
                ok = ProdutoDAO.cadastrar(ferramenta);
            } catch (SQLException ex) {
                Logger.getLogger(CadastrarProdutoServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(CadastrarProdutoServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(CadastrarProdutoServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvocationTargetException ex) {
                Logger.getLogger(CadastrarProdutoServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchMethodException ex) {
                Logger.getLogger(CadastrarProdutoServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        
        else if( "m2".equals(metrica)){
            try {
                double quantidade = Double.parseDouble(request.getParameter("quantidade"));
                Revestimento revestimento = new Revestimento(nome, endereco, metrica, quantidade);        
                ok = ProdutoDAO.cadastrar(revestimento);
            } catch (SQLException ex) {
                Logger.getLogger(CadastrarProdutoServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(CadastrarProdutoServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(CadastrarProdutoServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvocationTargetException ex) {
                Logger.getLogger(CadastrarProdutoServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchMethodException ex) {
                Logger.getLogger(CadastrarProdutoServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        else{
            try {
                double quantidade = Double.parseDouble(request.getParameter("quantidade"));
                Granel granel = new Granel(nome, endereco, metrica, quantidade);        
                ok = ProdutoDAO.cadastrar(granel);
            } catch (SQLException ex) {
                Logger.getLogger(CadastrarProdutoServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(CadastrarProdutoServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(CadastrarProdutoServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvocationTargetException ex) {
                Logger.getLogger(CadastrarProdutoServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchMethodException ex) {
                Logger.getLogger(CadastrarProdutoServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(ok){
            
            response.sendRedirect(request.getContextPath() + "/sucesso.jsp");
            
        } else {
            
            String msg = "O cadastro não foi realizado!!";
            request.setAttribute("msgErro", msg);
            request.getRequestDispatcher("/erro.jsp").forward(request, response);
            
        }
    }  
}
