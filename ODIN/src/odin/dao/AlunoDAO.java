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
import java.util.ArrayList;
import javax.swing.JOptionPane;
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

    public ArrayList<Aluno> listarAlunos() throws SQLException {
        ResultSet rs;
        PreparedStatement pstm;
        ArrayList<Aluno> listaAlunos = new ArrayList<>();
        try {
            pstm = conexaoMySQL().prepareStatement("Select * from usuario u inner join aluno a on a.cpf = u.cpf");
            rs = pstm.executeQuery();
            while (rs.next()) {
                Aluno aluno = new Aluno();
                aluno.setCodigo_aluno(Integer.parseInt(rs.getString("codigo_aluno")));
                aluno.setCPFUsuario(rs.getString("cpf"));
                aluno.setNomeUsuario(rs.getString("nome"));
                listaAlunos.add(aluno);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar alunos: " + e.getMessage());
        }
        return listaAlunos;
    }

    public ArrayList<Aluno> listarAlunosPorDisciplina(int codigoTurma) throws SQLException {
        ResultSet rs;
        PreparedStatement pstm;
        ArrayList<Aluno> listaAlunos = new ArrayList<>();

        try {
            pstm = conexaoMySQL().prepareStatement("SELECT ap.codigo_aluno,u.nome, ap.nota_1, ap.nota_2,ap.nota_final, ap.faltas FROM aluno_por_turma ap inner join aluno a on a.codigo_aluno = ap.codigo_aluno inner JOIN usuario u on u.cpf = a.cpf where ap.codigo_turma =  " + codigoTurma + " order by u.nome");
            rs = pstm.executeQuery();
            while (rs.next()) {
                Aluno aluno = new Aluno();
                aluno.setCodigo_aluno(Integer.parseInt(rs.getString("codigo_aluno")));
                aluno.setNomeUsuario(rs.getString("nome"));
                aluno.setNota1(Double.parseDouble(rs.getString("nota_1")));
                aluno.setNota2(Double.parseDouble(rs.getString("nota_2")));
                aluno.setNotaFinal(Double.parseDouble(rs.getString("nota_final")));
                aluno.setFaltas(Integer.parseInt(rs.getString("faltas")));
                listaAlunos.add(aluno);
            }
            return listaAlunos;

        } catch (SQLException e) {
            throw new SQLException("Erro ao criar lista de alunos - " + e.getMessage());
        }
    }
    public void vincularAlunoPorTurma(int codigo_turma,int codigo_aluno) {
        Statement stmt;
        try {
            stmt = conexaoMySQL().createStatement();
            stmt.execute("insert into aluno_por_turma(codigo_turma,codigo_aluno) values('" + codigo_turma + "','" + codigo_aluno+"')");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao vincular aluno:  " + e.getMessage());
        }
    }
    public void desvincularAluno(int codigoAluno, int codigoTurma) throws SQLException {
        Statement stmt;
        try {
            stmt = conexaoMySQL().createStatement();
            stmt.executeUpdate("DELETE FROM aluno_por_turma WHERE codigo_aluno = " + codigoAluno + " and codigo_turma = " + codigoTurma);
        } catch (SQLException e) {
            throw new SQLException("Erro ao desvincular aluno -" + e.getMessage());
        }
    }
     public void editarNotas(int codUsuario, double nota1, double nota2,double notaFinal,int faltas) throws SQLException {
        Statement stmt;
        try {
            stmt = conexaoMySQL().createStatement();
            if (isCodigoAlunoExiste(codUsuario) == true) {
                stmt.executeUpdate("UPDATE aluno_por_turma SET nota_1='" + nota1 + "',nota_2='" + nota2 + "',nota_final='" + notaFinal + "', faltas='" + faltas + "' WHERE codigo_aluno='" + codUsuario + "'");
            }
        } catch (SQLException e) {
            throw new SQLException("Erro ao editar notas e/ou faltas -" + e.getMessage());
        }
    }
    
    public boolean isCodigoAlunoExiste(int codigoAluno) throws SQLException {
        ResultSet rs;
        Statement stmt;
        try {
            PreparedStatement pstm = conexaoMySQL().prepareStatement("select cpf from aluno where codigo_aluno ='" + codigoAluno + "'");
            rs = pstm.executeQuery();
            boolean next = rs.next();
            String cpfEncontrado = rs.getString(1);
            return true;
        } catch (Exception e) {
            throw new SQLException("Codigo não existe!" + e.getMessage());
        }
    }
}
