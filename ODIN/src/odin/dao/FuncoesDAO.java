/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author eike.santiago
 */
public class FuncoesDAO {
    Connection conexao;
    FuncoesDAO(Connection conexao){
        this.conexao = conexao;
    }
    public void inserir(String nomeUsuario,String senhaUsuario) throws SQLException{
        Statement stmt;
        try{
            stmt = this.conexao.createStatement();
            stmt.execute("INSERT into login(usuario,senha) values('"+nomeUsuario+"','"+senhaUsuario+"')");
        }catch (SQLException e){
            throw new SQLException("Erro ao inserir"+e.getMessage());
        }
    }
    public void alterar(String nomeUsuario,String novaSenha) throws SQLException{
        Statement stmt;
        try {
            stmt = this.conexao.createStatement();
            stmt.executeUpdate("UPDATE LOGIN SET senha='"+novaSenha+"' WHERE usuario='"+nomeUsuario+"'");
        } catch (SQLException e) {
            throw new SQLException("Erro ao alterar usuário -"+e.getMessage());
        }
    }
    
    public void excluir(String nomeUsuario)throws SQLException{
        Statement stmt;
        try{
            stmt = this.conexao.createStatement();
            stmt.executeUpdate("DELETE FROM login WHERE usuario='"+nomeUsuario+"'");
        }catch (SQLException e){
            throw  new SQLException("Erro ao excluir usuário -"+e.getMessage());
        }
    }
    
    public String consultar(String usuarioConsultado) throws SQLException{
        ResultSet rs;
        Statement stmt;
        try{
            PreparedStatement pstm = this.conexao.prepareStatement("select usuario from login where usuario ='"+usuarioConsultado+"'");
            rs = pstm.executeQuery();
            String usuarioEncontrado = rs.getString(0);
            return usuarioEncontrado;
        }catch (SQLException e){
            throw new SQLException("Erro ao conslutar usuario - "+e.getMessage());
        }
    }
//    public ArrayList<String> validarLogin(String usuarioConsultado) throws SQLException{
//       ResultSet rs;
//       ArrayList<String> usuarioSenha = new ArrayList<String>();
//       
//       try{
//           PreparedStatement pstm = this.conexao.prepareStatement("select usuario,senha from login where");
//           rs = pstm.executeQuery();
//           
//           while(rs.next()){
//               usuarioSenha.add(rs.getString(usuarioConsultado))
//           }
//       }catch(SQLException e){
//           throw new SQLException("Erro ao validar login - "+e.getMessage());
//       }
//    }
}
