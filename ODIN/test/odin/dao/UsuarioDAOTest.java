/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odin.dao;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import junit.framework.TestCase;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import static junit.framework.Assert.assertFalse;
import odin.dao.ConexaoMySQL;
import odin.dao.UsuarioDAO;
import odin.dao.IConexao;
import odin.model.*;

/**
 *
 * @author eike.santiago
 */
public class UsuarioDAOTest extends TestCase {

    IConexao banco = new ConexaoMySQL();
    Connection conexao = null;
    UsuarioDAO usuarioDAO;

    @Override
    protected void setUp() throws Exception {
        conexao = banco.getConexao("jdbc:mysql", "localhost", "odin", "root", "");
        usuarioDAO = new UsuarioDAO();
        super.setUp();
    }

    @Test
    public void testDeveriaInserirUsuario() throws Exception {
        try {
            conexao.setAutoCommit(false);
            usuarioDAO.inserir("1234", "test", "test", "senha", "aluno");
        } catch (SQLException e) {
            assertFalse(e.getMessage(), true);
            throw new SQLException(e.getMessage());
        } finally {
            conexao.rollback();
        }
    }
    
   

    @Test
    public void testDeveriaAlterarUsuarioCadastrado() throws Exception {
        try {
            conexao.setAutoCommit(false);
            Statement stmt = conexao.createStatement();
            stmt.execute("INSERT INTO usuario(cpf,nome,usuario,senha,tipo_usuario) values('1111','test','test','1234','aluno')");
            usuarioDAO.alterar("1111", "test","TesteAlterado","3211");
        } catch (SQLException e) {
            assertFalse(e.getMessage(), true);
            throw new SQLException(e.getMessage());
        } finally {
            conexao.rollback();
        }
    }

    @Test
    public void testDeveriaExcluirUsuarioCadastradoValido() throws Exception {
        try {
            conexao.setAutoCommit(false);
            Statement stmt = conexao.createStatement();
            stmt.execute("INSERT INTO usuario(cpf,nome,usuario,senha,tipo_usuario) values('1111','test','test','1234','aluno')");
            usuarioDAO.excluir("1111");
        } catch (SQLException e) {
            assertFalse(e.getMessage(), true);
            throw new SQLException(e.getMessage());
        } finally {
            conexao.rollback();
        }
    }
    @Test 
    public void testDeveriaVincularProfessorTurma()throws Exception{
        try{
            conexao.setAutoCommit(false);
            Statement stmt = conexao.createStatement();
            stmt.execute("INSERT INTO usuario(cpf,nome,usuario,senha,tipo_usuario) values('1111','Paulo Guina','Ronilda','1234','Professor')");
            stmt.execute("insert into disciplina(codigo_disciplina,nome_disciplina,carga_horaria) values('1','Química','80')");
            stmt.execute("insert into turma(codigo_turma,nome_turma) values ('1','PROO') ");
            stmt.execute("UPDATE professor SET codigo_professor = 1 WHERE cpf = '1111'");
            usuarioDAO.vincularProfessorPorTurma(1, 1,1);
        }catch (SQLException e){
            assertFalse(e.getMessage(), true);
            throw new SQLException(e.getMessage());
        }finally {
            conexao.rollback();
        }
    }
    @Test 
    public void testDeveriaExcluirTurma()throws SQLException{
        try{
            conexao.setAutoCommit(false);
            Statement stmt = conexao.createStatement();
            stmt.execute("insert into turma(codigo_turma,nome_turma) values('1','PROO')");
            usuarioDAO.excluirTurma(1);
        }catch (SQLException e){
            assertFalse(e.getMessage(), true);
            throw new SQLException(e.getMessage());
        }finally {
            conexao.rollback();
        }
    }
    @Test 
    public void testDeveriaAlterarProfessorPorTurma() throws SQLException{
        try{
            conexao.setAutoCommit(false);
            Statement stmt = conexao.createStatement();
            stmt.execute("INSERT INTO usuario(cpf,nome,usuario,senha,tipo_usuario) values('1111','Paulo Guina','Ronilda','1234','Professor')");
            stmt.execute("INSERT INTO usuario(cpf,nome,usuario,senha,tipo_usuario) values('11111','Paulo','paulo123','1234','Professor')");
            stmt.execute("insert into disciplina(codigo_disciplina,nome_disciplina,carga_horaria) values('1','Química','80')");
            stmt.execute("insert into disciplina(codigo_disciplina,nome_disciplina,carga_horaria) values('2','PROO','80')");
            stmt.execute("insert into turma(codigo_turma,nome_turma) values ('1','PROO') ");
            stmt.execute("UPDATE professor SET codigo_professor = '1' WHERE cpf = '1111'");
            stmt.execute("UPDATE professor SET codigo_professor = '2' WHERE cpf = '11111'");
            stmt.execute("insert into disciplina_por_professor(codigo_disciplina,codigo_professor,codigo_turma) values('1','1','1')");
            usuarioDAO.alterarProfessorPorTurma(2, 2, 1);
        }catch(SQLException e){
           assertFalse(e.getMessage(), true);
            throw new SQLException(e.getMessage());
        }finally {
            conexao.rollback();
        }
    }
    @Test
    public void testDeveriaAlterarTurma()throws Exception{
        try{
            conexao.setAutoCommit(false);
            Statement stmt = conexao.createStatement();
            stmt.execute("insert into turma(codigo_turma,nome_turma) values ('1','PROO') ");
            usuarioDAO.alterarTurma(1,"Proo");
        }catch (SQLException e){
            assertFalse(e.getMessage(), true);
            throw new SQLException(e.getMessage());
        }finally{
            conexao.rollback();
        }
    }
    /*@Test public void testDeveriaDesvincularProfessor()throws Exception{
        try{
            conexao.setAutoCommit(false);
            Statement stmt = conexao.createStatement();
            stmt.execute("INSERT INTO usuario(cpf,nome,usuario,senha,tipo_usuario) values('1111','Paulo Guina','Ronilda','1234','Professor')");
            stmt.execute("insert into disciplina(codigo_disciplina,nome_disciplina,carga_horaria) values('1','Química','80')");
            stmt.execute("UPDATE professor SET codigo_professor = 1 WHERE cpf = '1111'");
            usuarioDAO.desvincularProfessor(1, 1);
        
        }catch (SQLException e){
            assertFalse(e.getMessage(), true);
            throw new SQLException(e.getMessage());
        }finally {
            conexao.rollback();
        }
    }*/

    /*@Test
        public void testDeveriaRetornarUltimoCodigoTurma() throws Exception{
        try{
           
        }catch(SQLException e){
            
        }finally{
            conexao.rollback();
        }
    }*/
    @Test
    public void testDeveriaRetornarUsuarioCadastrado() throws Exception {
        try {
            conexao.setAutoCommit(false);
            Statement stmt = conexao.createStatement();
            stmt.execute("INSERT INTO usuario(cpf,nome,usuario,senha,tipo_usuario) values('1111','test','test','1234','aluno')");
            assertEquals("test", usuarioDAO.consultar("test"));
        } catch (SQLException e) {
            assertFalse(e.getMessage(), true);
            throw new SQLException(e.getMessage());
        } finally {
            conexao.rollback();
        }
    }

    @Test
    public void testDeveriaRetornarTipoDoUsuarioCadastrado() throws Exception {
        try {
            conexao.setAutoCommit(false);
            Statement stmt = conexao.createStatement();
            stmt.execute("INSERT INTO usuario(cpf,nome,usuario,senha,tipo_usuario) values('1111','test','test','1234','aluno')");
            assertEquals("aluno", usuarioDAO.consultarTipoUsuario("test"));
        } catch (SQLException e) {
            assertFalse(e.getMessage(), true);
            throw new SQLException(e.getMessage());
        } finally {
            conexao.rollback();
        }
    }

    @Test
    public void testDeveriaRetornarOsDadosDosUsuariosCadastrados() throws Exception {
        try {
            conexao.setAutoCommit(false);
            Statement stmt = conexao.createStatement();
            stmt.execute("INSERT INTO usuario(cpf,nome,usuario,senha,tipo_usuario) values('1111','test','test','1234','aluno')");
            stmt.execute("INSERT INTO usuario(cpf,nome,usuario,senha,tipo_usuario) values('2222','test2','test2','1234','aluno')");

            ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();

            listaUsuarios = usuarioDAO.listarUsuarios();

            for (int i = 0; i < listaUsuarios.size(); i++) {
                System.out.println(listaUsuarios.get(i).getLoginUsuario());
            }

        } catch (SQLException e) {
            assertFalse(e.getMessage(), true);
        }finally{
            conexao.rollback();
        }
    }
    @Test
    public void testDeveriaRetornarTrueSeCpfExistir()throws Exception{
        try {
            conexao.setAutoCommit(false);
            Statement stmt = conexao.createStatement();
            stmt.execute("INSERT INTO usuario(cpf,nome,usuario,senha,tipo_usuario) values('1111','test','test','1234','aluno')");
            assertTrue(usuarioDAO.isCpfExiste("1111"));
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        } finally {
            conexao.rollback();
        }
    }
}
