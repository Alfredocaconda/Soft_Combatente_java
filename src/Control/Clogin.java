/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Conexao.conexao;
import Modelo.Mfuncionario;
import java.io.File;
import java.io.FileWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Alfredo Caconda
 */
public class Clogin {
    
    private PreparedStatement ps;
    private ResultSet rs;
    conexao c = new conexao();
    
    public int consultar(Mfuncionario funcionario) {
        int v=0;
        String sql = "select idFuncionario,usuario,senha,nome from funcionario where usuario =? && senha =? ";
        try {
            ps = c.conetar().prepareStatement(sql);
            ps.setString(1, funcionario.getUsuario());
            ps.setString(2, funcionario.getSenha());
            rs = ps.executeQuery();
            if (rs.first()) {
              v=1;
           loginTexto(rs.getInt("idFuncionario"), rs.getString("nome"));
            } else {
                c.menssagem("Usuario ou senha errada");
            }
        } catch (SQLException ex) {
            c.menssagem(ex.getMessage());
        } 
        return v;
    }
        String url="C:/arquivo/login.txt";
        File ff= new File(url);
        public String recuprarValor(int valor){
            String recupera="programador";
            try {
                Scanner s= new Scanner(ff);
                while(s.hasNextLine()){
                    if (valor==0) {
                        recupera=s.nextLine().split("separa")[0];//recuprar o id do funcionario
                    } else {
                        recupera=s.nextLine().split("separa")[1];//recuperar o nome
                    }
                }
                
            } catch (Exception e) {
            }
            return recupera;
        }
    private void loginTexto(int id,String nome){
        //para guardar o arquivo no disco c
        File f= new File("C:/arquivo"); 
        f.mkdir();
        
        try {
            FileWriter fw= new FileWriter(ff);
            fw.write(id+"separa"+nome);
            fw.close();            
        } catch (Exception e) {
            c.menssagem(e.getMessage());
        }
    }
}
