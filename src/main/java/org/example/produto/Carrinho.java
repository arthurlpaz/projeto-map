package org.example.produto;

import org.example.repositorio.RepositorioLoja;

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

    public void inserirNoCarrinho(String loja, Produto produto, int quantidade) throws Exception{
        //verifica se ja possuem produtos da loja selecionada
        for (MapLojaProduto mapLojaProduto : produtosPorLoja) {
            if (mapLojaProduto.getLoja().equals(loja)) {
                mapLojaProduto.inserirProduto(produto, quantidade);
                return;
            }
        }

        //adiciona loja à lista caso ela não esteja
        ArrayList<MapProduto> mapProdutos = new ArrayList<>();
        mapProdutos.add(new MapProduto(produto, quantidade));

        produtosPorLoja.add(new MapLojaProduto(loja, mapProdutos));
        valorTotal += produto.getValor() * quantidade;
    }

    public void removerDoCarrinho(String loja, Produto produto, int quantidade) throws Exception{
        for (int i = 0; i < produtosPorLoja.size(); i++) {
            if(produtosPorLoja.get(i).getLoja().equals(loja)){
                produtosPorLoja.get(i).removerProduto(produto.getNome(), quantidade);
                System.out.println("total = " + calculaValorTotal());
                if(produtosPorLoja.get(i).getListaProdutos().size() == 0){
                    produtosPorLoja.remove(i);
                    return;
                }
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

    public void listarItemsCarrinho() throws Exception{
        if (produtosPorLoja.size() == 0){
            throw new Exception("O usuario nao possui nenhum item no carrinho");
        }

        for (int i = 0; i < produtosPorLoja.size(); i++) {
            System.out.println(produtosPorLoja.get(i).getLoja());
            for (int j = 0; j < produtosPorLoja.get(i).getListaProdutos().size(); j++) {
                System.out.println(produtosPorLoja.get(i).getListaProdutos().get(j));
            }
        }

        System.out.println("Valor total: " + this.valorTotal);
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
