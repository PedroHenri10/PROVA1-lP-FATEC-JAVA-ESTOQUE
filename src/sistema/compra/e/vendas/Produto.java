/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.compra.e.vendas;

/**
 *
 * @author 2830482411031
 */
public class Produto {
    private int cod_produto;
    private String nome;
    private String descricao;
    private float preco_venda;
    private int qtd_estoque;

    public int getCod_Produto() {
        return cod_produto;
    }

    public void setCod_Produto(int cod_produto) {
        this.cod_produto = cod_produto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getPreco_venda() {
        return preco_venda;
    }

    public void setPreco_venda(float preco_venda) {
        this.preco_venda = preco_venda;
    }

    public int getQtd_estoque() {
        return qtd_estoque;
    }

    public void setQtd_estoque(int qtd_estoque) {
        this.qtd_estoque = qtd_estoque;
    }

    public Produto() {
    }

    public Produto(int cod_produto, String nome, String descricao, float preco_venda, int qtd_estoque) {
        this.cod_produto = cod_produto;
        this.nome = nome;
        this.descricao = descricao;
        this.preco_venda = preco_venda;
        this.qtd_estoque = qtd_estoque;
    }
     
}
