/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Alfredo Caconda
 */
public class Mprova {

    private int idVida;
  
    private String dataVida;
    private String estado;
    private Modelo.Mfuncionario funcionario;
    private String idf;
    private String idmob;

    public Mfuncionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Mfuncionario funcionario) {
        this.funcionario = funcionario;
    }

    public Mdesmobilizado getDesmobilizado() {
        return desmobilizado;
    }

    public void setDesmobilizado(Mdesmobilizado desmobilizado) {
        this.desmobilizado = desmobilizado;
    }
    private Modelo.Mdesmobilizado desmobilizado;
    public int getIdVida() {
        return idVida;
    }

    public void setIdVida(int idVida) {
        this.idVida = idVida;
    }

    

    public String getDataVida() {
        return dataVida;
    }

    public void setDataVida(String dataVida) {
        this.dataVida = dataVida;
    }


    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getIdf() {
        return idf;
    }

    public void setIdf(String idf) {
        this.idf = idf;
    }

    public String getIdmob() {
        return idmob;
    }

    public void setIdmob(String idmob) {
        this.idmob = idmob;
    }
}
