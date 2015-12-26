package DAO;

import java.sql.Connection;
import java.sql.SQLException;

public interface IConexao {

    Connection getConexao(String tipoBanco, String endereco,String nomeBanco, String nomeUsuario, String senha) throws SQLException;
}
