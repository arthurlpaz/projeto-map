package org.example.produto;

import java.util.ArrayList;

public class Carrinho {

    private ArrayList<MapLojaProduto> produtosPorLoja;
    private double valorTotal;

    public Carrinho(){
        produtosPorLoja = new ArrayList<>();
        valorTotal = 0;
    }

    public Carrinho(ArrayList<MapLojaProduto> produtosPorLoja, double valorTotal){
        this.produtosPorLoja = produtosPorLoja;
        this.valorTotal = valorTotal;
    }

    public void inserirNoCarrinho(String loja, Produto produto, int quantidade){
        for (MapLojaProduto mapLojaProduto : produtosPorLoja) {
            if (mapLojaProduto.getLoja().equals(loja)) {
                mapLojaProduto.inserirProduto(produto, quantidade);
                return;
            }
        }

        ArrayList<MapProduto> mapProdutos = new ArrayList<>();
        mapProdutos.add(new MapProduto(produto, quantidade));

        produtosPorLoja.add(new MapLojaProduto(loja, mapProdutos));
        valorTotal += produto.getValor() * quantidade;

    }

    public void removerDoCarrinho(String loja, Produto produto, int quantidade) throws Exception{
        for (MapLojaProduto mapLojaProduto : produtosPorLoja) {
            if (mapLojaProduto.getLoja().equals(loja)) {
                mapLojaProduto.removerProduto(produto.getNome(), quantidade);
                valorTotal = calculaValorTotal();
                return;
            }
        }

        throw new Exception("Nenhum produto da loja encontrada no carrinho");
    }

    public double calculaValorTotal(){
        double total = 0;

        for (MapLojaProduto produto : produtosPorLoja) {
            total += (produto.getTotalLoja());
        }

        return total;
    }

    public ArrayList<MapLojaProduto> getProdutosPorLoja() {
        return produtosPorLoja;
    }

    public void setProdutosPorLoja(ArrayList<MapLojaProduto> produtosPorLoja) {
        this.produtosPorLoja = produtosPorLoja;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
