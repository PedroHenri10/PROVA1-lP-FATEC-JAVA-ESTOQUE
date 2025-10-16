package sistema.compra.e.vendas.view;

import javax.swing.JOptionPane;
import sistema.compra.e.vendas.dao.ProdutoDAO;
import sistema.compra.e.vendas.entity.Produto;

public class AtualizarProduto extends javax.swing.JFrame {

    public AtualizarProduto() {
        initComponents();
        limparCampos();
    }
    
    private void limparCampos() {
        txtCodProduto.setText("");
        txtNome.setText("");
        txtDescricao.setText("");
        txtPrecoVenda.setText("");
        txtQtdEstoque.setText("");

        txtNome.setEditable(false);
        txtDescricao.setEditable(false);
        txtPrecoVenda.setEditable(false);
        txtQtdEstoque.setEditable(false);
        btnAtualizar.setEnabled(false);
    }
    
    private void preencherCampos(Produto produto) {
        txtNome.setText(produto.getNome());
        txtDescricao.setText(produto.getDescricao());
        txtPrecoVenda.setText(String.valueOf(produto.getPreco_venda()));
        txtQtdEstoque.setText(String.valueOf(produto.getQtd_estoque()));

        txtNome.setEditable(true);
        txtDescricao.setEditable(true);
        txtPrecoVenda.setEditable(true);
        txtQtdEstoque.setEditable(true);
        btnAtualizar.setEnabled(true);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCodProduto = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtPrecoVenda = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtQtdEstoque = new javax.swing.JTextField();
        btnAtualizar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Atualizar Produto");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLabel1.setText("Atualizar Produto");

        jLabel2.setText("Código do Produto:");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(evt -> btnBuscarActionPerformed(evt));

        jLabel3.setText("Nome:");

        jLabel4.setText("Descrição:");

        jLabel5.setText("Preço de Venda:");

        jLabel6.setText("Quantidade em Estoque:");

        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(evt -> btnAtualizarActionPerformed(evt));

        btnLimpar.setText("Limpar Campos");
        btnLimpar.addActionListener(evt -> btnLimparActionPerformed(evt));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAtualizar)
                        .addGap(18, 18, 18)
                        .addComponent(btnLimpar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtCodProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBuscar))
                            .addComponent(txtNome)
                            .addComponent(txtDescricao)
                            .addComponent(txtPrecoVenda)
                            .addComponent(txtQtdEstoque, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCodProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPrecoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtQtdEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAtualizar)
                    .addComponent(btnLimpar))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {
        if (txtCodProduto.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Informe o código do produto para buscar.");
            return;
        }
        try {
            int codProduto = Integer.parseInt(txtCodProduto.getText());
            ProdutoDAO dao = new ProdutoDAO();
            Produto produto = dao.getProduto(codProduto);

            if (produto != null) {
                preencherCampos(produto);
            } else {
                JOptionPane.showMessageDialog(this, "Produto não encontrado.");
                limparCampos();
                txtCodProduto.setEditable(true);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Código do produto inválido. Digite um número.");
            limparCampos();
        }
    }

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {
        if (txtCodProduto.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "É necessário buscar um produto antes de atualizar.");
            return;
        }
        
        try {
            Produto produto = new Produto();
            produto.setCod_Produto(Integer.parseInt(txtCodProduto.getText()));
            produto.setNome(txtNome.getText());
            produto.setDescricao(txtDescricao.getText());
            produto.setPreco_venda(Float.parseFloat(txtPrecoVenda.getText()));
            produto.setQtd_estoque(Integer.parseInt(txtQtdEstoque.getText()));

            ProdutoDAO dao = new ProdutoDAO();
            dao.editarProduto(produto);
            JOptionPane.showMessageDialog(this, "Produto atualizado com sucesso!");
            limparCampos();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Erro: valores numéricos inválidos.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao atualizar produto: " + e.getMessage());
        }
    }

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {
        limparCampos();
        txtCodProduto.setEditable(true);
    }

    // Declaração dos componentes
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtCodProduto;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtPrecoVenda;
    private javax.swing.JTextField txtQtdEstoque;
}
