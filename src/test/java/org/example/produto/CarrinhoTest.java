package org.example.produto;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import static org.junit.Assert.assertEquals;


public class CarrinhoTest {

    private Carrinho carrinho;

    @Before
    public void setup() {
        carrinho = new Carrinho();
    }

    @Test
    public void testInserirNoCarrinho() throws Exception {
        Produto produto = new Produto("Produto 1", 10.0, "Tipo 1", "Marca 1", "Descrição 1", 1);
        int quantidade = 2;

        carrinho.inserirNoCarrinho("Loja A", produto, quantidade);

        ArrayList<MapLojaProduto> produtosPorLoja = carrinho.getProdutosPorLoja();
        assertEquals(1, produtosPorLoja.size());

        MapLojaProduto mapLojaProduto = produtosPorLoja.get(0);
        assertEquals("Loja A", mapLojaProduto.getLoja());
        assertEquals(1, mapLojaProduto.getListaProdutos().size());
        assertEquals(produto, mapLojaProduto.getListaProdutos().get(0).getProduto());
        assertEquals(quantidade, mapLojaProduto.getListaProdutos().get(0).getQuantidade());

        double ValorTotalEsperado = produto.getValor() * quantidade;
        double ValorTotalObtido = carrinho.getValorTotal();

        assertEquals(ValorTotalEsperado, ValorTotalObtido, 0);
    }


    @Test
    public void testRemoverDoCarrinho() throws Exception {
        Produto produto = new Produto("Produto 1", 10.0, "Tipo 1", "Marca 1", "Descrição 1", 1);
        int quantidade = 2;

        carrinho.inserirNoCarrinho("Loja A", produto, quantidade);
        carrinho.removerDoCarrinho("Loja A", produto, quantidade);

        ArrayList<MapLojaProduto> produtosPorLoja = carrinho.getProdutosPorLoja();
        assertEquals(0, produtosPorLoja.size());
        assertEquals(0.0, carrinho.getValorTotal(), 0.001);
    }


    @Test
    // Remove loja do carrinho quando não há mais produtos da loja no carrinho
    public void testRemoverDoCarrinho_RemoverLojaDoCarrinho() throws Exception {
        Produto produto = new Produto("Produto 1", 10.0, "Tipo 1", "Marca 1", "Descrição 1", 1);
        int quantidade = 2;
        carrinho.inserirNoCarrinho("Loja A", produto, quantidade);

        carrinho.removerDoCarrinho("Loja A", produto, quantidade);

        ArrayList<MapLojaProduto> produtosPorLoja = carrinho.getProdutosPorLoja();
        assertEquals(0, produtosPorLoja.size());
        assertEquals(0, carrinho.getValorTotal(), 0.001);
    }

    @Test
    public void testCalculaValorTotal() throws Exception {
        // Arrange
        Produto produto1 = new Produto("Produto 1", 10.0, "Tipo 1", "Marca 1", "Descrição 1", 1);
        Produto produto2 = new Produto("Produto 2", 20.0, "Tipo 2", "Marca 2", "Descrição 2", 2);
        int quantidade1 = 2;
        int quantidade2 = 1;
        carrinho.inserirNoCarrinho("Loja A", produto1, quantidade1);
        carrinho.inserirNoCarrinho("Loja A", produto2, quantidade2);

        double valorTotal = carrinho.calculaValorTotal();

        assertEquals((produto1.getValor() * quantidade1) + (produto2.getValor() * quantidade2), valorTotal, 0.001);
    }

    @Test
    public void testListarItemsCarrinho() throws Exception {
        Produto produto1 = new Produto("Produto 1", 10.0, "Tipo 1", "Marca 1", "Descrição 1", 1);
        Produto produto2 = new Produto("Produto 2", 20.0, "Tipo 2", "Marca 2", "Descrição 2", 2);
        int quantidade1 = 2;
        int quantidade2 = 1;
        carrinho.inserirNoCarrinho("Loja A", produto1, quantidade1);
        carrinho.inserirNoCarrinho("Loja A", produto2, quantidade2);

        carrinho.listarItemsCarrinho();
    }

    @Test
    public void testSetProdutosPorLoja() {
        ArrayList<MapLojaProduto> produtosPorLoja = new ArrayList<>();
        MapLojaProduto mapLojaProduto = new MapLojaProduto("Loja A");
        produtosPorLoja.add(mapLojaProduto);

        carrinho.setProdutosPorLoja(produtosPorLoja);

        assertEquals(produtosPorLoja, carrinho.getProdutosPorLoja());
    }

    @Test
    public void testSetValorTotal() {
        double valorTotal = 50.0;

        carrinho.setValorTotal(valorTotal);

        assertEquals(valorTotal, carrinho.getValorTotal(), 0.001);
    }
}
