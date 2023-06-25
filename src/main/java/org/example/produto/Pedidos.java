package org.example.produto;

import java.util.ArrayList;

public class Pedidos {
    private ArrayList<MapProduto> produtos;

    private String nomeUsuario;
    private String nomeLoja;

    private boolean avaliado;

    public Pedidos() {
        this.produtos = new ArrayList<>();
        this.nomeUsuario = "";
        this.nomeLoja = "";
        this.avaliado = false;
    }
    
    public Pedidos(ArrayList<MapProduto> produtos, String nomeUsuario, String nomeLoja, boolean avaliado) {
        this.produtos = produtos;
        this.nomeUsuario = nomeUsuario;
        this.nomeLoja = nomeLoja;
        this.avaliado = avaliado;
    }

    public void imprimirPedidos(){
        System.out.println("Loja: " + this.nomeLoja);
        System.out.println("Usuario: " + this.nomeUsuario);
        for (int i = 0; i < produtos.size(); i++) {
            System.out.println(produtos.get(i));
        }
        System.out.println("Pedido avaliado: " + this.avaliado);
    }

    public ArrayList<MapProduto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<MapProduto> produtos) {
        this.produtos = produtos;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getNomeLoja() {
        return nomeLoja;
    }

    public void setNomeLoja(String nomeLoja) {
        this.nomeLoja = nomeLoja;
    }

    public boolean getAvaliado() {
        return avaliado;
    }

    public void setAvaliado(boolean avaliado) {
        this.avaliado = avaliado;
    }
}
