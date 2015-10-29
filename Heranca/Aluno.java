/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Heranca;

/**
 *
 * @author eike.santiago
 */
public class Aluno extends Pessoa {
    private String matricula;
    private int anoIngresso;
    Curso curso = new Curso();
    
    curso.getNome();

  
    
    public void setMatricula(String matricula){
        this.matricula = matricula;
    }
}
