package org.example.entidades;

import org.example.produto.*;
import org.example.repositorio.RepositorioLoja;
import org.example.utils.Avaliacao;

import java.util.ArrayList;
import java.util.Scanner;

public class Comprador extends Entidades{
    Carrinho carrinho;
    ArrayList<Pedidos> historicoDeCompras;
    
    public Comprador(String nome, String email, String senha, String cpf, String endereco, int ID) {
        super(nome, email, senha, cpf, endereco, ID);
        carrinho = new Carrinho();
        historicoDeCompras = new ArrayList<>();
    }

    public Comprador(String nome, String email, String senha, String cpf, String endereco, int ID, ArrayList<Avaliacao> avaliacoes, Carrinho carrinho, ArrayList<Pedidos> historicoDeCompras) {
        super(nome, email, senha, cpf, endereco, ID, avaliacoes);
        this.carrinho = carrinho;
        this.historicoDeCompras = historicoDeCompras;
    }

    //finaliza a compra esvaziando o carrinho e tirando os itens do estoque das lojas
    public void finalizarCompras() throws Exception{
        if(carrinho.getProdutosPorLoja().size() == 0){
            throw new Exception("O carrinho está vazio");
        }

        while(carrinho.getProdutosPorLoja().size() != 0){
            if (super.getMediaAvaliacoes() > 4){
                System.out.println("Parabéns, você ganhou frete grátis");
            }
            
            try{
                Loja auxLoja = RepositorioLoja.getLojaPorNome(carrinho.getProdutosPorLoja().get(0).getLoja());
                ArrayList<MapProduto> produtos = new ArrayList<>();

                while(carrinho.getProdutosPorLoja().size() != 0 && carrinho.getProdutosPorLoja().get(0).getListaProdutos().size() != 0 && carrinho.getProdutosPorLoja().get(0).getLoja().equals(auxLoja.getNome())){
                    Produto auxProduto = carrinho.getProdutosPorLoja().get(0).getListaProdutos().get(0).getProduto();
                    int auxQuantidade = carrinho.getProdutosPorLoja().get(0).getListaProdutos().get(0).getQuantidade();

                    auxLoja.getEstoque().removerPorNome(auxProduto.getNome(), auxQuantidade);
                    produtos.add(carrinho.getProdutosPorLoja().get(0).getListaProdutos().get(0));

                    carrinho.removerDoCarrinho(carrinho.getProdutosPorLoja().get(0).getLoja(), auxProduto, auxQuantidade);
                }

                auxLoja.getHistoricoDeVendas().add(new Pedidos(produtos, this.getNome(), auxLoja.getNome(), false));
                this.getHistoricoDeCompras().add(new Pedidos(produtos, this.getNome(), auxLoja.getNome(), false));

            }catch (Exception e){
                System.out.println(e);
            }
        }

    }

    public void avaliarPedidos() throws Exception{
        if(historicoDeCompras.size() == 0){
            throw new Exception("nenhum pedido efetuado");
        }

        int qtdPedidosParaAvaliar = 0;
        ArrayList<Pedidos> pedidosParaAvaliar = new ArrayList<>();
        for (int i = 0; i < historicoDeCompras.size(); i++) {
            if(historicoDeCompras.get(i).getAvaliado() == false){
                qtdPedidosParaAvaliar ++;
                pedidosParaAvaliar.add(historicoDeCompras.get(i));
            }
        }

        if(qtdPedidosParaAvaliar == 0){
            throw new Exception("todos os pedidos ja foram avaliados");
        }

        for (int i = 0; i < pedidosParaAvaliar.size(); i++) {
            Pedidos pedidoAtual = pedidosParaAvaliar.get(i);
            Loja lojaAtual= RepositorioLoja.getLojaPorNome(pedidoAtual.getNomeLoja());

            pedidoAtual.imprimirPedidos();
            System.out.println("Que nota voce da para a loja de 0 a 5?");
            Scanner sc = new Scanner(System.in);
            int nota = sc.nextInt();
            sc.nextLine();

            if(nota >= 0 && nota <= 5){
                System.out.println("Faça um comentario sobre o pedido");
                String comentario = sc.nextLine();

                Avaliacao avaliacao = new Avaliacao(this.getNome(), nota, comentario);
                lojaAtual.adicionarAvaliacao(avaliacao);
                pedidoAtual.setAvaliado(true);
            }
            else{
                throw new Exception("Valor digitado não está entre 0 e 5");
            }
        }
    }

    public void imprimirCompras(){
        System.out.println("--------------------------------------------------------------");
        System.out.println("HISTORICO DE COMPRAS:");
        for (int i = 0; i < this.historicoDeCompras.size(); i++) {
            this.historicoDeCompras.get(i).imprimirPedidos();
        }
        System.out.println("--------------------------------------------------------------");
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
        if(historicoDeCompras == null){
            historicoDeCompras = new ArrayList<>();
        }
        return historicoDeCompras;
    }

    public void setHistoricoDeCompras(ArrayList<Pedidos> historicoDeCompras) {
        this.historicoDeCompras = historicoDeCompras;
    }
}
