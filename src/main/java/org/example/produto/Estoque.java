package org.example.produto;

import java.util.ArrayList;

public class Estoque {
    ArrayList<MapProduto> estoque;

    int ID;

    public Estoque(){
        estoque = new ArrayList<MapProduto>();
        ID = 1;
    }

    public void inserir(String nome, double valor, String tipo, String marca, String descricao, int quantidade){
        estoque.add(new MapProduto(new Produto(nome, valor, tipo, marca, descricao, ID), quantidade));
    }
    public void inserir(Produto produto){
        estoque.add(new MapProduto(produto));
    }

    public void remover(int ID_produto_a_remover){
        for (int i = 0; i < estoque.size(); i++) {
            if(estoque.get(i).getProduto().getID() == ID_produto_a_remover){
                estoque.remove(i);
                break;
            };
        }
    }
}
