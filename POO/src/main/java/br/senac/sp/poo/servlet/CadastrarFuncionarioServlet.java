/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.poo.servlet;

import br.senac.sp.poo.dao.FuncionarioDAO;
import br.senac.sp.poo.dao.ProdutoDAO;
import br.senac.sp.poo.entidade.Funcionario;
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
 * @author HOME
 */
public class CadastrarFuncionarioServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        try {
            String nome = request.getParameter("nome");
            String setor = request.getParameter("setor");
            boolean ok;
            
            Funcionario funcionario = new Funcionario(-1, nome, setor);
            ok = FuncionarioDAO.cadastrar(funcionario);
            
            if(ok){
                
                response.sendRedirect(request.getContextPath() + "/sucesso.jsp");
                
            } else {
                
                String msg = "O cadastro não foi realizado!!";
                request.setAttribute("msgErro", msg);
                request.getRequestDispatcher("/erro.jsp").forward(request, response);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarFuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CadastrarFuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(CadastrarFuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(CadastrarFuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(CadastrarFuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
}
