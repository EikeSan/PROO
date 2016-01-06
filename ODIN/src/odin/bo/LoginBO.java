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

    public String validarLogin(String nomeUsuario, String senhaUsuario) throws SQLException {
        LoginDAO login = new LoginDAO();

        if (nomeUsuario.isEmpty() || senhaUsuario.isEmpty()) {
            return "Usuário e/ou senha não informados";
        } else if (nomeUsuario == null || senhaUsuario == null) {
            return "Usuario e/ou senha não informados!";
        } else if (nomeUsuario == "" || senhaUsuario == "") {
            return "Usuario e/ou senha não informados!";
        } else if (nomeUsuario.length() < 5 || nomeUsuario.length() > 12) {
            return "O nome do usuário deve conter mais que 6 e menos 12 caracteres";
        }

        usuarioDAO = new UsuarioDAO();
        try {
            if (login.isDadosValidos(nomeUsuario, senhaUsuario) == true) {
                retornaTelaPeloTipoDeUsuario(usuarioDAO.consultarTipoUsuario(nomeUsuario));
            }
            return "";
        } catch (Exception e) {
            return "Erro ao realizar Login";
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
