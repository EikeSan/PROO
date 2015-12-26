package DAOTest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import junit.framework.TestCase;
import DAO.*;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Francisco
 */
public class ConexaoMySQLTest {

    @Test
    public void testDeveriaConectarDadosInformadosCorretamente() throws Exception {
        IConexao banco = new ConexaoMySQL();
        assertNotNull(banco.getConexao("jdbc:mysql", "localhost", "poo", "root", ""));
    }

    @Test
    public void testNaoDeveriaConectarSeDadosInformadosErrados() throws Exception {
        IConexao banco = new ConexaoMySQL();
        Connection conexao = null;
        try {
            conexao = banco.getConexao("jbdc:mysql", "localhost", "poo", "root", "senhaerrada");
        } catch (SQLException e) {
            assertNull(conexao);
        }
    }
}
