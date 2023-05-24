package org.example.produto;

import java.util.ArrayList;

public class Carrinho {
    ArrayList<MapProduto> produtos;
    double valorTotal;

    public Carrinho() {
        this.produtos = new ArrayList<>();
        this.valorTotal = 0;
    }

    public void adicionaAoCarrinho(Produto produto, int quantidade){
        //busca o produto no carrinho, caso ja esteja apenas aumenta a quantidade, caso contrario adiciona o produto no carrinho
        for (MapProduto mapProduto : produtos) {
            if (mapProduto.getProduto().getID() == produto.getID()) {
                mapProduto.setQuantidade(mapProduto.getQuantidade() + quantidade);
                valorTotal += mapProduto.getProduto().getValor() * quantidade;
                return;
            }
        }

        produtos.add(new MapProduto(produto, quantidade));
        valorTotal += produto.getValor() * quantidade;
    }
    public void removeDoCarrinho(Produto produto, int quantidade){
        //busca o produto no carrinho e remove a quantidade especificada
        for (int i = 0; i < produtos.size(); i++) {
            if(produtos.get(i).getProduto().getID() == produto.getID()){
                //se a quantidade de produtos a ser removida for maior do que as que estão no carrinho, remover todas as do carrinho
                //caso o contrario remover o numero especificado
                if(produtos.get(i).getQuantidade() < quantidade){
                    valorTotal -= produto.getValor() * produtos.get(i).getQuantidade();
                    produtos.remove(i);
                }else{
                    valorTotal -= produto.getValor() * quantidade;
                    produtos.get(i).setQuantidade(produtos.get(i).getQuantidade() - quantidade);
                }
                return;
            }
        }
    }

    public void clear(){
        produtos.clear();
        valorTotal = 0;
    }

    public ArrayList<MapProduto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<MapProduto> produtos) {
        this.produtos = produtos;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
