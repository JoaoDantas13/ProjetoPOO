/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.poo.servlet;

import br.senac.sp.poo.dao.FuncionarioDAO;
import br.senac.sp.poo.entidade.Funcionario;
import br.senac.sp.poo.utils.Redirect;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HOME
 */
public class AlterarFuncionarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        
        Funcionario funcionario = FuncionarioDAO.getFuncionarios(id);
        request.setAttribute("funcionario", funcionario);
        
        request.getRequestDispatcher("/funcionarios/alterarFuncionario.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String setor = request.getParameter("setor");
        
            Funcionario funcionario = new Funcionario(id, nome, setor);
            boolean ok = FuncionarioDAO.atualizar(funcionario);
            Redirect.sendRedirect(ok, response);        
           
    }    

}
