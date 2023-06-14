package org.example.entidades;

import org.example.produto.*;
import org.example.repositorio.RepositorioLoja;

import java.util.ArrayList;

public class Comprador extends Entidades{
    Carrinho carrinho;
    ArrayList<Pedidos> historicoDeCompras;
    public Comprador(String nome, String email, String senha, String cpf, String endereco, int ID) {
        super(nome, email, senha, cpf, endereco, ID);
        carrinho = new Carrinho();
        historicoDeCompras = new ArrayList<>();
    }

    public Comprador(String nome, String email, String senha, String cpf, String endereco, int ID, Carrinho carrinho, ArrayList<Pedidos> historicoDeCompras) {
        super(nome, email, senha, cpf, endereco, ID);
        this.carrinho = carrinho;
        this.historicoDeCompras = historicoDeCompras;
    }

    //finaliza a compra esvaziando o carrinho e tirando os itens do estoque das lojas
    public void finalizarCompras() throws Exception{
        if(carrinho.getProdutosPorLoja().size() == 0){
            throw new Exception("O carrinho está vazio");
        }
        for (int i = 0; i < carrinho.getProdutosPorLoja().size(); i++) {
            try{
                Loja auxLoja = RepositorioLoja.getLojaPorNome(carrinho.getProdutosPorLoja().get(0).getLoja());

                ArrayList<MapProduto> produtos = new ArrayList<>();

                for(int j = 0; j < carrinho.getProdutosPorLoja().get(0).getListaProdutos().size(); j++){
                    Produto auxProduto = carrinho.getProdutosPorLoja().get(0).getListaProdutos().get(j).getProduto();
                    int auxQuantidade = carrinho.getProdutosPorLoja().get(0).getListaProdutos().get(j).getQuantidade();


                    auxLoja.getEstoque().removerPorNome(auxProduto.getNome(), auxQuantidade);
                    produtos.add(carrinho.getProdutosPorLoja().get(0).getListaProdutos().get(j));

                    carrinho.removerDoCarrinho(carrinho.getProdutosPorLoja().get(0).getLoja(), auxProduto, auxQuantidade);
                    i--;
                }
                auxLoja.getHistoricoDeVendas().add(new Pedidos(produtos, auxLoja.getNome(), this.getNome()));
                this.getHistoricoDeCompras().add(new Pedidos(produtos, auxLoja.getNome(), this.getNome()));

            }catch (Exception e){
                System.out.println(e);
            }
        }
    }



    public Carrinho getCarrinho() {
        if(carrinho == null){
            carrinho = new Carrinho();
        }
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public ArrayList<Pedidos> getHistoricoDeCompras() {
        return historicoDeCompras;
    }

    public void setHistoricoDeCompras(ArrayList<Pedidos> historicoDeCompras) {
        this.historicoDeCompras = historicoDeCompras;
    }
}
