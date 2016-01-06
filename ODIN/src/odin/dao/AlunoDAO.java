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
import java.util.ArrayList;
import odin.model.*;
/**
 *
 * @author Eike
 */
public class AlunoDAO {
    Connection conexao;

    public AlunoDAO() {

    }

    public Connection conexaoMySQL() throws SQLException {
        IConexao banco = new ConexaoMySQL();
        conexao = banco.getConexao("jdbc:mysql", "localhost", "odin", "root", "");
        return this.conexao;
    }
    
    public ArrayList<Aluno> listarAlunosPorDisciplina(int codigoTurma) throws SQLException{
        ResultSet rs;
        PreparedStatement pstm;
        ArrayList<Aluno> listaAlunos = new ArrayList<>();
        
        try {
            pstm = conexaoMySQL().prepareStatement("SELECT ap.codigo_aluno,u.nome, ap.nota_1, ap.nota_2,ap.nota_final, ap.faltas FROM aluno_por_turma ap inner join aluno a on a.codigo_aluno = ap.codigo_aluno inner JOIN usuario u on u.cpf = a.cpf where ap.codigo_turma =  " + codigoTurma);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Aluno aluno = new Aluno();
                aluno.setCodigoUsuario(Integer.parseInt(rs.getString("codigo_aluno")));
                aluno.setNomeUsuario(rs.getString("nome"));
                aluno.setNota1(Integer.parseInt(rs.getString("nota_1")));
                aluno.setNota2(Integer.parseInt(rs.getString("nota_2")));
                aluno.setNotaFinal(Integer.parseInt(rs.getString("nota_final")));
                aluno.setFaltas(Integer.parseInt(rs.getString("faltas")));
                listaAlunos.add(aluno);
            }
            return listaAlunos;
            
        } catch (SQLException e) {
            throw new SQLException("Erro ao criar lista de alunos - "+e.getMessage());
        }
    }
}
