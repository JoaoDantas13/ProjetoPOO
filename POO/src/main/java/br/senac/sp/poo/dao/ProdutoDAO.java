/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.poo.dao;

import br.senac.sp.poo.conexao.Conexao;
import br.senac.sp.poo.entidade.Ferramenta;
import br.senac.sp.poo.entidade.Granel;
import br.senac.sp.poo.entidade.Produto;
import br.senac.sp.poo.entidade.Revestimento;
import br.senac.sp.poo.interfaces.Acoes;
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
public class ProdutoDAO implements Acoes{
    
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
                String metrica = rs.getString("metrica");
                                
                if("unidade".equals(metrica)){
                    int unidades = rs.getInt("quantidade");
                    Ferramenta produto = new Ferramenta(nome, endereco, metrica, unidades);
                    produtos.add(produto);
                } else if ("m2".equals(metrica)){
                    double quantidade = rs.getDouble("quantidade");
                    Revestimento produto = new Revestimento(nome, endereco, metrica, quantidade);
                    produtos.add(produto);
                } else {
                    double quantidade = rs.getDouble("quantidade");
                    Granel produto = new Granel(nome, endereco, metrica, quantidade);
                    produtos.add(produto);
                }
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produtos;
    }    
       
    public static Produto getProduto(String endereco) {
        Produto produto = null;
        String query = "select * from produto where endereco=?";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, endereco);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                String nome = rs.getString("nome");                
                String metrica = rs.getString("metrica");
                
                if("unidade".equals(metrica)){
                    int quantidade = rs.getInt("quantidade");
                    produto = new Ferramenta(nome, endereco, metrica, quantidade);
                } else if ("m2".equals(metrica)){
                    double quantidade = rs.getDouble("quantidade");
                    produto = new Revestimento(nome, endereco, metrica, quantidade);
                } else {
                    double quantidade = rs.getDouble("quantidade");
                    produto = new Granel(nome, endereco, metrica, quantidade);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produto;
    }     
    
    public static boolean atualizar(Ferramenta produto){
        boolean ok = true;
        String query = "update produto set nome=?, metrica=?, quantidade=?"
                + " where endereco=?";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, produto.getNome());
            ps.setString(2, produto.getMetrica());            
            ps.setInt(3, produto.getUnidades());
            ps.setString(4, produto.getEndereco());            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
        return ok;
    }
    
    public static boolean atualizar(Revestimento produto){
        boolean ok = true;
        String query = "update produto set nome=?, metrica=?, quantidade=?"
                + " where endereco=?";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, produto.getNome());
            ps.setString(2, produto.getMetrica());            
            ps.setDouble(3, produto.getM2());
            ps.setString(4, produto.getEndereco());            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
        return ok;
    }    
    
    public static boolean atualizar(Granel produto){
        boolean ok = true;
        String query = "update produto set nome=?, metrica=?, quantidade=?"
                + " where endereco=?";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, produto.getNome());
            ps.setString(2, produto.getMetrica());            
            ps.setDouble(3, produto.getM3());
            ps.setString(4, produto.getEndereco());            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
        return ok;
    }        

    
    public static boolean inativar(String endereco){
        boolean ok = true;
        String query = "delete from produto where endereco=?";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, endereco);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
        return ok;    }        

    @Override
    public boolean inativo(String endereco){
        return true;
    }
    
    public static boolean cadastrar(Ferramenta ferramenta){
        boolean ok = true;
        String query = "insert into produto (nome, endereco, metrica, quantidade) values (?,?,?,?)";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, ferramenta.getNome());
            ps.setString(2, ferramenta.getEndereco());
            ps.setString(3, ferramenta.getMetrica());
            ps.setDouble(4, ferramenta.getUnidades());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
        return ok;        
    }     
    
    public static boolean cadastrar(Revestimento revestimento){
        boolean ok = true;
        String query = "insert into produto (nome, endereco, metrica, quantidade) values (?,?,?,?)";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, revestimento.getNome());
            ps.setString(2, revestimento.getEndereco());
            ps.setString(3, revestimento.getMetrica());
            ps.setDouble(4, revestimento.getM2());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
        return ok;        
    }
    
    public static boolean cadastrar(Granel granel){
        boolean ok = true;
        String query = "insert into produto (nome, endereco, metrica, quantidade) values (?,?,?,?)";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, granel.getNome());
            ps.setString(2, granel.getEndereco());
            ps.setString(3, granel.getMetrica());
            ps.setDouble(4, granel.getM3());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
        return ok;        
    }    
}
