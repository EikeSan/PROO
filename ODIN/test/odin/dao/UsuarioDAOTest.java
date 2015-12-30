/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odin.dao;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import junit.framework.TestCase;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import odin.dao.ConexaoMySQL;
import odin.dao.UsuarioDAO;
import odin.dao.IConexao;

/**
 *
 * @author eike.santiago
 */
public class UsuarioDAOTest extends TestCase {
    IConexao banco = new ConexaoMySQL();
    Connection conexao = null;
    UsuarioDAO usuarioDAO;
    
    @Override
    protected void setUp() throws Exception {
        conexao = banco.getConexao("jdbc:mysql", "localhost", "odin", "root", "");
        usuarioDAO = new UsuarioDAO(conexao);
        super.setUp();
    }
  
    @Test
    public void testDeveriaInserirUsuario() throws Exception {    
        try{
            conexao.setAutoCommit(false);
            usuarioDAO.inserir(1234,"test", "test","senha","aluno");
        }catch(SQLException e){
            assertFalse(e.getMessage(),true);
            throw new SQLException(e.getMessage());
        }finally{
            conexao.rollback();
        }
    }
    @Test
    public void testDeveriaAlterarUsuarioCadastrado() throws Exception{
        try{
            conexao.setAutoCommit(false);
            Statement stmt = conexao.createStatement();
            stmt.execute("INSERT INTO usuario(cpf,nome,usuario,senha,tipo_usuario) values('111','test','test','1234','aluno')");
            usuarioDAO.alterar("test","4321");
        }catch(SQLException e){
            assertFalse(e.getMessage(),true);
            throw new SQLException(e.getMessage());
        }finally{
            conexao.rollback();
        }
    }
    
    @Test
    public void testDeveriaExcluirUsuarioCadastradoValido() throws Exception{
        try{
            conexao.setAutoCommit(false);
            Statement stmt = conexao.createStatement();
            stmt.execute("INSERT INTO usuario(cpf,nome,usuario,senha,tipo_usuario) values('1111','test','test','1234','aluno')");
            //usuarioDAO.excluir("kenjis");
            usuarioDAO.excluir(1111);
        }catch (SQLException e){
            assertFalse(e.getMessage(),true);
            throw new SQLException(e.getMessage());
        }finally{
            conexao.rollback();
        }
    }
    @Test
    public void testDeveriaRetornarUsuarioCadastrado() throws Exception{
        try{
            conexao.setAutoCommit(false);
            Statement stmt = conexao.createStatement();
            stmt.execute("INSERT INTO usuario(cpf,nome,usuario,senha,tipo_usuario) values('1111','test','test','1234','aluno')");
            assertEquals("test", usuarioDAO.consultar("test"));
        }catch(SQLException e){
            assertFalse(e.getMessage(),true);
            throw new SQLException(e.getMessage());
        }finally{
            conexao.rollback();
        }
    }
    @Test
    public void testDeveriaRetornarTipoDoUsuarioCadastrado() throws Exception{
        try{
            conexao.setAutoCommit(false);
            Statement stmt = conexao.createStatement();
            stmt.execute("INSERT INTO usuario(cpf,nome,usuario,senha,tipo_usuario) values('1111','test','test','1234','aluno')");
            assertEquals("aluno", usuarioDAO.consultarTipoUsuario("test"));
        }catch(SQLException e){
            assertFalse(e.getMessage(),true);
            throw new SQLException(e.getMessage());
        }finally{
            conexao.rollback();
        }
    }
}
