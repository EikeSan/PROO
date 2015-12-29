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
public class UsuarioDAO {
    Connection conexao;
    UsuarioDAO(Connection conexao){
        this.conexao = conexao;
    }
    
    
    public void inserir(int cpfUsuario,String nomeUsuario,String nomeLogin,String senhaUsuario,String tipoUsuario) throws SQLException{
        Statement stmt;
        try{
            stmt = this.conexao.createStatement();
            stmt.execute("INSERT into usuario(cpf,nome,usuario,senha,tipo_usuario) values('"+cpfUsuario+"','"+nomeUsuario+"','"+nomeLogin+"','"+senhaUsuario+"','"+tipoUsuario+"')");
        }catch (SQLException e){
            throw new SQLException("Erro ao inserir"+e.getMessage());
        }
    }
    public void alterar(String nomeUsuario,String novaSenha) throws SQLException{
        Statement stmt;
        try {
            stmt = this.conexao.createStatement();
            stmt.executeUpdate("UPDATE usuario SET senha='"+novaSenha+"' WHERE usuario='"+nomeUsuario+"'");
        } catch (SQLException e) {
            throw new SQLException("Erro ao alterar usuário -"+e.getMessage());
        }
    }
    
    public void excluir(int cpfUsuario)throws SQLException{
        Statement stmt;
        try{
            stmt = this.conexao.createStatement();
            stmt.executeUpdate("DELETE FROM usuario WHERE cpf='"+cpfUsuario+"'");
        }catch (SQLException e){
            throw  new SQLException("Erro ao excluir usuário -"+e.getMessage());
        }
    }
    
    public String consultar(String usuarioConsultado) throws SQLException{
        ResultSet rs;
        Statement stmt;
        try{
            PreparedStatement pstm = this.conexao.prepareStatement("select usuario from usuario where usuario ='"+usuarioConsultado+"'");
            rs = pstm.executeQuery();
            boolean next = rs.next();
            String usuarioEncontrado = rs.getString(1);
            return usuarioEncontrado;
        }catch (SQLException e){
            throw new SQLException("Erro ao conslutar usuario - "+e.getMessage());
        }
    }
}
