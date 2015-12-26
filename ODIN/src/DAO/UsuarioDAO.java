package DAO;

/**
 *
 * @author Francisco
 */
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UsuarioDAO {

    Connection conexao;

    public UsuarioDAO() {
    }

    public UsuarioDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void inserir(String nomeUsuario, String senha) throws Exception {
        Statement stmt;
        try {
            stmt = this.conexao.createStatement();
            stmt.executeUpdate("insert into login(usuario,senha) values('" + nomeUsuario + "','" + senha + "')");
        } catch (SQLException e) {
            throw new SQLException("Erro ao inserir usuário" + e.getMessage());
        }
    }
}
