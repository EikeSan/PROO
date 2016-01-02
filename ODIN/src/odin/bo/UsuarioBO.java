/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odin.bo;

import java.sql.SQLException;
import java.util.ArrayList;
import odin.view.*;
import odin.dao.*;
import odin.model.*;

/**
 *
 * @author Eike
 */
public class UsuarioBO {
    private UsuarioDAO usuarioDAO;
    public void inserirUsuario(String cpf, String nomeUsuario, String loginUsuario, String senhaUsuario, String tipoUsuario) throws SQLException {
        usuarioDAO = new UsuarioDAO();
        try {
            usuarioDAO.inserir(cpf, nomeUsuario, loginUsuario, senhaUsuario, tipoUsuario);
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
    
    public ArrayList<Usuario> consultarUsuario() throws SQLException{
        usuarioDAO = new UsuarioDAO();
        ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
        listaUsuarios = usuarioDAO.listarUsuarios();
        return listaUsuarios;
    }
    
    public void excluirUsuario(String cpf) throws SQLException{
        usuarioDAO = new UsuarioDAO();
        usuarioDAO.excluir(cpf);
    }
    
    public void alterarUsuario(String cpf, String nomeUsuario, String loginUsuario, String senhaUsuario) throws SQLException{
        usuarioDAO = new UsuarioDAO();
        usuarioDAO.alterar(cpf, nomeUsuario, loginUsuario, senhaUsuario);
       

    }
}
