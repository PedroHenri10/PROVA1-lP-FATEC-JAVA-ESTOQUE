/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.compra.e.vendas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import sistema.compra.e.vendas.entity.ItemNota;
import sistema.compra.e.vendas.util.Conexao;

/**
 *
 * @author 2830482411031
 */
public class ItemNotaDAO {
    private Conexao conexao;
    private Connection conn;
    
    public ItemNotaDAO(){
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    
     public void inserirItemNota(ItemNota item) {
        String sql = "INSERT INTO itemnota (cod_nota, cod_produto, quantidade, preco_unitario) VALUES (?, ?, ?, ?)";
 
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, item.getCod_nota());
            ps.setInt(2, item.getCod_produto());
            ps.setInt(3, item.getQuantidade());
            ps.setFloat(4, item.getPreco_unitario());
 
            ps.executeUpdate();
            System.out.println("Item inserido com sucesso!");
 
        } catch (SQLException e) {
            System.out.println("Erro ao inserir item da nota: " + e.getMessage());
        }
    }
}
