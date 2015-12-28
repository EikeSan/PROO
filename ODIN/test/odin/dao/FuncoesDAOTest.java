/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odin.dao;

import java.sql.Connection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import junit.framework.TestCase;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLDataException;
import java.sql.SQLException;
import odin.dao.ConexaoMySQL;
import odin.dao.FuncoesDAO;
import odin.dao.IConexao;

/**
 *
 * @author eike.santiago
 */
public class FuncoesDAOTest extends TestCase {
    IConexao banco = new ConexaoMySQL();
    Connection conexao = null;
    FuncoesDAO funcoesDAO;
    
    @Override
    protected void setUp() throws Exception {
        conexao = banco.getConexao("jdbc:mysql", "localhost", "poo", "root", "");
        funcoesDAO = new FuncoesDAO(conexao);
        super.setUp();
    }
    
    @Test
    public void testDeveriaInserirUsuario() throws Exception {    
        try{
            conexao.setAutoCommit(false);
            funcoesDAO.inserir("test", "test");
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
            stmt.execute("INSERT INTO LOGIN(usuario,senha) values('kenji','1234')");
            
            funcoesDAO.alterar("kenji","4321");
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
            stmt.executeUpdate("INSERT INTO LOGIN(usuario,senha) values('kenji','1234')");
            funcoesDAO.excluir("kenjis");
            funcoesDAO.excluir("kenji");
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
            stmt.executeUpdate("INSERT INTO LOGIN(usuario,senha) values('kenji','1234')");
            funcoesDAO.excluir("kenjis");
            assertEquals("kenji", funcoesDAO.consultar("kenji"));
        }catch(SQLException e){
            assertFalse(e.getMessage(),true);
            throw new SQLException(e.getMessage());
        }finally{
            conexao.rollback();
        }
    }
}
