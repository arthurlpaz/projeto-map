package org.example.produto;

import java.util.ArrayList;

public class Pedidos {
    private ArrayList<MapProduto> produtos;

    private String nomeUsuario;
    private String nomeLoja;

    public Pedidos() {
        this.produtos = new ArrayList<>();
        this.nomeUsuario = "";
        this.nomeLoja = "";
    }
    
    public Pedidos(ArrayList<MapProduto> produtos, String nomeUsuario, String nomeLoja) {
        this.produtos = produtos;
        this.nomeUsuario = nomeUsuario;
        this.nomeLoja = nomeLoja;
    }
    public void imprimirPedidos(){
        System.out.println("Loja: " + this.nomeLoja);
        System.out.println("Usuario: " + this.nomeUsuario);
        for (int i = 0; i < produtos.size(); i++) {
            System.out.println(produtos.get(i));
        }
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

}
