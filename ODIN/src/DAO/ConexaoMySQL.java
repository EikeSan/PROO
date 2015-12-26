package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLDataException;
import java.sql.SQLException;

/**
 *
 * @author Francisco
 */
public class ConexaoMySQL implements IConexao {

    public Connection getConexao(String tipoBanco, String endereco, String nomeBanco, String nomeUsuario, String senha) throws SQLException {
        try{
            Connection conexao = DriverManager.getConnection(tipoBanco + "://" + endereco + "/" + nomeBanco, nomeUsuario, senha);
            return conexao;
        }catch(SQLException e){
            throw new SQLDataException("Erro ao tentar conectar ao banco");
        }
    }
}
