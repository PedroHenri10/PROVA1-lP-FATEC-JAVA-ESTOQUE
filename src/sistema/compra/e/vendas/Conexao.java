/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.compra.e.vendas;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author 2830482411031
 */
public class Conexao {
    public Connection getConexao(){
        try{
            
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/p1estoque?useTimerzone=true&serverTimezone=UTC", "root", "root");
            System.out.println("Conexao realizada com sucesso!");
            return conn;
        }catch(Exception e){
            System.out.println("Erro ao conectar no BD" +e.getMessage());
            return null;
        }
    }
}
