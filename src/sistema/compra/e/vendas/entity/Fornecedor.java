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
public class Fornecedor {
    private int cod_fornecedor;
    private String nome;
    private String nome_fantasia;
    private String cnpj;
    private String endereco;
    private String email;
    private String telefone;

    public int getCod_fornecedor() {
        return cod_fornecedor;
    }

    public void setCod_fornecedor(int cod_fornecedor) {
        this.cod_fornecedor = cod_fornecedor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome_fantasia() {
        return nome_fantasia;
    }

    public void setNome_fantasia(String nome_fantasia) {
        this.nome_fantasia = nome_fantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Fornecedor(int cod_fornecedor, String nome, String nome_fantasia, String cnpj, String endereco, String email, String telefone) {
        this.cod_fornecedor = cod_fornecedor;
        this.nome = nome;
        this.nome_fantasia = nome_fantasia;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
    }
    
    
    public Fornecedor(){
        
    }
}
