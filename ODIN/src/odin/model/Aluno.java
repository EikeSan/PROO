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
public class Aluno extends Usuario {

    private int faltas,codigoAluno;
    private double nota1;
    private double nota2;
    private double notaFinal;

    public void setFaltas(int faltas) {
        this.faltas = faltas;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public void setNotaFinal(double notaFinal) {
        this.notaFinal = notaFinal;
    }

    public int getFaltas() {
        return faltas;
    }

    public double getNota1() {
        return nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public double getNotaFinal() {
        return notaFinal;
    }

    public void setCodigo_aluno(int codigo_aluno) {
        this.codigoAluno = codigo_aluno;
    }

    public int getCodigo_aluno() {
        return this.codigoAluno;
    }
    
}
