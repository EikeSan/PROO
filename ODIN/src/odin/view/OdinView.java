/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odin.view;

import java.sql.SQLException;
import java.util.Scanner;
import odin.dao.*;

public class OdinView {
    public void telaLogin() throws SQLException{
        String usuario,senha;
        Scanner in = new Scanner (System.in);
        System.out.println("*********************ODIN**************************");
        System.out.println("Login: ");
        usuario = in.nextLine();
        System.out.println("Senha: ");
        senha = in.nextLine();
        LoginDAO login = new LoginDAO(usuario, senha);
        System.out.println(login.checarDados());
    }
    public static void main (String[] args) throws SQLException{
        OdinView odin = new OdinView();
        odin.telaLogin();
    }
}

