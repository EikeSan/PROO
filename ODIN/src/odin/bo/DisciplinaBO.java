/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odin.bo;
import java.sql.SQLException;
import odin.dao.*;
/**
 *
 * @author Eike
 */
public class DisciplinaBO {
    public void cadastrarDisciplina(String nome, int cargaHoraria) throws SQLException{
        DisciplinaDAO discplina = new DisciplinaDAO();
        discplina.inserir(nome, cargaHoraria);
    }
}
