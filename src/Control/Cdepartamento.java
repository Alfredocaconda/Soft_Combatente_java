/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Conexao.conexao;
import Modelo.Mdepartamento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Alfredo Caconda
 */
public class Cdepartamento {

    private PreparedStatement ps;
    private ResultSet rs;
    conexao c = new conexao();

    public void eliminar(Mdepartamento depart) {
        String sql = "delete from departamento where idDepartamento=?";
        try {
            ps = c.conetar().prepareStatement(sql);
            ps.setInt(1, depart.getIdDepartamento());
            if (ps.executeUpdate() == 1) {
                c.menssagem("Sucesso");
            } else {
                c.menssagem("Erro");
            }
        } catch (Exception e) {
            c.menssagem(e.getMessage());
        }
    }

    public ArrayList<Mdepartamento> pesquisar(String pesquisar) {
        ArrayList<Mdepartamento> dp = new ArrayList<>();
        String recebe = "select *from departamento where nome like '%" + pesquisar + "%' order by idDepartamento";
        try {
            ps = c.conetar().prepareStatement(recebe);
            rs = ps.executeQuery();
            while (rs.next()) {
                Mdepartamento d = new Mdepartamento();
                d.setIdDepartamento(rs.getInt("idDepartamento"));
                d.setNome(rs.getString("nome"));
                dp.add(d);
            }
        } catch (SQLException ex) {
            c.menssagem(ex.getMessage());
        }

        return dp;
    }

    // para guardar e inserir os dados na base de dados

    public int guardar(Mdepartamento d) {
        int r = 0;
        String sql = "insert into departamento (nome) values(?)";
        try {
            ps = c.conetar().prepareStatement(sql);
            ps.setString(1, d.getNome());
            r = ps.executeUpdate();
        } catch (SQLException ex) {
            c.menssagem(ex.getMessage());
        }
        return r;
    }

    // para listar os dados na comboboxe do formulario tarefa
    public ArrayList<Mdepartamento> listar() {
        ArrayList<Mdepartamento> md = new ArrayList<>();
        String sql = "select * from departamento order by idDepartamento desc";
        try {
            ps = c.conetar().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Mdepartamento d = new Mdepartamento();
                d.setIdDepartamento(rs.getInt(1));
                d.setNome(rs.getString(2));
                md.add(d);
            }
        } catch (Exception e) {
            c.menssagem(e.getMessage());
        }
        return md;
    }

    public void actualizar(Mdepartamento atualizar) {
        String sql = "Update departamento set nome=? where idDepartamento=? ";
        try {
            ps = c.conetar().prepareStatement(sql);
            ps.setString(1, atualizar.getNome());
            ps.setInt(2, atualizar.getIdDepartamento());
            if (ps.executeUpdate() == 1) {
                c.menssagem("Sucesso");
            } else {
                c.menssagem("Erro");
            }
        } catch (Exception e) {
            c.menssagem(e.getMessage());
        }
    }
}
