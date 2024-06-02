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
public class Mendereco {
     private int idEndereco;
    private String cidade;
    private String provincia;

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public int getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }
    @Override
    public String toString() {
        return getCidade()+"/"+ getProvincia();//To change body of generated methods, choose Tools | Templates.
    }
     public void mensagem(String sms){
        JOptionPane.showMessageDialog(null, sms);
    }
}
