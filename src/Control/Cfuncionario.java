/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Conexao.conexao;
import Modelo.MVfuncionario;
import Modelo.Mfuncionario;
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
public class Cfuncionario {

    private PreparedStatement ps;
    private ResultSet rs;
    conexao c = new conexao();

    public ArrayList<Modelo.MVfuncionario> listar() {
        ArrayList<Modelo.MVfuncionario> dado = new ArrayList<>();
        String sql = "select * from func order by codigo desc";
        try {
            ps = c.conetar().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                MVfuncionario f = new MVfuncionario();
                f.setCodigo(rs.getInt("CODIGO"));
                f.setNome(rs.getString("NOME"));
                f.setGenero(rs.getString("GENERO"));
                f.setBi(rs.getString("BI"));
                f.setDataNascimento(rs.getString("NASCIMENTO"));
                f.setDatacadastro(rs.getString("CADASTRO"));
                f.setUsuario(rs.getString("Usuario"));
                f.setSenha(rs.getString("senha"));
                f.setCargo(rs.getString("CARGO"));
                f.setDepartamento(rs.getString("Departamento"));
                f.setMunicipio(rs.getString("municipio"));
                f.setProvincia(rs.getString("provincia"));
                dado.add(f);
            }
        } catch (SQLException ex) {
            c.menssagem(ex.getMessage());
        }
        return dado;
    }

    public ArrayList<MVfuncionario> pesquisar(String pesquisar) {
        ArrayList<MVfuncionario> dados = new ArrayList<>();
        String sql = "select * from func where nome like '%" + pesquisar + "%'order by codigo";
        try {
            ps = c.conetar().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Modelo.MVfuncionario f = new MVfuncionario();
                f.setCodigo(rs.getInt("CODIGO"));
                f.setNome(rs.getString("NOME"));
                f.setGenero(rs.getString("GENERO"));
                f.setBi(rs.getString("BI"));
                f.setDataNascimento(rs.getString("NASCIMENTO"));
                f.setDatacadastro(rs.getString("CADASTRO"));
                f.setUsuario(rs.getString("Usuario"));
                f.setSenha(rs.getString("senha"));
                f.setCargo(rs.getString("CARGO"));
                f.setDepartamento(rs.getString("Departamento"));
                f.setMunicipio(rs.getString("municipio"));
                f.setProvincia(rs.getString("provincia"));
                dados.add(f);
            }
        } catch (SQLException ex) {
            c.menssagem(ex.getMessage());
        }
        return dados;
    }

    //para inserir os dados na base de dados
    public void guardar(Mfuncionario funcionario) {
        String sql = "insert into funcionario(nome,Usuario,senha,"
                + "sexo,BI,dataNascimento,dataCadastro,Endereco_id,"
                + "Departamento_id,Cargo_id) values(?,?,?,?,?,?,?,?,?,?)";
        try {
            ps = c.conetar().prepareStatement(sql);
            ps.setString(1, funcionario.getNome());
            ps.setString(2, funcionario.getUsuario());
            ps.setString(3, funcionario.getSenha());
            ps.setString(4, funcionario.getGenero());
            ps.setString(5, funcionario.getBi());
            ps.setString(6, funcionario.getDataNascimento());
            ps.setString(7, funcionario.getData());
            ps.setInt(9, funcionario.getDepartamento().getIdDepartamento());
            ps.setInt(8, funcionario.getEndereco().getIdEndereco());
            ps.setInt(10, funcionario.getCargo().getIdCargo());
            if (ps.executeUpdate() == 1) {
                c.menssagem("Sucesso");
            } else {
                c.menssagem("Erro");
            }
        } catch (Exception e) {
            c.menssagem(e.getMessage());
        }
    }

    public void delete(Mfuncionario f) {
        String sql = "delete from funcionario where idFuncionario=?";
        try {
            ps = c.conetar().prepareStatement(sql);
            ps.setInt(1, f.getIdFuncionario());
            if (ps.executeUpdate() == 1) {
                c.menssagem("sucesso");
            } else {
                c.menssagem("Erro");
            }
        } catch (SQLException ex) {
            c.menssagem(ex.getMessage());
        }
    }

    public void actualizar(Mfuncionario model) {
        String sql = "Update funcionario set nome=?,Usuario=?,senha=?,"
                + "sexo=?,BI=?,dataNascimento=?,dataCadastro=?,Endereco_id=?,"
                + "Departamento_id=?,Cargo_id=? where idFuncionario=?";
        try {
            ps = c.conetar().prepareStatement(sql);
            ps.setString(1, model.getNome());
            ps.setString(2, model.getUsuario());
            ps.setString(3, model.getSenha());
            ps.setString(4, model.getGenero());
            ps.setString(5, model.getBi());
            ps.setString(6, model.getDataNascimento());
            ps.setString(7, model.getData());
            ps.setInt(8, model.getEndereco().getIdEndereco());
            ps.setInt(9, model.getDepartamento().getIdDepartamento());
            ps.setInt(10, model.getCargo().getIdCargo());
            ps.setInt(11, model.getIdFuncionario());
            if (ps.executeUpdate() == 1) {
                c.menssagem("sucesso");
            } else {
                c.menssagem("Erro");
            }
        } catch (SQLException ex) {
            c.menssagem(ex.getMessage());
        }
    }

    public void imprimir() {
        try {
            JasperPrint imprimir = JasperFillManager.fillReport("C:\\Soft_Combatente\\Relatorio\\funcionario.jasper", null, c.conetar());
            JasperViewer.viewReport(imprimir, false);
        } catch (JRException ex) {
            c.menssagem(ex.getMessage());
        }
    }
    public void imprimir2(String dado){
        HashMap h= new HashMap();
        h.put("codigo", dado);
        try {
          JasperPrint imprimir = JasperFillManager.fillReport("C:\\Soft_Combatente\\Relatorio\\funcionario2.jasper", h, c.conetar());
            JasperViewer.viewReport(imprimir, false);  
        } catch (Exception e) {
            c.menssagem(e.getMessage());
        }
    }
}
