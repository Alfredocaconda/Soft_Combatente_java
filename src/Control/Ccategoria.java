/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Conexao.conexao;
import Modelo.Mcategoria;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Alfredo Caconda
 */
public class Ccategoria {

    private PreparedStatement ps;
    private ResultSet rs;
    conexao c = new conexao();

    public ArrayList<Mcategoria> consulta() {
        ArrayList<Mcategoria> dados = new ArrayList<>();
        String sql = "select * from categoria order by idCategoria desc";
        try {
            ps = c.conetar().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Mcategoria m = new Mcategoria();
                m.setIdCategoria(rs.getInt("idCategoria"));
                m.setNomeC(rs.getString("nome"));
                dados.add(m);
            }
        } catch (Exception e) {
            c.menssagem(e.getMessage());
        }
        return dados;
    }
    public ArrayList<Mcategoria> pesquisar(String pesquisar) {
        ArrayList<Mcategoria> dados = new ArrayList<>();
        String sql = "select * from categoria where nome like '%"+pesquisar+"%' order by idCategoria";
        try {
            ps = c.conetar().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Mcategoria m = new Mcategoria();
                m.setIdCategoria(rs.getInt("idCategoria"));
                m.setNomeC(rs.getString("nome"));
                dados.add(m);
            }
        } catch (Exception e) {
            c.menssagem(e.getMessage());
        }
        return dados;
    }

    public int salvar(Mcategoria m) {
         int r = 0;
        String sql = "insert into categoria(nome) values(?)";
        try {
            ps = c.conetar().prepareStatement(sql);
            ps.setString(1, m.getNomeC());
            r = ps.executeUpdate();

        } catch (SQLException e) {
            c.menssagem(e.getMessage());
        }
        return r;
    }

    public void eliminar(Mcategoria m) {
        String sql = "delete from CATEGORIA where idCategoria=?";
        try {
            ps = c.conetar().prepareStatement(sql);
            ps.setInt(1, m.getIdCategoria());
            if (ps.executeUpdate() == 1) {
                c.menssagem("Sucesso");
            } else {
                c.menssagem("Erro");
            }
        } catch (SQLException ex) {
            c.menssagem(ex.getMessage());
        }
    }

    public void atualizar(Mcategoria m) {
        String sql = "Update CATEGORIA set nome=? where idCategoria=?";
        try {
            ps = c.conetar().prepareStatement(sql);
            ps.setString(1, m.getNomeC());
            ps.setInt(2, m.getIdCategoria());
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
