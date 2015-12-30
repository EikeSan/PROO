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
    
    public String checarDados(String usuario,String senha) throws SQLException{
        ResultSet rs;
        Statement stmt;
        try{
            PreparedStatement pstm = conexaoMySQL().prepareStatement("select * from usuario where cast(usuario as binary) ='"+usuario+"' and cast(senha as binary) = '"+senha+"'");
            rs = pstm.executeQuery();
            boolean next = rs.next();
            String nomeConsultado = rs.getString("nome");
            return nomeConsultado;
        }catch (SQLException e){
            throw new SQLDataException("Erro ao checar dados!: "+e.getMessage());
        }
    }
    
}