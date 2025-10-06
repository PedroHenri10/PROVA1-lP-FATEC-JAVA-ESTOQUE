/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.compra.e.vendas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
        String sql = "INSERT INTO cliente (cod_Fornecedor, nome, nome_fantasia, cnpj, endereco, email, telefone) VALUES (?,?,?,?,?,?,?);";
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
    
}
