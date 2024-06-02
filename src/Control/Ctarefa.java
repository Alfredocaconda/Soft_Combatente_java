/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Conexao.conexao;
import Modelo.MVTAREFA;
import Modelo.Mtarefa;
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
public class Ctarefa {

    private PreparedStatement ps;
    private ResultSet rs;
    conexao c = new conexao();

     
     Connection conexao=null;
      public void imprimir(String p) {
        conexao = c.conetar();
        HashMap d = new HashMap();
        d.put("id", p);
        try {
            JasperPrint imprimir = JasperFillManager.fillReport("C:\\Soft_Combatente\\Relatorio\\tarefa2.jasper", d, conexao);
            JasperViewer.viewReport(imprimir, false);
        } catch (JRException ex) {
            c.menssagem(ex.getMessage());
        }
    }
      public void imprimirtudo() {
        conexao = c.conetar();
       
        try {
            JasperPrint imprimir = JasperFillManager.fillReport("C:\\Soft_Combatente\\Relatorio\\tarefa1.jasper", null, conexao);
            JasperViewer.viewReport(imprimir, false);
        } catch (JRException ex) {
            c.menssagem(ex.getMessage());
        }
    }
    public ArrayList<MVTAREFA> listar() {
        ArrayList<MVTAREFA> tarefa = new ArrayList<>();
        String sql = "select * from mvtarefa order by codigo";
        try {
            ps = c.conetar().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                MVTAREFA t = new MVTAREFA();
                t.setCODIGO(rs.getInt("codigo"));
                t.setNomeDaTarefa(rs.getString("tarefa"));
                t.setInicio(rs.getString("inicio"));
                t.setTermino(rs.getString("termino"));
                t.setDepartamento(rs.getString("departamento"));
                t.setDescricao(rs.getString("descricao"));
                t.setEstado(rs.getString("estado"));
                tarefa.add(t);
            }
        } catch (Exception e) {
            c.menssagem(e.getMessage());
        }
        return tarefa;
    }
      public ArrayList<MVTAREFA> pesquisar(String pesquisar) {
        ArrayList<MVTAREFA> tarefa = new ArrayList<>();
        String sql = "select * from mvtarefa where tarefa like '%" +pesquisar+ "%' order by codigo";
        try {
            ps = c.conetar().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
               MVTAREFA t = new MVTAREFA();
                t.setCODIGO(rs.getInt("codigo"));
                t.setNomeDaTarefa(rs.getString("tarefa"));
                t.setInicio(rs.getString("inicio"));
                t.setTermino(rs.getString("termino"));
                t.setDepartamento(rs.getString("departamento"));
                t.setDescricao(rs.getString("descricao"));
                t.setEstado(rs.getString("estado"));
                tarefa.add(t);
            }
        } catch (Exception e) {
            c.menssagem(e.getMessage());
        }
        return tarefa;
    }

    public void salvar(Mtarefa m) {
        String sql = "insert into tarefa (tarefa,inicio,termino,estado,descricao,departamento_id) values(?,?,?,?,?,?)";
        try {
            ps = c.conetar().prepareStatement(sql);
            ps.setString(1, m.getNomeDaTarefa());
            ps.setString(2, m.getDataInicio());
            ps.setString(3, m.getDataTermino());
            ps.setString(4, m.getEstado());
            ps.setString(5, m.getDescricao());
            ps.setInt(6, m.getDepartamento().getIdDepartamento());
            if (ps.executeUpdate() == 1) {
                c.menssagem("Sucesso no agendamento");
            } else {
                c.menssagem("Erro ao agendar");
            }
        } catch (SQLException ex) {
            c.menssagem(ex.getMessage());
        }
    }

    public void deletar(Mtarefa m) {
        String sql = "delete from tarefa where idt=?";
        try {
            ps = c.conetar().prepareStatement(sql);
            ps.setInt(1, m.getIdTarefa());
            if (ps.executeUpdate() == 1) {
                c.menssagem("Sucesso");
            } else {
                c.menssagem("Erro");
            }
        } catch (SQLException ex) {
            c.menssagem(ex.getMessage());
        }
    }

    public void atualizar(Mtarefa m) {
        String sql = "Update tarefa set tarefa=?,inicio=?,termino=?,estado=?,descricao=?,departamento_id=? where idt=?";
        try {
            ps = c.conetar().prepareStatement(sql);
            ps.setString(1, m.getNomeDaTarefa());
            ps.setString(2, m.getDataInicio());
            ps.setString(3, m.getDataTermino());
            ps.setString(4, m.getEstado());
            ps.setString(5, m.getDescricao());
            ps.setInt(6, m.getDepartamento().getIdDepartamento());
            ps.setInt(7, m.getIdTarefa());
            
            if (ps.executeUpdate() == 1) {
                c.menssagem("Sucesso");
            } else {
                c.menssagem("Erro");
            }
        } catch (SQLException ex) {
            c.menssagem(ex.getMessage());
        }
    }

}
