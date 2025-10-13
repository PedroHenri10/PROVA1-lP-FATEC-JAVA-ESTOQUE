package sistema.compra.e.vendas.view;
 
import java.util.List;
import javax.swing.table.DefaultTableModel;
import sistema.compra.e.vendas.dao.NotaDAO;
import sistema.compra.e.vendas.entity.Nota;
 
public class RelatorioNotas extends javax.swing.JFrame {
 
    public RelatorioNotas() {
        initComponents();
        carregarTabelaTodasNotas();
    }
 
    private void carregarTabela(List<Nota> notas) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Código Nota");
        modelo.addColumn("Tipo");
        modelo.addColumn("Data");
        modelo.addColumn("Cód. Cliente");
        modelo.addColumn("Cód. Fornecedor");
 
        for (Nota n : notas) {
            modelo.addRow(new Object[]{
                n.getCod_nota(),
                n.getTipo(),
                n.getData(),
                n.getCod_cliente() == 0 ? "N/A" : n.getCod_cliente(),
                n.getCod_fornecedor() == 0 ? "N/A" : n.getCod_fornecedor()
            });
        }
        tblNotas.setModel(modelo);
    }
    
    private void carregarTabelaTodasNotas() {
        NotaDAO notaDAO = new NotaDAO();
        List<Nota> todasNotas = notaDAO.getNotas();
        carregarTabela(todasNotas);
    }
    
    private void carregarTabelaNotasEntrada() {
        NotaDAO notaDAO = new NotaDAO();
        List<Nota> notasEntrada = notaDAO.getNotasPorTipo("Entrada");
        carregarTabela(notasEntrada);
    }
    
    private void carregarTabelaNotasSaida() {
        NotaDAO notaDAO = new NotaDAO();
        List<Nota> notasSaida = notaDAO.getNotasPorTipo("Saida");
        carregarTabela(notasSaida);
    }
 
    @SuppressWarnings("unchecked")
    private void initComponents() {
 
        jLabel1 = new javax.swing.JLabel();
        btnEntrada = new javax.swing.JButton();
        btnSaida = new javax.swing.JButton();
        btnTodas = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNotas = new javax.swing.JTable();
 
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
 
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLabel1.setText("Relatório de Notas");
 
        btnEntrada.setText("Notas de Entrada");
        btnEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntradaActionPerformed(evt);
            }
        });
 
        btnSaida.setText("Notas de Saída");
        btnSaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaidaActionPerformed(evt);
            }
        });
 
        btnTodas.setText("Todas as Notas");
        btnTodas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTodasActionPerformed(evt);
            }
        });
 
        tblNotas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código Nota", "Tipo", "Data", "Cód. Cliente", "Cód. Fornecedor"
            }
        ));
        jScrollPane1.setViewportView(tblNotas);
 
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnEntrada)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSaida)
                                .addGap(18, 18, 18)
                                .addComponent(btnTodas)))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEntrada)
                    .addComponent(btnSaida)
                    .addComponent(btnTodas))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
 
        pack();
    }
 
    private void btnEntradaActionPerformed(java.awt.event.ActionEvent evt) {
        carregarTabelaNotasEntrada();
    }
 
    private void btnSaidaActionPerformed(java.awt.event.ActionEvent evt) {
        carregarTabelaNotasSaida();
    }
 
    private void btnTodasActionPerformed(java.awt.event.ActionEvent evt) {
        carregarTabelaTodasNotas();
    }
 
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RelatorioNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RelatorioNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RelatorioNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RelatorioNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RelatorioNotas().setVisible(true);
            }
        });
    }
 
    private javax.swing.JButton btnEntrada;
    private javax.swing.JButton btnSaida;
    private javax.swing.JButton btnTodas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblNotas;
}