/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.compra.e.vendas.entity;

/**
 *
 * @author 2830482411031
 */
public class ItemNota {
    
    private int cod_item;
    private int cod_nota;
    private int cod_produto;
    private int quantidade;
    private float preco_unitario;

    public int getCod_item() {
        return cod_item;
    }

    public void setCod_item(int cod_item) {
        this.cod_item = cod_item;
    }

    public int getCod_nota() {
        return cod_nota;
    }

    public void setCod_nota(int cod_nota) {
        this.cod_nota = cod_nota;
    }

    public int getCod_produto() {
        return cod_produto;
    }

    public void setCod_produto(int cod_produto) {
        this.cod_produto = cod_produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getPreco_unitario() {
        return preco_unitario;
    }

    public void setPreco_unitario(float preco_unitario) {
        this.preco_unitario = preco_unitario;
    }

    public ItemNota(int cod_item, int cod_nota, int cod_produto, int quantidade, float preco_unitario) {
        this.cod_item = cod_item;
        this.cod_nota = cod_nota;
        this.cod_produto = cod_produto;
        this.quantidade = quantidade;
        this.preco_unitario = preco_unitario;
    }
    
    public ItemNota(){
        
    }
}
