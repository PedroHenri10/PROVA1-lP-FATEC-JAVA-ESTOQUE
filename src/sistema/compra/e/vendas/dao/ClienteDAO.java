/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.compra.e.vendas.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import sistema.compra.e.vendas.entity.Cliente;
import sistema.compra.e.vendas.util.Conexao;
/**
 *
 * @author 2830482411031
 */
public class ClienteDAO {
    private Conexao conexao;
    private Connection conn;
    
    public ClienteDAO(){
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    
    public void inserirCliente(Cliente cliente){
        String sql = "INSERT INTO cliente (cod_Cliente, nome, endereco, email, telefone) VALUES (?,?,?,?);";
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, cliente.getCod_Cliente());
            stmt.setString(2, cliente.getNome());
            stmt.setString(3, cliente.getEndereco());
            stmt.setString(4, cliente.getEmail());
            stmt.setString(5, cliente.getTelefone());            
        }catch(SQLException ex){
            System.out.println("Erro ao inserir cliente: " +ex.getMessage());
        }
    }
    
}
