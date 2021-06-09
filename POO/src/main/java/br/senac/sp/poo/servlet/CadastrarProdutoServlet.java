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
        boolean ok;
        
        if("unidades".equals(metrica) ){
            int quantidade = Integer.parseInt(request.getParameter("quantidade"));
            Ferramenta ferramenta = new Ferramenta(nome, endereco, metrica, quantidade);
            ok = ProdutoDAO.cadastrar(ferramenta);        
        } 
        
        else if( "m2".equals(metrica)){
            double quantidade = Double.parseDouble(request.getParameter("quantidade"));
            Revestimento revestimento = new Revestimento(nome, endereco, metrica, quantidade);
            ok = ProdutoDAO.cadastrar(revestimento);        
        }
        
        else{
            double quantidade = Double.parseDouble(request.getParameter("quantidade"));
            Granel granel = new Granel(nome, endereco, metrica, quantidade);
            ok = ProdutoDAO.cadastrar(granel);        
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
