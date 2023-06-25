package org.example.entidades;

import org.example.produto.Estoque;
import org.example.produto.Pedidos;
import org.example.repositorio.RepositorioComprador;
import org.example.utils.Avaliacao;

import java.util.ArrayList;
import java.util.Scanner;

public class Loja  extends  Entidades {
    private Estoque estoque;
    private ArrayList<Pedidos> historicoDeVendas;
    private String conceito;

    public Loja(String nome, String email, String senha, String cpf, String endereco, int ID, Estoque estoque) {
        super(nome, email, senha, cpf, endereco, ID);
        this.estoque = estoque;
        this.historicoDeVendas = new ArrayList<>();
    }

    public Loja(String nome, String email, String senha, String cpf, String endereco, int ID, Estoque estoque, ArrayList<Pedidos> historicoDeVendas) {
        super(nome, email, senha, cpf, endereco, ID);
        this.estoque = estoque;
        this.historicoDeVendas = historicoDeVendas;
    }

    public void imprimirVendas(){
        System.out.println("--------------------------------------------------------------");
        System.out.println("HISTORICO DE VENDAS:");
        for (int i = 0; i < this.historicoDeVendas.size(); i++) {
            this.historicoDeVendas.get(i).imprimirPedidos();
        }
        System.out.println("--------------------------------------------------------------");
    }

    public Estoque getEstoque() {
        if (estoque == null) {
            estoque = new Estoque();
        }
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    public ArrayList<Pedidos> getHistoricoDeVendas() {
        if (historicoDeVendas == null) {
            historicoDeVendas = new ArrayList<>();
        }
        return historicoDeVendas;
    }

    public void setHistoricoDeVendas(ArrayList<Pedidos> historicoDeVendas) {
        this.historicoDeVendas = historicoDeVendas;
    }

    public void avaliarPedidos() throws Exception{
        if(historicoDeVendas.size() == 0){
            throw new Exception("nenhum pedido efetuado");
        }

        int qtdPedidosParaAvaliar = 0;
        ArrayList<Pedidos> pedidosParaAvaliar = new ArrayList<>();
        for (int i = 0; i < historicoDeVendas.size(); i++) {
            if(historicoDeVendas.get(i).getAvaliado() == false){
                qtdPedidosParaAvaliar ++;
                pedidosParaAvaliar.add(historicoDeVendas.get(i));
            }
        }

        if(qtdPedidosParaAvaliar == 0){
            throw new Exception("todos os pedidos ja foram avaliados");
        }

        for (int i = 0; i < pedidosParaAvaliar.size(); i++) {
            Pedidos pedidoAtual = pedidosParaAvaliar.get(i);
            Comprador compradorAtual = RepositorioComprador.getCompradorPorNome(pedidoAtual.getNomeUsuario());

            pedidoAtual.imprimirPedidos();
            System.out.println("Que nota voce da para o comprador de 0 a 5?");
            Scanner sc = new Scanner(System.in);
            int nota = sc.nextInt();
            sc.nextLine();

            if(nota >= 1 && nota <= 5){
                System.out.println("Faça um comentario sobre o pedido");
                String comentario = sc.nextLine();

                Avaliacao avaliacao = new Avaliacao(this.getNome(), nota, comentario);
                compradorAtual.adicionarAvaliacao(avaliacao);

                pedidoAtual.setAvaliado(true);
                
            }
            else{
                throw new Exception("Valor digitado não está entre 0 e 5");
            }
        }
    }

    public void calculaConceito(){
        double mediaAvaliacoes = this.getMediaAvaliacoes();
        if(mediaAvaliacoes <= 1){
            this.conceito = "ruim";
        }else if(mediaAvaliacoes <= 3){
            this.conceito = "medio";
        }else if(mediaAvaliacoes <= 4){
            this.conceito = "bom";
        }else if(mediaAvaliacoes <= 5){
            this.conceito = "excelente";
        }else{
            this.conceito = "conceito não pôde ser calculado";
        }
    }

    @Override
    public void adicionarAvaliacao(Avaliacao avaliacao){
        super.getAvaliacoes().add(avaliacao);
        calculaConceito();
    }

    public String getConceito() {
        return conceito;
    }

    public void setConceito(String conceito) {
        this.conceito = conceito;
    }

}
