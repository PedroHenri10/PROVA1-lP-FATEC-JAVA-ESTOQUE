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
public class Nota {
    
    private int cod_nota;
    private String tipo;
    private String data;
    private int cod_cliente;
    private int cod_fornecedor;

    public int getCod_nota() {
        return cod_nota;
    }

    public void setCod_nota(int cod_nota) {
        this.cod_nota = cod_nota;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(int cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    public int getCod_fornecedor() {
        return cod_fornecedor;
    }

    public void setCod_fornecedor(int cod_fornecedor) {
        this.cod_fornecedor = cod_fornecedor;
    }

    public Nota(int cod_nota, String tipo, String data, int cod_cliente) {
        this.cod_nota = cod_nota;
        this.tipo = tipo;
        this.data = data;
        this.cod_cliente = cod_cliente;
    }

    public Nota() {
      
    }
    
}
