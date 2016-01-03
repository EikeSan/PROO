/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odin.bo;
import java.sql.SQLException;
import java.util.ArrayList;
import odin.dao.*;
import odin.model.Disciplina;
/**
 *
 * @author Eike
 */
public class DisciplinaBO {
    public void cadastrarDisciplina(String nome, int cargaHoraria) throws SQLException{
        DisciplinaDAO discplina = new DisciplinaDAO();
        discplina.inserir(nome, cargaHoraria);
    }
     public ArrayList<Disciplina> consultarDisciplina() throws SQLException{
        DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
        ArrayList<Disciplina> listaDisciplinas = new ArrayList<Disciplina>();
        listaDisciplinas = disciplinaDAO.listarDisciplinas();
        return listaDisciplinas;
    }
     
      public void excluirDisciplina(int codigo) throws SQLException{
        DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
        disciplinaDAO.excluir(codigo);
    }
     public void alterarDisciplina(int codigo,String nome,int cargaHoraria) throws SQLException{
        DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
        disciplinaDAO.alterar(codigo,nome,cargaHoraria);
    }
}
