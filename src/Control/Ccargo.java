/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Conexao.conexao;
import Modelo.Mcargo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Alfredo Caconda
 */
public class Ccargo {

    private PreparedStatement ps;// a classe que nos permite preparar a nossa base de dados
    private ResultSet rs;// para buscar toda informação na base de dados
    conexao c = new conexao(); // instanciar a classe conexão
    //para buscar os dados na base de dados

    public ArrayList<Mcargo> pesquisar(String pesquisa) {
        ArrayList<Mcargo> recebe = new ArrayList<>();
        String url = "select *from cargo where nome like '%" + pesquisa + "%' order by idCargo";
        try {
            ps = c.conetar().prepareStatement(url);
            rs = ps.executeQuery();
            while (rs.next()) {
                Mcargo mc = new Mcargo();
                mc.setIdCargo(rs.getInt("idCargo"));
                mc.setNomeC(rs.getString("nome"));
                recebe.add(mc);
            }
        } catch (SQLException ex) {
            c.menssagem(ex.getMessage());
        }
        return recebe;
    }

    public ArrayList<Mcargo> consulta() {
        ArrayList<Mcargo> dados = new ArrayList<>();// instanciamos a classe ArrayList
        String sql = "select * from cargo order by idCargo desc";//atribuimos uma variavel que vai selecionar toda a linha
        //usamos try para possiveis margem de erro no sql
        try {
            ps = c.conetar().prepareStatement(sql);//preparamos e conetamos com o sql
            rs = ps.executeQuery();// buscar os dados
            //condição 
            while (rs.next()) {
                Mcargo cargo = new Mcargo();
                cargo.setIdCargo(rs.getInt("idCargo"));
                cargo.setNomeC(rs.getString("nome"));
                dados.add(cargo);
            }
        } catch (SQLException ex) {
            c.menssagem(ex.getMessage());            
        }
        return dados;
    }

    // para salvar os dados no banco de dado

    public void salvar(Mcargo m) {
        String sql = "insert into cargo (nome) values(?)";
        try {
            ps = c.conetar().prepareStatement(sql);
            ps.setString(1, m.getNomeC());
            if (ps.executeUpdate() == 1) {
                c.menssagem("sucesso");
            } else {
                c.menssagem("erro ao salvar");
            }
        } catch (SQLException ex) {
            c.menssagem(ex.getMessage());            
        }
    }

    public void apagar(Mcargo cargo) {
        String sql = "delete from cargo where idCargo=?";
        try {
            ps = c.conetar().prepareStatement(sql);
            ps.setInt(1, cargo.getIdCargo());
            if (ps.executeUpdate() == 1) {
                c.menssagem("Sucesso");
            } else {
                c.menssagem("Erro");
            }
        } catch (SQLException ex) {
            c.menssagem(ex.getMessage());
        }
        
    }    
    
    public void atualizar(Mcargo atualizar) {
        String sql = "Update cargo set nome = ? where idCargo=?";
        try {
            ps = c.conetar().prepareStatement(sql);
            ps.setInt(2, atualizar.getIdCargo());
            ps.setString(1, atualizar.getNomeC());
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
