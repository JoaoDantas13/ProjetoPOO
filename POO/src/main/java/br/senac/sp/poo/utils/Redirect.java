/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.poo.utils;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Eduardo Silva
 */
public class Redirect {
        public static void sendRedirect(boolean ok, HttpServletResponse response) throws IOException {
        
        if (ok){
            
            response.sendRedirect("sucesso.jsp");
            
        } else {
            
            response.sendRedirect("erro.jsp");
            
        }
    }
}
