/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author Eike
 */
public class DisciplinaDAO {
    Connection conexao;
    public Connection conexaoMySQL() throws SQLException{
       IConexao banco = new ConexaoMySQL();
       conexao = banco.getConexao("jdbc:mysql", "localhost", "odin", "root", "");
       return this.conexao;
    }    
    
    public void inserir(String nome,int cargaHoraria) throws SQLException{
        Statement stmt;
        try{
            stmt = conexaoMySQL().createStatement();
            stmt.execute("INSERT into disciplina(nome_disciplina,carga_horaria) values('"+nome+"','"+cargaHoraria+"')");
        }catch (SQLException e){
            throw new SQLException("Erro ao inserir"+e.getMessage());
        }
    }
    public void alterarCH(int codigo,int novaCargaHoraria) throws SQLException{
        Statement stmt;
        try {
            stmt = conexaoMySQL().createStatement();
            stmt.executeUpdate("UPDATE disciplina SET carga_horaria='"+novaCargaHoraria+"' WHERE codigo_disciplina='"+codigo+"'");
        } catch (SQLException e) {
            throw new SQLException("Erro ao alterar carga horaria da disciplina -"+e.getMessage());
        }
    }
    
    public void excluir(int codigo)throws SQLException{
        Statement stmt;
        try{
            stmt = conexaoMySQL().createStatement();
            stmt.executeUpdate("DELETE FROM disciplina WHERE codigo_disciplina='"+codigo+"'");
        }catch (SQLException e){
            throw  new SQLException("Erro ao excluir disciplina -"+e.getMessage());
        }
    }
    
    public int consultar(String disciplina) throws SQLException{
        ResultSet rs;
        Statement stmt;
        try{
            PreparedStatement pstm = conexaoMySQL().prepareStatement("select codigo_disciplina from disciplina where nome_disciplina='"+disciplina+"'");
            rs = pstm.executeQuery();
            boolean next = rs.next();
            int codigoEncontrado = rs.getInt(1);
            return codigoEncontrado;
        }catch (SQLException e){
            throw new SQLException("Erro ao conslutar disciplina - "+e.getMessage());
        }
    }
}
