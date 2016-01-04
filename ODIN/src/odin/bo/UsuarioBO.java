/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odin.bo;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
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

    public ArrayList<Usuario> consultarUsuario() throws SQLException {
        usuarioDAO = new UsuarioDAO();
        ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
        listaUsuarios = usuarioDAO.listarUsuarios();
        return listaUsuarios;
    }
    
    public ArrayList<Professor> consultarProfessor() throws SQLException{
        usuarioDAO = new UsuarioDAO();
        ArrayList<Professor> listaProfessores = new ArrayList<>();
        listaProfessores = usuarioDAO.listarProfessores();
        return listaProfessores;
    }
    public ArrayList<Professor> consultarProfessorVinculado() throws SQLException{
        usuarioDAO = new UsuarioDAO();
        ArrayList<Professor> listaProfessores = new ArrayList<>();
        listaProfessores = usuarioDAO.listarProfessoresVinculados();
        return listaProfessores;
    }
    public ArrayList<Professor> consultarProfessorVinculadoPorDisciplina(int codigoDisciplina)throws SQLException{
        usuarioDAO = new UsuarioDAO();
        ArrayList<Professor> listaProfessores = new ArrayList<>();
        listaProfessores = usuarioDAO.listarProfessoresVinculadosPorDisciplina(codigoDisciplina);
        return listaProfessores;
    }
    public void desvincularProfessor(int codigoProfessor,int codigoDisciplina){
        usuarioDAO = new UsuarioDAO();
        try{
        usuarioDAO.desvincularProfessor(codigoProfessor, codigoDisciplina);
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao desvincular professor: "+e.getMessage());
        }
    }
    public void vincularProfessor(int codigoDisciplina,int codigoProfessor){
        usuarioDAO = new UsuarioDAO();
        try {
        usuarioDAO.vincularProfessor(codigoDisciplina, codigoProfessor);
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao vincular professor: "+e.getMessage());
        }
    }
    public void excluirUsuario(String cpf) throws SQLException {
        usuarioDAO = new UsuarioDAO();
        usuarioDAO.excluir(cpf);
    }

    public void alterarUsuario(String cpf, String nomeUsuario, String loginUsuario, String senhaUsuario) throws SQLException {
        usuarioDAO = new UsuarioDAO();
        usuarioDAO.alterar(cpf, nomeUsuario, loginUsuario, senhaUsuario);

    }
}
