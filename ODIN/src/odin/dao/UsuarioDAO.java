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
import odin.model.*;

/**
 *
 * @author eike.santiago
 */
public class UsuarioDAO {

    Connection conexao;

    public UsuarioDAO() {

    }

    public Connection conexaoMySQL() throws SQLException {
        IConexao banco = new ConexaoMySQL();
        conexao = banco.getConexao("jdbc:mysql", "localhost", "odin", "root", "");
        return this.conexao;
    }

    public void inserir(String cpfUsuario, String nomeUsuario, String nomeLogin, String senhaUsuario, String tipoUsuario) throws SQLException {
        Statement stmt;
        try {
            stmt = conexaoMySQL().createStatement();
            stmt.execute("INSERT into usuario(cpf,nome,usuario,senha,tipo_usuario) values('" + cpfUsuario + "','" + nomeUsuario + "','" + nomeLogin + "','" + senhaUsuario + "','" + tipoUsuario + "')");
        } catch (SQLException e) {
            throw new SQLException("Erro ao inserir" + e.getMessage());
        }
    }

    public void alterar(String cpfUsuario, String novoNome, String novoLogin,String novaSenha) throws SQLException {
        Statement stmt;
        try {
            stmt = conexaoMySQL().createStatement();
            if(isCpfExiste(cpfUsuario) == true){
                stmt.executeUpdate("UPDATE usuario SET senha='" + novaSenha + "',usuario='"+novoLogin+"', nome='"+novoNome+"' WHERE cpf='" + cpfUsuario + "'");
            }
        } catch (SQLException e) {
            throw new SQLException("Erro ao alterar usuário -" + e.getMessage());
        }
    }

    public void excluir(String cpfUsuario) throws SQLException {
        Statement stmt;
        try {
            stmt = conexaoMySQL().createStatement();
            stmt.executeUpdate("DELETE FROM usuario WHERE cpf='" + cpfUsuario + "'");
        } catch (SQLException e) {
            throw new SQLException("Erro ao excluir usuário -" + e.getMessage());
        }
    }

    public String consultar(String usuarioConsultado) throws SQLException {
        ResultSet rs;
        Statement stmt;
        try {
            PreparedStatement pstm = conexaoMySQL().prepareStatement("select usuario from usuario where usuario ='" + usuarioConsultado + "'");
            rs = pstm.executeQuery();
            boolean next = rs.next();
            String usuarioEncontrado = rs.getString(1);
            return usuarioEncontrado;
        } catch (SQLException e) {
            throw new SQLException("Erro ao conslutar usuario - " + e.getMessage());
        }
    }
    
    public boolean isCpfExiste(String cpf)throws SQLException{
        ResultSet rs;
        Statement stmt;
        try {
            PreparedStatement pstm = conexaoMySQL().prepareStatement("select usuario from usuario where cpf ='" + cpf + "'");
            rs = pstm.executeQuery();
            boolean next = rs.next();
            String cpfEncontrado = rs.getString(1);
            return true;
        } catch (Exception e) {
            throw new SQLException("CPF não existe!"+e.getMessage());
        }
    }

    public String consultarTipoUsuario(String loginUsuario) throws SQLException {
        ResultSet rs;
        Statement stmt;
        try {
            PreparedStatement pstm = conexaoMySQL().prepareStatement("Select tipo_usuario from usuario where usuario= '" + loginUsuario + "'");
            rs = pstm.executeQuery();
            boolean next = rs.next();
            String tipoEncontrado = rs.getString(1);
            return tipoEncontrado;
        } catch (SQLException e) {
            throw new SQLException("Erro ao conslutar o tipo de usuario - " + e.getMessage());
        }
    }

    public ArrayList<Usuario> listarUsuarios() throws SQLException {
        ResultSet rs;
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();

        try {
            PreparedStatement pstm = conexaoMySQL().prepareStatement("select cpf,usuario, nome, senha, tipo_usuario from usuario");
            rs = pstm.executeQuery();

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setCPFUsuario(rs.getString("cpf"));
                usuario.setLoginUsuario(rs.getString("usuario"));
                usuario.setNomeUsuario(rs.getString("nome"));
                usuario.setSenhaUsuario(rs.getString("senha"));
                usuario.setTipoUsuario(rs.getString("tipo_usuario"));
                listaUsuarios.add(usuario);
            }

            return listaUsuarios;
        } catch (SQLException e) {
            throw new SQLException("Erro listar usuários - " + e.getMessage());
        }
    }
}
