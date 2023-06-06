package org.example.entidades;

import org.example.produto.Carrinho;
import org.example.produto.Produto;
import org.example.repositorio.RepositorioLoja;

import java.util.ArrayList;

public class Comprador  extends  Entidades{
    Carrinho carrinho;
    public Comprador(String nome, String email, String senha, String cpf, String endereco, int ID) {
        super(nome, email, senha, cpf, endereco, ID);
        carrinho = new Carrinho();
    }

    public Comprador(String nome, String email, String senha, String cpf, String endereco, int ID, Carrinho carrinho) {
        super(nome, email, senha, cpf, endereco, ID);
        this.carrinho = carrinho;
    }

    public void finalizarCompras() throws Exception{
        if(carrinho.getProdutosPorLoja().size() == 0){
            throw new Exception("O carrinho está vazio");
        }
        for (int i = 0; i < carrinho.getProdutosPorLoja().size(); i++) {
            try{
                Loja auxLoja = RepositorioLoja.getLojaPorNome(carrinho.getProdutosPorLoja().get(i).getLoja());
                for(int j = 0; j < carrinho.getProdutosPorLoja().get(i).getListaProdutos().size(); j++){
                    Produto auxProduto = carrinho.getProdutosPorLoja().get(i).getListaProdutos().get(j).getProduto();
                    int auxQuantidade = carrinho.getProdutosPorLoja().get(i).getListaProdutos().get(j).getQuantidade();
                    auxLoja.getEstoque().removerPorNome(auxProduto.getNome(), auxQuantidade);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }
}
