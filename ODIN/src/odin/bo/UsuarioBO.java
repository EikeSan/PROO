/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odin.bo;
import java.sql.SQLException;
import odin.view.*;
import odin.dao.*;
/**
 *
 * @author Eike
 */
public class UsuarioBO {
    public void inserirUsuario(String cpf, String nomeUsuario, String loginUsuario,String senhaUsuario, String tipoUsuario) throws SQLException{
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        try {
            usuarioDAO.inserir(cpf, nomeUsuario, loginUsuario, senhaUsuario, tipoUsuario);
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
        
    }
}
