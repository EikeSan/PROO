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
 * @author eike.santiago
 */
public class UsuarioDAO {

    Connection conexao;

    public UsuarioDAO() {

    }

    public Connection conexaoMySQL() throws SQLException {
        IConexao banco = new ConexaoMySQL();
        conexao = banco.getConexao("jdbc:mysql", "localhost", "odin", "root", "");
        return this.conexao;
    }

    public void inserir(String cpfUsuario, String nomeUsuario, String nomeLogin, String senhaUsuario, String tipoUsuario) throws SQLException {
        Statement stmt;
        try {
            stmt = conexaoMySQL().createStatement();
            stmt.execute("INSERT into usuario(cpf,nome,usuario,senha,tipo_usuario) values('" + cpfUsuario + "','" + nomeUsuario + "','" + nomeLogin + "','" + senhaUsuario + "','" + tipoUsuario + "')");
        } catch (SQLException e) {
            throw new SQLException("Erro ao inserir" + e.getMessage());
        }
    }

    public void alterar(String cpfUsuario, String novoLogin, String novoNome, String novaSenha) throws SQLException {
        Statement stmt;
        try {
            stmt = conexaoMySQL().createStatement();
            if (isCpfExiste(cpfUsuario) == true) {
                stmt.executeUpdate("UPDATE usuario SET senha='" + novaSenha + "',usuario='" + novoLogin + "', nome='" + novoNome + "' WHERE cpf='" + cpfUsuario + "'");
            }
        } catch (SQLException e) {
            throw new SQLException("Erro ao alterar usuário -" + e.getMessage());
        }
    }

    public void excluir(String cpfUsuario) throws SQLException {
        Statement stmt;
        try {
            stmt = conexaoMySQL().createStatement();
            stmt.executeUpdate("DELETE FROM usuario WHERE cpf='" + cpfUsuario + "'");
        } catch (SQLException e) {
            throw new SQLException("Erro ao excluir usuário -" + e.getMessage());
        }
    }

    public String consultar(String usuarioConsultado) throws SQLException {
        ResultSet rs;
        Statement stmt;
        try {
            PreparedStatement pstm = conexaoMySQL().prepareStatement("select cpf from usuario where usuario ='" + usuarioConsultado + "'");
            rs = pstm.executeQuery();
            boolean next = rs.next();
            String usuarioEncontrado = rs.getString(1);
            return usuarioEncontrado;
        } catch (SQLException e) {
            throw new SQLException("Erro ao conslutar usuario - " + e.getMessage());
        }
    }

    public boolean isCpfExiste(String cpf) throws SQLException {
        ResultSet rs;
        Statement stmt;
        try {
            PreparedStatement pstm = conexaoMySQL().prepareStatement("select usuario from usuario where cpf ='" + cpf + "'");
            rs = pstm.executeQuery();
            boolean next = rs.next();
            String cpfEncontrado = rs.getString(1);
            return true;
        } catch (Exception e) {
            throw new SQLException("CPF não existe!" + e.getMessage());
        }
    }

    public String consultarTipoUsuario(String loginUsuario) throws SQLException {
        ResultSet rs;
        Statement stmt;
        try {
            PreparedStatement pstm = conexaoMySQL().prepareStatement("Select * from usuario where usuario= '" + loginUsuario + "'");
            rs = pstm.executeQuery();
            boolean next = rs.next();
            String tipoEncontrado = rs.getString(5);
            return tipoEncontrado;
        } catch (SQLException e) {
            throw new SQLException("Erro ao conslutar o tipo de usuario - " + e.getMessage());
        }
    }

    public void vincularProfessorPorTurma(int codigo_disciplina, int codigo_professor, int codigo_turma) {
        Statement stmt;
        try {
            stmt = conexaoMySQL().createStatement();
            stmt.execute("insert into disciplina_por_professor(codigo_disciplina,codigo_professor,codigo_turma) values('" + codigo_disciplina + "','" + codigo_professor + "','" + codigo_turma + "')");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao vincular professor:  " + e.getMessage());
        }
    }

    public void alterarTurma(int codigoTurma, String nomeTurma) {
        Statement stmt;
        try {
            stmt = conexaoMySQL().createStatement();
            stmt.execute("update turma set nome_turma = '" + nomeTurma + "'" + "where codigo_turma ='" + codigoTurma + "'");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar turma " + e.getMessage());
        }
    }

    public void alterarProfessorPorTurma(int codigoProfessor, int codigoDisciplina, int codigoTurma) {
        Statement stmt;
        try {
            stmt = conexaoMySQL().createStatement();
            stmt.execute("UPDATE disciplina_por_professor set codigo_professor = '" + codigoProfessor + "', codigo_disciplina ='" + codigoDisciplina + "' where codigo_turma = '" + codigoTurma + "'");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar turma " + e.getMessage());
        }
    }

    public void excluirTurma(int codigoTurma) {
        Statement stmt;
        try {
            stmt = conexaoMySQL().createStatement();
            stmt.execute("delete from turma where codigo_turma = '" + codigoTurma + "'");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir turma:  " + e.getMessage());
        }
    }

    public void inserirNovaTurma(String nomeTurma) {
        Statement stmt;
        try {
            stmt = conexaoMySQL().createStatement();
            stmt.execute("insert into turma(nome_turma) values('" + nomeTurma + "')");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir nova turma " + e.getMessage());
        }
    }

    public int retornarUltimoCodigoTurma() {
        ResultSet rs;
        PreparedStatement pstm;
        int codigo = 0;
        try {
            pstm = conexaoMySQL().prepareStatement("select * from turma order by codigo_turma desc limit 1");
            rs = pstm.executeQuery();
            while (rs.next()) {
                if (!rs.getString("codigo_turma").isEmpty()) {
                    codigo = Integer.parseInt(rs.getString("codigo_turma"));
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao retornar ultimo valor " + e.getMessage());
        }
        return codigo;
    }

    public ArrayList<Professor> listarProfessoresVinculadosPorDisciplina(int codigoDisciplina) throws SQLException {
        ResultSet rs;
        PreparedStatement pstm;
        ArrayList<Professor> listaProfessores = new ArrayList<>();
        try {
            pstm = conexaoMySQL().prepareStatement("SELECT * FROM disciplina_por_professor inner join professor on professor.codigo_professor = disciplina_por_professor.codigo_professor inner JOIN usuario on usuario.cpf = professor.cpf where disciplina_por_professor.codigo_disciplina = " + codigoDisciplina);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Professor professor = new Professor();
                professor.setCodigoProfessor(Integer.parseInt(rs.getString("codigo_professor")));
                professor.setCPFUsuario(rs.getString("cpf"));
                professor.setLoginUsuario(rs.getString("usuario"));
                professor.setNomeUsuario(rs.getString("nome"));
                professor.setSenhaUsuario(rs.getString("senha"));
                professor.setTipoUsuario(rs.getString("tipo_usuario"));
                listaProfessores.add(professor);
            }
            return listaProfessores;
        } catch (SQLException e) {
            throw new SQLException("Erro listar professores - " + e.getMessage());
        }
    }

    public ArrayList<Turma> listarTurmas() throws SQLException {
        ResultSet rs;
        PreparedStatement pstm;
        ArrayList<Turma> listaTurmas = new ArrayList();
        try {
            pstm = conexaoMySQL().prepareStatement("select dpp.codigo_turma,t.nome_turma,dpp.codigo_disciplina,d.nome_disciplina,dpp.codigo_professor,u.nome \n"
                    + "from disciplina_por_professor as dpp \n"
                    + "inner join turma as t on t.codigo_turma = dpp.codigo_turma \n"
                    + "INNER join disciplina as d on d.codigo_disciplina = dpp.codigo_disciplina \n"
                    + "inner join professor as p on p.codigo_professor = dpp.codigo_professor \n"
                    + "inner join usuario as u on u.cpf = p.cpf");
            rs = pstm.executeQuery();
            while (rs.next()) {
                Turma turma = new Turma();
                turma.setCodigoDisciplina(Integer.parseInt(rs.getString("codigo_disciplina")));
                turma.setCodigoProfessor(Integer.parseInt(rs.getString("codigo_professor")));
                turma.setCodigoTurma(Integer.parseInt(rs.getString("codigo_turma")));
                turma.setNomeDisciplina(rs.getString("nome_disciplina"));
                turma.setNomeProfessor(rs.getString("nome"));
                turma.setNomeTurma(rs.getString("nome_turma"));
                listaTurmas.add(turma);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar turmas" + e.getMessage());
        }
        return listaTurmas;
    }

    public ArrayList<Professor> listarProfessoresVinculados() throws SQLException {
        ResultSet rs;
        PreparedStatement pstm;
        ArrayList<Professor> listaProfessores = new ArrayList<>();
        try {
            pstm = conexaoMySQL().prepareStatement("SELECT * FROM disciplina_por_professor \n"
                    + "inner join professor on professor.codigo_professor = disciplina_por_professor.codigo_professor\n"
                    + "inner JOIN usuario on usuario.cpf = professor.cpf");
            rs = pstm.executeQuery();
            while (rs.next()) {
                Professor professor = new Professor();
                professor.setCodigoProfessor(Integer.parseInt(rs.getString("codigo_professor")));
                professor.setCPFUsuario(rs.getString("cpf"));
                professor.setLoginUsuario(rs.getString("usuario"));
                professor.setNomeUsuario(rs.getString("nome"));
                professor.setSenhaUsuario(rs.getString("senha"));
                professor.setTipoUsuario(rs.getString("tipo_usuario"));
                listaProfessores.add(professor);
            }
            return listaProfessores;
        } catch (SQLException e) {
            throw new SQLException("Erro listar professores - " + e.getMessage());
        }
    }

   

    public ArrayList<Professor> listarProfessores() throws SQLException {
        ResultSet rs;
        PreparedStatement pstm;
        ArrayList<Professor> listaProfessores = new ArrayList<>();
        try {
            pstm = conexaoMySQL().prepareStatement("SELECT * FROM professor inner JOIN usuario on usuario.cpf = professor.cpf");
            rs = pstm.executeQuery();
            while (rs.next()) {
                Professor professor = new Professor();
                professor.setCodigoProfessor(Integer.parseInt(rs.getString("codigo_professor")));
                professor.setCPFUsuario(rs.getString("cpf"));
                professor.setLoginUsuario(rs.getString("usuario"));
                professor.setNomeUsuario(rs.getString("nome"));
                professor.setSenhaUsuario(rs.getString("senha"));
                professor.setTipoUsuario(rs.getString("tipo_usuario"));
                listaProfessores.add(professor);
            }
            return listaProfessores;
        } catch (SQLException e) {
            throw new SQLException("Erro listar professores - " + e.getMessage());
        }
    }

    public ArrayList<Usuario> listarUsuarios() throws SQLException {
        ResultSet rs;
        PreparedStatement pstm;
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();

        try {
            pstm = conexaoMySQL().prepareStatement("select cpf,usuario, nome, senha, tipo_usuario from usuario");
            rs = pstm.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setCPFUsuario(rs.getString("cpf"));
                usuario.setLoginUsuario(rs.getString("usuario"));
                usuario.setNomeUsuario(rs.getString("nome"));
                usuario.setSenhaUsuario(rs.getString("senha"));
                usuario.setTipoUsuario(rs.getString("tipo_usuario"));
                listaUsuarios.add(usuario);
            }

            return listaUsuarios;
        } catch (SQLException e) {
            throw new SQLException("Erro listar usuários - " + e.getMessage());
        }
    }

    public ArrayList<Turma> listarTurmaPorProfessor(String cpfProfessor) throws SQLException {
        ResultSet rs;
        PreparedStatement pstm;
        ArrayList<Turma> listaTurmas = new ArrayList<>();

        try {
            pstm = conexaoMySQL().prepareStatement("SELECT dp.codigo_disciplina, dp.codigo_professor, dp.codigo_turma,d.nome_disciplina,u.nome, t.nome_turma FROM disciplina_por_professor dp inner join professor p on p.codigo_professor = dp.codigo_professor inner JOIN usuario u on u.cpf = p.cpf inner JOIN turma t on t.codigo_turma = dp.codigo_turma inner join disciplina d on d.codigo_disciplina = dp.codigo_disciplina where p.cpf = " + cpfProfessor);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Turma turma = new Turma();
                turma.setCodigoDisciplina(Integer.parseInt(rs.getString("codigo_disciplina")));
                turma.setCodigoProfessor(Integer.parseInt(rs.getString("codigo_professor")));
                turma.setCodigoTurma(Integer.parseInt(rs.getString("codigo_turma")));
                turma.setNomeDisciplina(rs.getString("nome_disciplina"));
                turma.setNomeProfessor(rs.getString("nome"));
                turma.setNomeTurma(rs.getString("nome_turma"));
                listaTurmas.add(turma);
            }
            return listaTurmas;

        } catch (SQLException e) {
            throw new SQLException("Erro ao criar lista de alunos - " + e.getMessage());
        }
    }
}
