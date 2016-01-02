/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odin.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import junit.framework.TestCase;
/**
 *
 * @author Eike
 */
public class DisciplinaDAOTest extends TestCase{
    IConexao banco = new ConexaoMySQL();
    Connection conexao = null;
    DisciplinaDAO disciplina;
    @Override
    protected void setUp() throws Exception {
        conexao = banco.getConexao("jdbc:mysql", "localhost", "odin", "root", "");
        disciplina = new DisciplinaDAO();
        super.setUp();
    }
    
    @Test
    public void testDeveriaInserirDisciplinaSeDadosValidos() throws Exception{
        try {
            conexao.setAutoCommit(false);
            disciplina.inserir("PROO",40);
        } catch (Exception e) {
            assertFalse(e.getMessage(),true);
            throw new SQLException(e.getMessage());
        }finally{
            conexao.rollback();
        }
    }
     @Test
    public void testDeveriaRetornarCodigoDaDisciplinaCadastrada() throws Exception{
        try{
            conexao.setAutoCommit(false);
            Statement stmt = conexao.createStatement();
            stmt.execute("INSERT INTO disciplina(nome_disciplina,carga_horaria) values('PROO','40')");
            int consultar = disciplina.consultar("PROO");
            assertNotNull(consultar);
        }catch(SQLException e){
            throw new SQLException(e.getMessage());
        }finally{
            conexao.rollback();
        }
    }
    @Test
    public void testDeveriaAlterarCargaHorariaDaDisciplinaCadastrada() throws Exception{
        try{
            conexao.setAutoCommit(false);
            Statement stmt = conexao.createStatement();
            stmt.execute("INSERT INTO disciplina(nome_disciplina,carga_horaria) values('PROO','40')");
            int codigo = disciplina.consultar("PROO");
            disciplina.alterarCH(codigo, 80);
        }catch(SQLException e){
            assertFalse(e.getMessage(),true);
            throw new SQLException(e.getMessage());
        }finally{
            conexao.rollback();
        }
    }
    
    @Test
    public void testDeveriaExcluirDisciplinaCadastradaValida() throws Exception{
        try{
            conexao.setAutoCommit(false);
            Statement stmt = conexao.createStatement();
            stmt.execute("INSERT INTO disciplina(nome_disciplina,carga_horaria) values('PROO','40')");
            int codigo = disciplina.consultar("PROO");
            disciplina.excluir(codigo);
        }catch (SQLException e){
            assertFalse(e.getMessage(),true);
            throw new SQLException(e.getMessage());
        }finally{
            conexao.rollback();
        }
    }
}
