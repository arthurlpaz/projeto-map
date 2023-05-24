package org.example.produto;

import java.util.ArrayList;

public class Pedido {
    ArrayList<MapProduto> produtos;
    double valorTotal;
    String status;

    public Pedido(ArrayList<MapProduto> produtos, String status) {
        this.produtos = produtos;
        this.status = status;

        this.valorTotal = calculaValorTotal();
    }

    private double calculaValorTotal(){
        double total = 0;
        for (MapProduto produto : produtos) {
            total += produto.getProduto().getValor();
        }
        return total;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
