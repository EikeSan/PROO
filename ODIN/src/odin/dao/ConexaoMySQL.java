/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odin.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author eike.santiago
 */
public class ConexaoMySQL implements IConexao {
    static Connection conexao;
    @Override
    public synchronized Connection getConexao(String tipoBanco, String endereco, String nomeBanco, String nomeUsuario, String senha) throws SQLException {
        try {
            if(conexao == null)
                tipoBanco = "jdbc:mysql";
                endereco = "localhost";
                nomeBanco = "odin";
                nomeUsuario = "root";
                senha = "";
                conexao = DriverManager.getConnection(tipoBanco + "://" + endereco + "/" + nomeBanco, nomeUsuario, senha);
                return conexao;
        }catch (SQLException e) {
            throw new SQLException("Erro ao tentar conectar o banco de dados");
        }
    }
}

