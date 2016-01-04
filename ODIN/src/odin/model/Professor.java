/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odin.model;

/**
 *
 * @author Eike
 */
public class Professor extends Usuario{
    private int codigoProfessor;
    public void setCodigoProfessor(int codigo){
        this.codigoProfessor = codigo;
    }
    public int getCodigoProfessor(){
        return this.codigoProfessor;
    }
}
