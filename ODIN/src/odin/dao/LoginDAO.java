package odin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDAO {
    // Obs:  implementar método abaixo para ser utilizado por todas as classes.
    public Connection conexaoMySQL() throws SQLException{
       IConexao banco = new ConexaoMySQL();
       Connection conexao = null;
       conexao = banco.getConexao("jdbc:mysql", "localhost", "odin", "root", "");
       return conexao;
    }
    
    public boolean isDadosValidos(String usuario,String senha) throws SQLException{
        ResultSet rs;
        Statement stmt;
        boolean isValido = false;
        try{
            PreparedStatement pstm = conexaoMySQL().prepareStatement("select * from usuario where cast(usuario as binary) ='"+usuario+"' and cast(senha as binary) = '"+senha+"'");
            rs = pstm.executeQuery();
            boolean next = rs.next();
            rs.getString("nome");
            isValido = true;
            return isValido;
        }catch (SQLException e){
            throw new SQLException("Erro ao checar dados!: "+e.getMessage());
        }
    }
    
}