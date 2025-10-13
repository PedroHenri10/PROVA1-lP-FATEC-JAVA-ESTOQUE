/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.compra.e.vendas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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

        public List<Produto> getProdutos() {
            String sql = "SELECT * FROM produto";
            List<Produto> lista = new ArrayList<>();
            try (PreparedStatement stmt = conn.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Produto p = new Produto();
                    p.setCod_Produto(rs.getInt("cod_produto"));
                    p.setNome(rs.getString("nome"));
                    p.setDescricao(rs.getString("descricao"));
                    p.setPreco_venda(rs.getFloat("preco_venda"));
                    p.setQtd_estoque(rs.getInt("qtd_estoque"));
                    lista.add(p);
                }
            } catch (SQLException e) {
                System.out.println("Erro ao listar produtos: " + e.getMessage());
                return null;
            }
            return lista;
    }
        
        public Produto getProduto(int id) {
            String sql = "SELECT * FROM produto WHERE cod_produto = ?";
            try {
                PreparedStatement stmt = conn.prepareStatement(sql, 
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);

                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    Produto p = new Produto();
                    p.setCod_Produto(rs.getInt("cod_produto"));
                    p.setNome(rs.getString("nome"));
                    p.setDescricao(rs.getString("descricao"));
                    p.setPreco_venda(rs.getFloat("preco_venda"));
                    p.setQtd_estoque(rs.getInt("qtd_estoque"));
                    return p;
                }
            } catch (SQLException ex) {
                System.out.println("Erro ao consultar produto: " + ex.getMessage());
            }
            return null;
        }

        public void editarProduto(Produto p) {
            String sql = "UPDATE produto SET nome=?, descricao=?, preco_venda=?, qtd_estoque=? WHERE cod_produto=?";
            try {
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, p.getNome());
                stmt.setString(2, p.getDescricao());
                stmt.setFloat(3, p.getPreco_venda());
                stmt.setInt(4, p.getQtd_estoque());
                stmt.setInt(5, p.getCod_Produto());
                stmt.executeUpdate();
                System.out.println("Produto atualizado com sucesso!");
            } catch (SQLException ex) {
                System.out.println("Erro ao atualizar produto: " + ex.getMessage());
            }
    }

        public void excluirProduto(int id) {
            String sql = "DELETE FROM produto WHERE cod_produto=?";
            try {
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, id);
                stmt.executeUpdate();
                System.out.println("Produto excluído com sucesso!");
            } catch (SQLException ex) {
                System.out.println("Erro ao excluir produto: " + ex.getMessage());
        }
}

}
