package sistema.compra.e.vendas.view;

import sistema.compra.e.vendas.dao.ProdutoDAO;
import sistema.compra.e.vendas.entity.Produto;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import sistema.compra.e.vendas.SistemaCompraEvenda;

public class RelatorioProdutos extends javax.swing.JFrame {

    public RelatorioProdutos() {
        initComponents();
        preencherTabela();
    }

    private void preencherTabela() {
        ProdutoDAO dao = new ProdutoDAO();
        List<Produto> lista = dao.getProdutos();

        DefaultTableModel modelo = (DefaultTableModel) tblProdutos.getModel();
        modelo.setRowCount(0);

        for (Produto p : lista) {
            Object[] linha = {
                p.getCod_Produto(),
                p.getNome(),
                p.getDescricao(),
                p.getPreco_venda(),
                p.getQtd_estoque()
            };
            modelo.addRow(linha);
        }
    }

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
        new SistemaCompraEvenda().setVisible(true);
    }

    // ---- componentes ----
    private javax.swing.JButton btnVoltar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblProdutos;

    private void initComponents() {
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProdutos = new javax.swing.JTable();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Relatório de Produtos");

        tblProdutos.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] {"ID", "Nome", "Descrição", "Preço", "Qtd Estoque"}
        ) {
            public boolean isCellEditable(int row, int column) { return false; }
        });
        jScrollPane1.setViewportView(tblProdutos);

        btnVoltar.setText("Voltar ao Menu");
        btnVoltar.addActionListener(evt -> btnVoltarActionPerformed(evt));

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
