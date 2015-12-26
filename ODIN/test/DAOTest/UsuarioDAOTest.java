package DAOTest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.sql.DriverManager;
import junit.framework.TestCase;
import java.sql.Connection;
import DAO.*;
import java.sql.SQLException;

/**
 *
 * @author Francisco
 */
public class UsuarioDAOTest extends TestCase {

    IConexao banco = new ConexaoMySQL();
    Connection conexao = null;
    UsuarioDAO usuarioDAO;

    @Override
    protected void setUp() throws Exception {
        conexao = banco.getConexao("jdbc:mysql", "localhost", "poo", "root", "");
        usuarioDAO = new UsuarioDAO(conexao);
        super.setUp();
    }

    @Test
    public void testeDeveriaInserirUsuario() throws Exception {
        try {
            conexao.setAutoCommit(false);
            usuarioDAO.inserir("teste", "teste");
        } catch (SQLException e) {
            assertFalse(e.getMessage(), true);
            throw new SQLException(e.getMessage());
        } finally {
            conexao.rollback();
        }
    }
}
