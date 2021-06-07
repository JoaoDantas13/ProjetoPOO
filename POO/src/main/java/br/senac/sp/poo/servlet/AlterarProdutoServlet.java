/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.poo.servlet;

import br.senac.sp.poo.dao.ProdutoDAO;
import br.senac.sp.poo.entidade.Produto;
import br.senac.sp.poo.utils.Redirect;
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
public class AlterarProdutoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String endereco = request.getParameter("endereco");
        
        Produto produto = ProdutoDAO.getProduto(endereco);
        request.setAttribute("produto", produto);
        
        request.getRequestDispatcher("/produtos/alterarProduto.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String endereco = request.getParameter("endereco");
        int quantidade = Integer.parseInt(request.getParameter("quantidade"));
        
        Produto produto = new Produto(nome, endereco, quantidade);
        boolean ok = ProdutoDAO.atualizar(produto);
        Redirect.sendRedirect(ok, response);        
    }
}
