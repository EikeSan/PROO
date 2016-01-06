/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odin.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static junit.framework.Assert.assertFalse;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import junit.framework.TestCase;
import odin.model.*;

/**
 *
 * @author Suporte
 */
public class AlunoDAOTest extends TestCase{
    
   IConexao banco = new ConexaoMySQL();
    Connection conexao = null;
    AlunoDAO alunoDAO;

    @Override
    protected void setUp() throws Exception {
        conexao = banco.getConexao("jdbc:mysql", "localhost", "odin", "root", "");
        alunoDAO = new AlunoDAO();
        super.setUp();
    }
    
    @Test
    public void testDeveriaRetornarOsDadosDosAlunosPorDisciplina() throws Exception {
        try {
            conexao.setAutoCommit(false);
            Statement stmt = conexao.createStatement();
//            stmt.execute("INSERT INTO usuario(cpf,nome,usuario,senha,tipo_usuario) values('1111','test','test','1234','Aluno')");
//            stmt.execute("INSERT INTO usuario(cpf,nome,usuario,senha,tipo_usuario) values('2222','test2','test2','1234','Professor')");

            ArrayList<Aluno> listaAlunos = new ArrayList<Aluno>();

            listaAlunos = alunoDAO.listarAlunosPorDisciplina(8);

            for (int i = 0; i < listaAlunos.size(); i++) {
                System.out.println(listaAlunos.get(i).getNomeUsuario());
            }

        } catch (SQLException e) {
            assertFalse(e.getMessage(), true);
        }finally{
            conexao.rollback();
        }
    }
}
