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
import sistema.compra.e.vendas.entity.Fornecedor;
import sistema.compra.e.vendas.util.Conexao;

/**
 *
 * @author 2830482411031
 */
public class FornecedorDAO {
    private Conexao conexao;
    private Connection conn;
    
    public FornecedorDAO(){
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    
    public void inserirFornecedor(Fornecedor fornecedor){
        String sql = "INSERT INTO fornecedor (cod_fornecedor, nome, nome_fantasia, cnpj, endereco, email, telefone) VALUES (?,?,?,?,?,?,?);";
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, fornecedor.getCod_fornecedor());
            stmt.setString(2, fornecedor.getNome());
            stmt.setString(3, fornecedor.getNome_fantasia());
            stmt.setString(4, fornecedor.getCnpj());            
            stmt.setString(5, fornecedor.getEndereco());
            stmt.setString(6, fornecedor.getEmail());
            stmt.setString(7, fornecedor.getTelefone());
            stmt.execute();            
        }catch(SQLException ex){
            System.out.println("Erro ao inserir Fornecedor: " +ex.getMessage());
        }
    }

    public List<Fornecedor> getFornecedores() {
        String sql = "SELECT * FROM fornecedor";
        List<Fornecedor> lista = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Fornecedor f = new Fornecedor();
                f.setCod_fornecedor(rs.getInt("cod_fornecedor"));
                f.setNome(rs.getString("nome"));
                f.setNome_fantasia(rs.getString("nome_fantasia"));
                f.setCnpj(rs.getString("cnpj"));
                f.setEndereco(rs.getString("endereco"));
                f.setEmail(rs.getString("email"));
                f.setTelefone(rs.getString("telefone"));
                lista.add(f);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar fornecedores: " + e.getMessage());
            return null;
        }
        return lista;
    }

        public Fornecedor getFornecedor(int id) {
        String sql = "SELECT * FROM fornecedor WHERE cod_fornecedor = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql, 
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Fornecedor f = new Fornecedor();
                f.setCod_fornecedor(rs.getInt("cod_fornecedor"));
                f.setNome(rs.getString("nome"));
                f.setNome_fantasia(rs.getString("nome_fantasia"));
                f.setCnpj(rs.getString("cnpj"));
                f.setEndereco(rs.getString("endereco"));
                f.setEmail(rs.getString("email"));
                f.setTelefone(rs.getString("telefone"));
                return f;
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar fornecedor: " + ex.getMessage());
        }
        return null;
    }

}
