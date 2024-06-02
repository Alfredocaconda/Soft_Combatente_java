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
public class Mfuncionario {
  private int idFuncionario;
  private String nome;
  private String usuario;
  private String senha;
  private String genero;
  private String bi;
  private String dataNascimento;
  private Mcargo cargo;
  private Mdepartamento departamento;
  private Mendereco endereco;
  private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
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

    public Mcargo getCargo() {
        return cargo;
    }

    public void setCargo(Mcargo cargo) {
        this.cargo = cargo;
    }

    public Mdepartamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Mdepartamento departamento) {
        this.departamento = departamento;
    }

    public Mendereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Mendereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return getNome(); //To change body of generated methods, choose Tools | Templates.
    }

    public void mensagem(String sms) {
        JOptionPane.showMessageDialog(null, sms);
    }
  
}

