package org.example.produto;

import java.util.ArrayList;

public class MapLojaProduto {
    private String loja;
    private ArrayList<MapProduto> listaProdutos;
    private double totalLoja;

    public MapLojaProduto(String loja){
        this.loja = loja;
        listaProdutos = new ArrayList<>();
        totalLoja = 0;
    }

    public MapLojaProduto(String loja, ArrayList<MapProduto> listaProdutos){
        this.loja = loja;
        this.listaProdutos = listaProdutos;
        totalLoja = calculaTotalLoja();
    }

    public String getLoja() {
        return loja;
    }

    public void setLoja(String loja) {
        this.loja = loja;
    }

    public ArrayList<MapProduto> getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(ArrayList<MapProduto> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    public double calculaTotalLoja(){
        double total = 0;

        for (MapProduto listaProduto : listaProdutos) {
            total += listaProduto.getProduto().getValor() * listaProduto.getQuantidade();
        }

        return  total;
    }

    public void inserirProduto(Produto produto, int quantidade){
        for (MapProduto listaProduto : listaProdutos) {
            if (listaProduto.getProduto().equals(produto)) {
                listaProduto.setQuantidade(listaProduto.getQuantidade() + quantidade);
                return;
            }
        }
        listaProdutos.add(new MapProduto(produto, quantidade));
    }

    public void removerProduto(String produto, int quantidade) throws Exception{
        for (int i = 0 ; i < listaProdutos.size(); i++) {
            if (listaProdutos.get(i).getProduto().getNome().equals(produto)) {
                if(listaProdutos.get(i).getQuantidade() > quantidade){
                    listaProdutos.get(i).setQuantidade(listaProdutos.get(i).getQuantidade() - quantidade);
                }else if (listaProdutos.get(i).getQuantidade() == quantidade){
                    listaProdutos.remove(i);
                }else {
                    throw new Exception("quantidade não é suficiente");
                }
                return;
            }
        }
        throw new Exception("produto não encontrado");
    }

    public double getTotalLoja() {
        return totalLoja;
    }

    public void setTotalLoja(double totalLoja) {
        this.totalLoja = totalLoja;
    }
}
