/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Conexao.conexao;
import Modelo.MVdesmobilizado;
import Modelo.Mdesmobilizado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Alfredo Caconda
 */
public class Cdesmobilizado {

    private PreparedStatement ps;
    private ResultSet rs;
    Conexao.conexao c = new conexao();
    // codigo para deletar na base de dado
    //1-chamanos a modal do desmobilizado

    public void delete(Mdesmobilizado d) {
        //declaramos uma variavel qualquer que vai receber a linha de codigo do mysl que é o delete
        String sql = "delete from desmobilizado where idMobilizado=?";
        // usamos o try para nos dar informação acerca dos erros
        try {
            //preparamos a base de dados e conectamos com a conexão
            ps = c.conetar().prepareStatement(sql);

            ps.setInt(1, d.getIdMobilizado());
            //condção que vai atualizar os dados
            if (ps.executeUpdate() == 1) {
                c.menssagem("sucesso");
            } else {
                c.menssagem("Erro");
            }
        } catch (SQLException ex) {
            //informção se gerar erro com a abase de dados
            c.menssagem(ex.getMessage());
        }
    }

    //metodo salvar

    public void salvar(Mdesmobilizado m) {
        //declaramos uma variavel qualquer que vai receber a linha de codigo do mysl que é a inserção de dados
        String sql = "insert into desmobilizado (nome,sexo,bi,dataNascimento,dataCadastro,"
                + "idCategoria,idEndereco,salario) values(?,?,?,?,?,?,?,?)";
        // usamos o try para nos dar informação acerca dos erros
        try {
            //preparamos a base de dados e conetamos com a conexão
            ps = c.conetar().prepareStatement(sql);
            // recemos da modal e setamos os valor em cada posição 
            ps.setString(1, m.getNome());
            ps.setString(2, m.getGenero());
            ps.setString(3, m.getBi());
            ps.setString(4, m.getDataNascimento());
            ps.setString(5, m.getDatac());
            ps.setInt(6, m.getCategoria().getIdCategoria());
            ps.setInt(7, m.getEndereco().getIdEndereco());
            ps.setString(8, m.getSalario());
//condção que vai atualizar os dados
            if (ps.executeUpdate() == 1) {
                c.menssagem("Sucesso");
            } else {
                c.menssagem("Erro");
            }
        } catch (SQLException ex) {
            //informção se gerar erro com a abase de dados
            c.menssagem(ex.getMessage());
        }
    }

    // o metodo pesquisar de um arraylist ou seja que vai listar os dados de uma forma ordenada

    public ArrayList<MVdesmobilizado> pesquisar(String pesquisar) {
        ArrayList<MVdesmobilizado> dados = new ArrayList<>();
        String sql = "select *from decategoria where nome like '%" + pesquisar + "%' order by codigo";
        try {
            ps = c.conetar().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                MVdesmobilizado d = new MVdesmobilizado();
              d.setIdMobilizado(rs.getString("codigo"));
                d.setGenero(rs.getString("genero"));
                d.setNome(rs.getString("nome"));
                d.setBi(rs.getString("bi"));
                d.setDataNascimento(rs.getString("nascimento"));
                d.setDataCadastro(rs.getString("cadastro"));
                d.setSalario(rs.getString("salario"));
                d.setMunicipio(rs.getString("MUNICIPIO"));
                d.setProvincia(rs.getString("PROVINCIA"));
                d.setCategoria(rs.getString("CATEGORIA"));
                dados.add(d);
            }
        } catch (SQLException ex) {
            //informção se gerar erro com a abase de dados
            c.menssagem(ex.getMessage());
        }
        return dados;
    }
// o metodo consultar de um arraylist ou seja que vai listar os dados de uma forma ordenada

    public ArrayList<Modelo.MVdesmobilizado> consultar() {
        //instanciamos a classe arraylist 
        ArrayList<MVdesmobilizado> dados = new ArrayList<>();
        //declaramos uma variavel qualquer que vai receber a linha de codigo do mysl que é a seleção de dados em forma decresçente
        String sql = "select * from decategoria order by codigo desc";
        // usamos o try para nos dar informação acerca dos erros
        try {
            //preparamos a base de dados e conetamos com a conexão
            ps = c.conetar().prepareStatement(sql);
            rs = ps.executeQuery();
            //a condição while para ver se temos uma linha e listar os dados
            while (rs.next()) {
                //instanciamos a modal
                MVdesmobilizado d = new MVdesmobilizado();
                //cada variavel da modal vai receber e setar os dados na modal
                d.setIdMobilizado(rs.getString("codigo"));
                d.setGenero(rs.getString("genero"));
                d.setNome(rs.getString("nome"));
                d.setBi(rs.getString("bi"));
                d.setDataNascimento(rs.getString("nascimento"));
                d.setDataCadastro(rs.getString("cadastro"));
                d.setSalario(rs.getString("salario"));
                d.setMunicipio(rs.getString("MUNICIPIO"));
                d.setProvincia(rs.getString("PROVINCIA"));
                d.setCategoria(rs.getString("CATEGORIA"));
                dados.add(d);//adicionamos os dados na modal
            }
        } catch (SQLException ex) {
            //informção se gerar erro com a abase de dados
            c.menssagem(ex.getMessage());
        }
        //retorno do daod
        return dados;
    }
//metodo atualizar

    public void atualizar(Mdesmobilizado model) {
        //declaramos uma variavel qualquer que vai receber a linha de codigo do mysl que é a atualicação de dados
        String sql = "Update desmobilizado set nome=?,sexo=?,bi=?,dataNascimento=?,dataCadastro=?,"
                + "idCategoria=?,idEndereco=?,salario=? where idMobilizado=?";
        // usamos o try para nos dar informação acerca dos erros
        try {
            //preparamos a base de dados e conetamos com a conexão
            ps = c.conetar().prepareStatement(sql);
            // recemos da modal e setamos os valor em cada posição
            ps.setString(1, model.getNome());
            ps.setString(2, model.getGenero());
            ps.setString(3, model.getBi());
            ps.setString(4, model.getDataNascimento());
            ps.setString(5, model.getDatac());
            ps.setInt(6, model.getCategoria().getIdCategoria());
            ps.setInt(7, model.getEndereco().getIdEndereco());
            ps.setString(8, model.getSalario());
            ps.setInt(9, model.getIdMobilizado());
            //condção que vai atualizar os dados
            if (ps.executeUpdate() == 1) {
                c.menssagem("Sucesso");
            } else {
                c.menssagem("Erro");
            }
        } catch (SQLException ex) {
            //informção se gerar erro com a abase de dados
            c.menssagem(ex.getMessage());
        }
    }
    Connection conexao = null;

    public void imprimir1(String n) {
        conexao = c.conetar();
        HashMap d = new HashMap();
        d.put("codigo", n);

        try {
            JasperPrint imprimir = JasperFillManager.fillReport("C:\\Soft_Combatente\\Relatorio\\DESMOBILIZADO2.jasper", d, conexao);
            JasperViewer.viewReport(imprimir, false);
        } catch (JRException ex) {
            c.menssagem(ex.getMessage());
        }
    }

    public void imprimirtudo() {
        conexao = c.conetar();
        try {
            JasperPrint print = JasperFillManager.fillReport("C:\\Soft_Combatente\\Relatorio\\DESMOBILIZADO.jasper", null, conexao);
            JasperViewer.viewReport(print, false);
        } catch (JRException ex) {
            c.menssagem(ex.getMessage());
        }
    }
}
