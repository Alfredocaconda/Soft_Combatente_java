/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javax.swing.JOptionPane;

/**
 *
 * @author Alfredo Caconda
 */
public class Mcategoria {
   private int idCategoria;
    private String nomeC;

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNomeC() {
        return nomeC;
    }

    public void setNomeC(String nomeC) {
        this.nomeC = nomeC;
    }

    @Override
    public String toString() {
        return getNomeC(); //To change body of generated methods, choose Tools | Templates.
    }
   public void mensagem(String sms){
        JOptionPane.showMessageDialog(null, sms);
    }
}
