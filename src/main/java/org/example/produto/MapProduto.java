package org.example.produto;

public class MapProduto {
    Produto produto;
    int quantidade;

    public MapProduto(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public MapProduto(Produto produto) {
        this.produto = produto;
        this.quantidade = 0;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
