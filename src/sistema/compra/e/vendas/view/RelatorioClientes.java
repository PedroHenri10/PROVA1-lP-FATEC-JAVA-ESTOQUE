package sistema.compra.e.vendas.view;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import sistema.compra.e.vendas.SistemaCompraEvenda;
import sistema.compra.e.vendas.dao.ClienteDAO;
import sistema.compra.e.vendas.entity.Cliente;

public class RelatorioClientes extends javax.swing.JFrame {

    public RelatorioClientes() {
        initComponents();
        preencherTabela();
    }

    private void preencherTabela() {
        ClienteDAO dao = new ClienteDAO();
        List<Cliente> lista = dao.getClientes();

        DefaultTableModel modelo = (DefaultTableModel) tblClientes.getModel();
        modelo.setRowCount(0); 

        for (Cliente c : lista) {
            Object[] linha = {
                c.getCod_Cliente(),
                c.getNome(),
                c.getEndereco(),
                c.getEmail(),
                c.getTelefone()
            };
            modelo.addRow(linha);
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Relatório de Clientes");

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "Código", "Nome", "Endereço", "Email", "Telefone"
            }
        ));
        jScrollPane1.setViewportView(tblClientes);

        btnVoltar.addActionListener(evt -> {
            this.dispose();
            new SistemaCompraEvenda().setVisible(true);
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnVoltar)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVoltar)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }

    private javax.swing.JButton btnVoltar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblClientes;
}
