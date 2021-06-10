/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.poo.servlet;

import br.senac.sp.poo.dao.FuncionarioDAO;
import br.senac.sp.poo.entidade.Funcionario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HOME
 */
public class FuncionarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        
        List<Funcionario> listaFuncionarios = FuncionarioDAO.getFuncionarios();
        
                
        request.setAttribute("listaFuncionarios", listaFuncionarios);
        
        request.getRequestDispatcher("/funcionarios/listaFuncionarios.jsp").forward(request, response);
    }
}
