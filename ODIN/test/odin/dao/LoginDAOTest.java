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
import odin.dao.IConexao;

/**
 *
 * @author eike.santiago
 */
public class LoginDAOTest extends TestCase {
    IConexao banco = new ConexaoMySQL();
    Connection conexao = null;
 
    @Override
    protected void setUp() throws Exception {
        conexao = banco.getConexao("jdbc:mysql", "localhost", "odin", "root", "");
        super.setUp();
    }
       
    @Test
    public void testDeveriaLogarSeDadosInformadosCorretamente() throws Exception {
        try {
            conexao.setAutoCommit(false);
            Statement stmt = conexao.createStatement();
            stmt.execute("INSERT INTO usuario(cpf,usuario,nome,senha,tipo_usuario) values('1234','test','test','1234','aluno')");
            LoginDAO login = new LoginDAO();
            login.checarDados("test", "1234");
        } catch (SQLException e) {
            assertFalse(e.getMessage(), true);
            throw new SQLException(e.getMessage());
        }finally{
            conexao.rollback();
        }
    }

}
