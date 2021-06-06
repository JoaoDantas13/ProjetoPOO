/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.poo.dao;

import br.senac.sp.poo.conexao.Conexao;
import br.senac.sp.poo.entidade.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HOME
 */
public class ProdutoDAO {
    
   public static List<Produto> getProdutos() {
        List<Produto> produtos = new ArrayList<>();
        String query = "select * from produto";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                String nome = rs.getString("nome");
                String endereco = rs.getString("endereco");
                int quantidade = rs.getInt("quantidade");
                
                Produto produto = new Produto(nome, endereco, quantidade);
                produtos.add(produto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produtos;
    }    
}
