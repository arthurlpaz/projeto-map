package org.example.entidades;

import org.example.produto.Estoque;
import org.example.produto.Pedidos;

import java.util.ArrayList;

public class Loja  extends  Entidades {
    private Estoque estoque;
    ArrayList<Pedidos> historicoDeVendas;

    public Loja(String nome, String email, String senha, String cpf, String endereco, int ID, Estoque estoque) {
        super(nome, email, senha, cpf, endereco, ID);
        this.estoque = estoque;
        this.historicoDeVendas = new ArrayList<>();
    }

    public Loja(String nome, String email, String senha, String cpf, String endereco, int ID, Estoque estoque, ArrayList<Pedidos> historicoDeVendas) {
        super(nome, email, senha, cpf, endereco, ID);
        this.estoque = estoque;
        this.historicoDeVendas = historicoDeVendas;
    }

    public void imprimirVendas(){
        System.out.println("--------------------------------------------------------------");
        System.out.println("HISTORICO DE VENDAS:");
        for (int i = 0; i < this.historicoDeVendas.size(); i++) {
            this.historicoDeVendas.get(i).imprimirPedidos();
        }
        System.out.println("--------------------------------------------------------------");
    }

    public Estoque getEstoque() {
        if (estoque == null) {
            estoque = new Estoque();
        }
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    public ArrayList<Pedidos> getHistoricoDeVendas() {
        if (historicoDeVendas == null) {
            historicoDeVendas = new ArrayList<>();
        }
        return historicoDeVendas;
    }

    public void setHistoricoDeVendas(ArrayList<Pedidos> historicoDeVendas) {
        this.historicoDeVendas = historicoDeVendas;
    }
}
