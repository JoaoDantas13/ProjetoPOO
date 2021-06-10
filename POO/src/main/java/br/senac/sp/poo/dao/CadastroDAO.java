/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.poo.dao;

import br.senac.sp.poo.conexao.Conexao;
import br.senac.sp.poo.entidade.Entidade;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author saulo.ambezerra
 */
public class CadastroDAO {

    public static <T extends Entidade> boolean cadastrar(T entidade) throws SQLException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException {
        boolean ok = true;
        Method[] metodos = entidade.getMetodos();
        String[] tabela = entidade.getTabela();
        String sb1 = "insert into " + tabela[0];
        StringBuilder sb2 = new StringBuilder(" ()");
        StringBuilder sb3 = new StringBuilder(" values ()");

        for (int i = (tabela.length - 1); i > 0; i--) {
            sb2.insert(2, tabela[i]);
            sb3.insert(9, '?');
            if (i == 1) {
                break;
            }
            sb2.insert(2, ", ");
            sb3.insert(9, ", ");
        }
        String query = sb1 + sb2.toString() + sb3.toString();
        Connection con;
        try {
            con = Conexao.getConexao();
            System.out.println(query);
            PreparedStatement ps = con.prepareStatement(query);

            for (int i = 0; i < metodos.length; i++) {
                ps.setObject((i + 1), metodos[i].invoke(entidade));
            }
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CadastroDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }

        return ok;
    }
}
