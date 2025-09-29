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
public class Cliente {
    
    private int cod_Cliente;
    private String nome;
    private String endereco;
    private String email;
    private String telefone;

    public int getCod_Cliente() {
        return cod_Cliente;
    }

    public void setCod_Cliente(int cod_Cliente) {
        this.cod_Cliente = cod_Cliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public Cliente(int cod_Cliente, String nome, String endereco, String email, String telefone) {
        this.cod_Cliente = cod_Cliente;
        this.nome = nome;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
    }
    
    public Cliente(){
        
    }
}
