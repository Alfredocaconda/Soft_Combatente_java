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
public class Mdesmobilizado {
   private int idMobilizado;
    private String genero;
    private String nome;
    private String bi;
    private String dataNascimento;
    private Mcategoria categoria;
    private Mendereco endereco;
    private String Datac;
    private String salario;
    public String getDatac() {
        return Datac;
    }

    public void setDatac(String Datac) {
        this.Datac = Datac;
    }

    public int getIdMobilizado() {
        return idMobilizado;
    }

    public void setIdMobilizado(int idMobilizado) {
        this.idMobilizado = idMobilizado;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getBi() {
        return bi;
    }

    public void setBi(String bi) {
        this.bi = bi;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Mcategoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Mcategoria categoria) {
        this.categoria = categoria;
    }

    public Mendereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Mendereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return getNome();
    }
     public void mensagem(String sms){
        JOptionPane.showMessageDialog(null, sms);
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

}
