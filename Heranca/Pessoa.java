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
public class Pessoa {
    private String nome;
    private char sexo;
    private String cpf;
    private String rg;


    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setSexo(char sexo){
        this.sexo = sexo;
    }
    
    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public void setRg(String rg){
        this.rg = rg;
    }
}