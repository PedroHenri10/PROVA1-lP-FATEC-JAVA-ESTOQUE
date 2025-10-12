/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.compra.e.vendas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import sistema.compra.e.vendas.entity.Produto;
import sistema.compra.e.vendas.util.Conexao;

/**
 *
 * @author 2830482411031
 */
public class ProdutoDAO {
    private Conexao conexao;
    private Connection conn;
    
    public ProdutoDAO(){
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    
    public void inserirProduto(Produto produto){
        String sql = "INSERT INTO produto (cod_produto, nome, descricao, preco_venda, qtd_estoque) VALUES (?,?,?,?,?);";
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, produto.getCod_Produto());
            stmt.setString(2, produto.getNome());
            stmt.setString(3, produto.getDescricao());
            stmt.setFloat(4, produto.getPreco_venda());            
            stmt.setInt(5, produto.getQtd_estoque());  
            stmt.execute();
        }catch(SQLException ex){
            System.out.println("Erro ao inserir Produto: " +ex.getMessage());
        }
    }

    public List<Produto> listarTodos() {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM produto;";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Produto p = new Produto();
                p.setCod_Produto(rs.getInt("cod_produto"));
                p.setNome(rs.getString("nome"));
                p.setDescricao(rs.getString("descricao"));
                p.setPreco_venda(rs.getFloat("preco_venda"));
                p.setQtd_estoque(rs.getInt("qtd_estoque"));
                
                produtos.add(p);
            }
            
        } catch (SQLException ex) {
            System.out.println("Erro ao listar produtos: " + ex.getMessage());
        }
        
        return produtos;
    }
}
