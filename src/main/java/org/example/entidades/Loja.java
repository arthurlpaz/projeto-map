package org.example.entidades;

import org.example.produto.Estoque;

public class Loja  extends  Entidades{
    private Estoque estoque;

    public Loja(String nome, String email, String senha, String cpf, String endereco, int ID, Estoque estoque) {
        super(nome, email, senha, cpf, endereco, ID);
        this.estoque = estoque;
    }

    public Estoque getEstoque() {
        if(estoque == null){
            estoque = new Estoque();
        }
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }
}
