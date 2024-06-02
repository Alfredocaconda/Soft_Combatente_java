/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Conexao.conexao;
import Modelo.MVconsulta;
import Modelo.Mprova;
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
public class Cprova {

    private PreparedStatement ps;
    private ResultSet rs;

    Conexao.conexao c = new conexao();

    public void eliminar(Mprova vida) {
        String sql = "delete from prova_vida where idprova=?";
        try {
            ps = c.conetar().prepareStatement(sql);
            ps.setInt(1, vida.getIdVida());
            if (ps.executeUpdate() == 1) {
                c.menssagem("Sucesso");
            } else {
                c.menssagem("Erro");
            }
        } catch (Exception e) {
            c.menssagem(e.getMessage());
        }
    }

    /*  public ArrayList<Mprova> listar() {
     ArrayList<Mprova> dado = new ArrayList<>();
     String sql = "select * from prova_vida order by idprova";
     try {
     ps = c.conetar().prepareStatement(sql);
     rs = ps.executeQuery();
     while (rs.next()) {
     Modelo.Mprova p = new Mprova();
     p.setIdVida(rs.getInt("idprova"));
     p.setEstado(rs.getString("Estado"));
     p.setDataVida(rs.getString("data"));
     dado.add(p);
     }
     } catch (SQLException ex) {
     c.menssagem(ex.getMessage());
     }
     return dado;
     }*/
    public ArrayList<Modelo.MVconsulta> consultaV() {
        ArrayList<Modelo.MVconsulta> dado = new ArrayList<>();
        String sql = "select *from consultar order by codigo";
        try {
            ps = c.conetar().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                MVconsulta cv = new MVconsulta();
                cv.setCodigo(rs.getString("CODIGO"));
                cv.setDesmobilizado(rs.getString("DESMOBILIZADO"));
                cv.setEstado(rs.getString("ESTADO"));
                cv.setData(rs.getString("DATA"));
                cv.setGenero(rs.getString("SEXO"));
                cv.setDatacadastro(rs.getString("DATAC"));
                cv.setSalario(rs.getString("SALARIO"));
                cv.setCategoria(rs.getString("CATEGORIA"));
                cv.setCidade(rs.getString("CIDADE"));
                cv.setProvincia(rs.getString("PROVINCIA"));
                dado.add(cv);
            }
        } catch (Exception e) {
            c.menssagem(e.getMessage());
        }

        return dado;
    }

    public ArrayList<Modelo.MVconsulta> pesquisar(String pesquisar) {
        ArrayList<Modelo.MVconsulta> dado = new ArrayList<>();
        String sql = "select *from consultar where desmobilizado like '%" + pesquisar + "%' order by codigo";
        try {
            ps = c.conetar().prepareStatement(sql);
            // ps.setString(1, sql);//recuperar o valor
            rs = ps.executeQuery();
            while (rs.next()) {
                MVconsulta cv = new MVconsulta();
                cv.setCodigo(rs.getString("CODIGO"));
                cv.setDesmobilizado(rs.getString("DESMOBILIZADO"));
                cv.setEstado(rs.getString("ESTADO"));
                cv.setData(rs.getString("DATA"));
                cv.setGenero(rs.getString("SEXO"));
                cv.setDatacadastro(rs.getString("DATAC"));
                cv.setSalario(rs.getString("SALARIO"));
                cv.setCategoria(rs.getString("CATEGORIA"));
                cv.setCidade(rs.getString("CIDADE"));
                cv.setProvincia(rs.getString("PROVINCIA"));
                dado.add(cv);
            }
        } catch (Exception e) {
            c.menssagem(e.getMessage());
        }

        return dado;
    }

    public void salvar(Mprova p) {

        String sql = "insert into prova_vida (estado,data,id_desmobilizado,id_funcionario) values(?,?,?,?)";
        try {
            ps = c.conetar().prepareStatement(sql);
            ps.setString(1, p.getEstado());
            ps.setString(2, p.getDataVida());
            ps.setString(3, p.getIdmob());
            ps.setInt(4, Integer.valueOf(p.getIdf()));// conversao
            if (ps.executeUpdate() == 1) {
                c.menssagem("Sucesso");
            } else {
                c.menssagem("Erro");
            }
        } catch (SQLException ex) {
            c.menssagem(ex.getMessage());
        }
    }
    Connection conexao = null;
    public void imprimirtudo() {
        conexao = c.conetar();
        try {

            JasperPrint imprimir = JasperFillManager.fillReport("C:\\Soft_Combatente\\Relatorio\\vida1.jasper", null, conexao);
            JasperViewer.viewReport(imprimir, false);
        } catch (JRException ex) {
            c.menssagem(ex.getMessage());
        }
    }

    public void atualizar(Mprova model) {
        String sql = "Update prova_vida estado=? , data=? where idprova=?";
        try {
            ps = c.conetar().prepareStatement(sql);
            ps.setString(1, model.getEstado());
            ps.setString(2, model.getDataVida());
            ps.setInt(3, model.getIdVida());
            if (ps.executeUpdate() == 1) {
                c.menssagem("Sucesso");
            } else {
                c.menssagem("Erro");
            }
        } catch (SQLException ex) {
            c.menssagem(ex.getMessage());
        }
    }

    public void imprimir(String p) {
        conexao = c.conetar();
        HashMap d = new HashMap();
        d.put("codigo", p);
        try {
            JasperPrint imprimir = JasperFillManager.fillReport("C:\\Soft_Combatente\\Relatorio\\vida2.jasper", d, conexao);
            JasperViewer.viewReport(imprimir, false);
        } catch (JRException ex) {
            c.menssagem(ex.getMessage());
        }
    }

}
