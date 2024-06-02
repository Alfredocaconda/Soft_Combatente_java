/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Conexao.conexao;
import Modelo.Mendereco;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Alfredo Caconda
 */
public class Cendereco {

    private PreparedStatement ps;
    private ResultSet rs;
    Conexao.conexao c = new conexao();

    public ArrayList<Mendereco> listar() {
        ArrayList<Mendereco> dados = new ArrayList<>();
        String sql = "select * from endereco order by idEndereco desc";
        try {
            ps = c.conetar().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Mendereco m = new Mendereco();
                m.setIdEndereco(rs.getInt("idEndereco"));
                m.setCidade(rs.getString("cidade"));
                m.setProvincia(rs.getString("provincia"));
                dados.add(m);
            }
        } catch (Exception e) {
            c.menssagem(e.getMessage());
        }
        return dados;
    }

    public ArrayList<Mendereco> pesquisar(String pesquisar) {
        ArrayList<Mendereco> dados = new ArrayList<>();
        String sql = "select * from endereco where cidade like '%" +pesquisar+"%' order by idEndereco";
        try {
            ps = c.conetar().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Mendereco m = new Mendereco();
                m.setIdEndereco(rs.getInt("idEndereco"));
                m.setCidade(rs.getString("cidade"));
                m.setProvincia(rs.getString("provincia"));
                dados.add(m);
            }
        } catch (Exception e) {
            c.menssagem(e.getMessage());
        }
        return dados;
    }

    public int salvar(Mendereco end) {
        int r = 0;
        String sql = "insert into endereco (cidade,provincia) values(?,?)";
        try {
            ps = c.conetar().prepareStatement(sql);
            ps.setString(1, end.getCidade());
            ps.setString(2, end.getProvincia());
            r = ps.executeUpdate();
            if (r == 1) {
                c.menssagem("Sucesso");
            } else {
                c.menssagem("Erro no Cadastro");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return r;
    }

    public void apagar(Mendereco endereco) {
        String sql = "delete from endereco where idEndereco=?";
        try {
            ps = c.conetar().prepareStatement(sql);
            ps.setInt(1, endereco.getIdEndereco());
            if (ps.executeUpdate() == 1) {
                c.menssagem("Sucesso");
            } else {
                c.menssagem("Erro");
            }
        } catch (SQLException ex) {
            c.menssagem(ex.getMessage());
        }

    }

    public void atualizar(Mendereco model) {
        String sql = "Update endereco set cidade=?,provincia=? where idEndereco=?";
        try {
            ps = c.conetar().prepareStatement(sql);
            ps.setInt(3, model.getIdEndereco());
            ps.setString(1, model.getCidade());
            ps.setString(2, model.getProvincia());
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
