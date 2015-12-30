/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odin.bo;

import java.sql.Connection;
import java.sql.SQLException;
import odin.dao.ConexaoMySQL;
import odin.dao.IConexao;
import odin.dao.LoginDAO;
import odin.dao.UsuarioDAO;
import odin.view.MensagemGUI;
import odin.view.OdinViewGUI;
import odin.view.*;

/**
 *
 * @author Eike
 */
public class LoginBO {
    IConexao banco = new ConexaoMySQL();
    Connection conexao = null;
    
     public void validarLogin(String nomeUsuario, String senhaUsuario) throws SQLException{
         LoginDAO login = new LoginDAO();
         conexao = banco.getConexao("jdbc:mysql", "localhost", "odin", "root", "");
         UsuarioDAO usuarioDAO = new UsuarioDAO();
         MensagemGUI telaMensagem = new MensagemGUI();
         if(login.isDadosValidos(nomeUsuario, senhaUsuario) == true){
             OdinViewGUI tela = new OdinViewGUI();
             telaMensagem.textExibido("Login realizado com sucesso!");
             telaMensagem.setVisible(true);
//             System.out.println(usuarioDAO.consultarTipoUsuario(nomeUsuario));

         }
             
     }
     
     public void retornaTelaPeloTipoDeUsuario(String tipoUsuario){
         AdminViewGUI adminView = new AdminViewGUI();
         if (tipoUsuario == "admin"){
             adminView.setVisible(true);
         }
             
     }
    
}
