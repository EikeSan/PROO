/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odin.bo;

import java.sql.Connection;
import java.sql.SQLException;
import odin.dao.*;
import odin.view.*;

/**
 *
 * @author Eike
 */
public class LoginBO {

    IConexao banco = new ConexaoMySQL();
    Connection conexao = null;
    UsuarioDAO usuarioDAO;

    public void validarLogin(String nomeUsuario, String senhaUsuario) throws SQLException {
        LoginDAO login = new LoginDAO();
        conexao = banco.getConexao("jdbc:mysql", "localhost", "odin", "root", "");
        usuarioDAO = new UsuarioDAO();
        MensagemGUI telaMensagem = new MensagemGUI();
        if (login.isDadosValidos(nomeUsuario, senhaUsuario) == true) {
            telaMensagem.textExibido("Login realizado com sucesso!");
            telaMensagem.setVisible(true);
            retornaTelaPeloTipoDeUsuario(usuarioDAO.consultarTipoUsuario(nomeUsuario));
        }

    }

    public void retornaTelaPeloTipoDeUsuario(String tipoUsuario) {
        AdminViewGUI adminView = new AdminViewGUI();
        AlunoViewGUI alunoView = new AlunoViewGUI();
        ProfessorViewGUI professorView = new ProfessorViewGUI();
        MensagemGUI mensagem = new MensagemGUI();
        switch (tipoUsuario) {
            case "admin": {
                adminView.setVisible(true);
                break;
            }
            case "Aluno": {
                alunoView.setVisible(true);
                break;
            }
            case "Professor": {
                professorView.setVisible(true);
                break;
            }
            default: {
                mensagem.textExibido("Tipo de usuario desconhecido. Contate o adminstrador!");
                mensagem.setVisible(true);
                break;
            }
        }

    }

}
