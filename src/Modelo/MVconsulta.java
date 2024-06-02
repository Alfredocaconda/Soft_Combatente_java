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
public class MVconsulta {
    private String codigo;
    private String estado;
    private String data;
    private String desmobilizado;
    private String genero;
    private String datacadastro;
    private String salario;
    private String categoria;
    private String cidade;
    private String provincia;

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDesmobilizado() {
        return desmobilizado;
    }

    public void setDesmobilizado(String desmobilizado) {
        this.desmobilizado = desmobilizado;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDatacadastro() {
        return datacadastro;
    }

    public void setDatacadastro(String datacadastro) {
        this.datacadastro = datacadastro;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
