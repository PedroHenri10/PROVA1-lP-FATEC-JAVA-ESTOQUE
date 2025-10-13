/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema.compra.e.vendas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import sistema.compra.e.vendas.entity.Nota;
import sistema.compra.e.vendas.util.Conexao;

/**
 *
 * @author pedro henrique
 */
public class NotaDAO {
    
    private Conexao conexao;
    private Connection conn;
    
    public NotaDAO(){
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    
    public int inserirNota(Nota nota){
            String sql = "INSERT INTO nota (tipo, data, cod_cliente, cod_fornecedor) VALUES (?, ?, ?, ?)";
            int idGerado = -1;
 
            try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, nota.getTipo());
                ps.setString(2, nota.getData());

                if (nota.getCod_cliente() != 0)
                    ps.setInt(3, nota.getCod_cliente());
                else
                    ps.setNull(3, java.sql.Types.INTEGER);

                if (nota.getCod_fornecedor() != 0)
                    ps.setInt(4, nota.getCod_fornecedor());
                else
                    ps.setNull(4, java.sql.Types.INTEGER);

                ps.executeUpdate();

                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    idGerado = rs.getInt(1);
                    nota.setCod_nota(idGerado);
                }

                System.out.println("Nota inserida com sucesso! ID: " + idGerado);

            } catch (SQLException e) {
                System.out.println("Erro ao inserir nota: " + e.getMessage());
            }

            return idGerado;
        }
    
        public List<Nota> getNotas() {
            String sql = "SELECT * FROM nota";
            List<Nota> lista = new ArrayList<>();
            try (PreparedStatement stmt = conn.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Nota n = new Nota();
                    n.setCod_nota(rs.getInt("cod_nota"));
                    n.setTipo(rs.getString("tipo"));
                    n.setData(rs.getString("data")); 
                    n.setCod_cliente(rs.getInt("cod_cliente"));
                    n.setCod_fornecedor(rs.getInt("cod_fornecedor"));
                    lista.add(n);
                }
            } catch (SQLException e) {
                System.out.println("Erro ao listar notas: " + e.getMessage());
                return null;
            }
            return lista;
        }

        public Nota getNota(int id) {
            String sql = "SELECT n.*, c.nome AS nome_cliente, f.nome AS nome_fornecedor " +
                         "FROM nota n " +
                         "LEFT JOIN cliente c ON n.cod_cliente = c.cod_cliente " +
                         "LEFT JOIN fornecedor f ON n.cod_fornecedor = f.cod_fornecedor " +
                         "WHERE n.cod_nota = ?";
            try {
                PreparedStatement stmt = conn.prepareStatement(sql, 
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);

                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    Nota n = new Nota();
                    n.setCod_nota(rs.getInt("cod_nota"));
                    n.setTipo(rs.getString("tipo"));
                    n.setData(rs.getString("data"));
                    n.setCod_cliente(rs.getInt("cod_cliente"));
                    n.setCod_fornecedor(rs.getInt("cod_fornecedor"));

                    return n;
                }
            } catch (SQLException ex) {
                System.out.println("Erro ao consultar nota: " + ex.getMessage());
            }
            return null;
        }
    
      public void editarNota(Nota n) {
        String sql = "UPDATE nota SET tipo=?, data=?, cod_cliente=?, cod_fornecedor=? WHERE cod_nota=?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, n.getTipo());
            stmt.setString(2, n.getData());
            stmt.setInt(3, n.getCod_cliente());
            stmt.setInt(4, n.getCod_fornecedor());
            stmt.setInt(5, n.getCod_nota());
            stmt.executeUpdate();
            System.out.println("Nota atualizada com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar nota: " + ex.getMessage());
        }
    }

    public void excluirNota(int id) {
        String sql = "DELETE FROM nota WHERE cod_nota=?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Nota excluída com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir nota: " + ex.getMessage());
        }
    }
    
}
