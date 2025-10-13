/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.compra.e.vendas.dao;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        String sql = "INSERT INTO cliente (cod_Cliente, nome, endereco, email, telefone) VALUES (?,?,?,?,?);";
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, cliente.getCod_Cliente());
            stmt.setString(2, cliente.getNome());
            stmt.setString(3, cliente.getEndereco());
            stmt.setString(4, cliente.getEmail());
            stmt.setString(5, cliente.getTelefone());
            
            stmt.execute();
        }catch(SQLException ex){
            System.out.println("Erro ao inserir cliente: " +ex.getMessage());
        }
    }

    public List<Cliente> getClientes() {
        String sql = "SELECT * FROM cliente";
        List<Cliente> lista = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setCod_Cliente(rs.getInt("cod_Cliente"));
                c.setNome(rs.getString("nome"));
                c.setEndereco(rs.getString("endereco"));
                c.setEmail(rs.getString("email"));
                c.setTelefone(rs.getString("telefone"));
                lista.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar clientes: " + e.getMessage());
            return null;
        }
        return lista;
    }

        public Cliente getCliente(int id) {
        String sql = "SELECT * FROM cliente WHERE cod_cliente = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql, 
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Cliente c = new Cliente();
                c.setCod_Cliente(rs.getInt("cod_cliente"));
                c.setNome(rs.getString("nome"));
                c.setEndereco(rs.getString("endereco"));
                c.setEmail(rs.getString("email"));
                c.setTelefone(rs.getString("telefone"));
                return c;
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar cliente: " + ex.getMessage());
        }
        return null;
    }

    public void editarCliente(Cliente cliente) {
    String sql = "UPDATE cliente SET nome=?, endereco=?, email=?, telefone=? WHERE cod_cliente=?";
    try {
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, cliente.getNome());
        stmt.setString(2, cliente.getEndereco());
        stmt.setString(3, cliente.getEmail());
        stmt.setString(4, cliente.getTelefone());
        stmt.setInt(5, cliente.getCod_Cliente());
        stmt.executeUpdate();
        System.out.println("Cliente atualizado com sucesso!");
    } catch (SQLException ex) {
        System.out.println("Erro ao atualizar cliente: " + ex.getMessage());
    }
}

public void excluirCliente(int id) {
    String sql = "DELETE FROM cliente WHERE cod_cliente=?";
    try {
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();
        System.out.println("Cliente excluído com sucesso!");
    } catch (SQLException ex) {
        System.out.println("Erro ao excluir cliente: " + ex.getMessage());
    }
}
    
}
