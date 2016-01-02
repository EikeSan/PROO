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
public class Usuario {

    private int codigoUsuario;
    private String nomeUsuario;
    private String loginUsuario;
    private String senhaUsuario;
    private String cpfUsuario;

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public void setCodigoUsuario(int codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public void setLoginUsuario(String loginUsuario) {
        this.loginUsuario = loginUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

    public void setCPFUsuario(String cpfUsuario) {
        this.cpfUsuario = cpfUsuario;
    }

    public String getNomeUsuario() {
        return this.nomeUsuario;
    }

    public int getCodigoUsuario() {
        return this.codigoUsuario;
    }

    public String getLoginUsuario() {
        return this.loginUsuario;
    }

    public String getSenhaUsuario() {
        return this.senhaUsuario;
    }

    public String getCPFUsuario() {
        return this.cpfUsuario;
    }
}
