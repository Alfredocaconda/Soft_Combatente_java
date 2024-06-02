/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Alfredo Caconda
 */
public class conexao {

    private Connection c;
    private String caminho = "jdbc:mysql://localhost/antigo_combatente";
    private String usuario = "root";
    private String senha = "";

    public Connection conetar() {
        try {
            c = (Connection) DriverManager.getConnection(caminho, usuario, senha);
        } //Se houver erro na base de dados
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (ClassCastException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return c;
    }

    public void menssagem(String sms) {
        JOptionPane.showMessageDialog(null, sms);
    }
}
