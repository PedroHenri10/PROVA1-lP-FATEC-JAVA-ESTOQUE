package sistema.compra.e.vendas.view;

import sistema.compra.e.vendas.dao.FornecedorDAO;
import sistema.compra.e.vendas.entity.Fornecedor;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import sistema.compra.e.vendas.SistemaCompraEvenda;

public class RelatorioFornecedores extends javax.swing.JFrame {

    public RelatorioFornecedores() {
        initComponents();
        preencherTabela();
    }

    private void preencherTabela() {
        FornecedorDAO dao = new FornecedorDAO();
        List<Fornecedor> lista = dao.getFornecedores();

        DefaultTableModel modelo = (DefaultTableModel) tblFornecedores.getModel();
        modelo.setRowCount(0);

        for (Fornecedor f : lista) {
            Object[] linha = {
                f.getCod_fornecedor(),
                f.getNome(),
                f.getNome_fantasia(),
                f.getCnpj(),
                f.getEndereco(),
                f.getEmail(),
                f.getTelefone()
            };
            modelo.addRow(linha);
        }
    }

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
        new SistemaCompraEvenda().setVisible(true);
    }

    // --- initComponents gerado pelo NetBeans ---
    private javax.swing.JButton btnVoltar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblFornecedores;

    private void initComponents() {
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFornecedores = new javax.swing.JTable();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Relatório de Fornecedores");

        tblFornecedores.setModel(new DefaultTableModel(
            new Object [][] {},
            new String [] {"ID", "Nome", "Nome Fantasia", "CNPJ", "Endereço", "Email", "Telefone"}
        ) {
            public boolean isCellEditable(int row, int column) { return false; }
        });
        jScrollPane1.setViewportView(tblFornecedores);

        btnVoltar.setText("Voltar ao Menu");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(10,10,10)
                .addComponent(btnVoltar)
                .addContainerGap(10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createSequentialGroup()
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(8)
            .addComponent(btnVoltar)
            .addGap(8)
        );

        pack();
        setLocationRelativeTo(null);
    }
}
