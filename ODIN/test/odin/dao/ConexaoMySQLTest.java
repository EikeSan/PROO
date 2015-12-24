/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odin.dao;

import java.sql.Connection;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author eike.santiago
 */
public class ConexaoMySQLTest {
    
     @Test
    public void testDeveriaConectarDadosInformadosCorretamente() throws Exception {
        IConexao banco = new ConexaoMySQL();

        assertNotNull(banco.getConexao("jdbc:mysql", "localhost", "odin", "root", ""));
    }
        @Test
    public void testNaoDeveriaConectarSeDadosInformadosErrados() throws Exception {
        IConexao banco = new ConexaoMySQL();
        Connection conexao = null;
        try {
            conexao = banco.getConexao("jdbc:mysql", "localhost", "odin", "senha", "senha");
        } catch (SQLException e) {
            assertNull(conexao);
        }
    }
}

