package org.example.entidades;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.example.produto.*;
import org.example.utils.Avaliacao;

import java.io.*;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class CompradorTest {

    private Comprador comprador;
    private Loja loja;
    private Produto produto1;
    private Produto produto2;

    @Before
    public void setUp() {
        comprador = new Comprador("Arthur", "arthur@example.com", "password", "123456789", "123", 1);
        loja = new Loja("Loja A", "lojaa@example.com", "password", "123456789", "456", 1, new Estoque());
        produto1 = new Produto("Produto 1", 10.0, "Tipo 1", "Marca 1", "Descrição 1", 1);
        produto2 = new Produto("Produto 2", 20.0, "Tipo 2", "Marca 2", "Descrição 2", 2);
        loja.getEstoque().inserir(produto1.getNome(), produto1.getValor(), produto1.getTipo(), produto1.getMarca(), produto1.getDescricao(), 10);
        loja.getEstoque().inserir(produto2.getNome(), produto2.getValor(), produto2.getTipo(), produto2.getMarca(), produto2.getDescricao(), 5);
    }

    @Test(expected = Exception.class)
    public void testFinalizarComprasCarrinhoVazio() throws Exception {
        comprador.finalizarCompras();
    }

    @Test
    public void testGetHistoricoDeCompras() {
        assertTrue(comprador.getHistoricoDeCompras().isEmpty());

        ArrayList<MapProduto> produtos = new ArrayList<>();
        produtos.add(new MapProduto(new Produto("Produto 1", 10.0, "Tipo 1", "Marca 1", "Descrição 1", 1), 2));
        Pedidos pedido = new Pedidos(produtos, comprador.getNome(), "Loja A", false);
        comprador.getHistoricoDeCompras().add(pedido);

        assertEquals(1, comprador.getHistoricoDeCompras().size());
        assertEquals(pedido, comprador.getHistoricoDeCompras().get(0));
    }

    @Test
    public void testSetHistoricoDeCompras() {
        assertTrue(comprador.getHistoricoDeCompras().isEmpty());

        ArrayList<Pedidos> novoHistorico = new ArrayList<>();
        ArrayList<MapProduto> produtos = new ArrayList<>();
        produtos.add(new MapProduto(new Produto("Produto 1", 10.0, "Tipo 1", "Marca 1", "Descrição 1", 1), 2));
        Pedidos pedido = new Pedidos(produtos, comprador.getNome(), "Loja A", false);
        novoHistorico.add(pedido);

        comprador.setHistoricoDeCompras(novoHistorico);

        assertEquals(1, comprador.getHistoricoDeCompras().size());
        assertEquals(pedido, comprador.getHistoricoDeCompras().get(0));
    }

    @Test
    public void testGetCarrinho() {
        Carrinho carrinho1 = comprador.getCarrinho();

        Assert.assertNotNull(carrinho1);

        Carrinho carrinho2 = comprador.getCarrinho();

        Assert.assertSame(carrinho1, carrinho2);
    }

    @Test
    public void testSetCarrinho() {
        Carrinho carrinho = new Carrinho();
        comprador.setCarrinho(carrinho);

        assertSame(carrinho, comprador.getCarrinho());
    }
    @Test
    public void testImprimirCompras() {
        // Criação de um histórico de compras fictício
        ArrayList<Pedidos> historicoDeCompras = new ArrayList<>();

        // Dados do pedido 1
        ArrayList<MapProduto> produtosPedido1 = new ArrayList<>();
        produtosPedido1.add(new MapProduto(new Produto("Produto 1", 10.0, "Tipo 1", "Marca 1", "Descrição 1", 1), 1));
        produtosPedido1.add(new MapProduto(new Produto("Produto 2", 20.0, "Tipo 2", "Marca 2", "Descrição 2", 2), 2));
        String nomeUsuarioPedido1 = "User 1";
        String nomeLojaPedido1 = "Loja 1";
        Pedidos pedido1 = new Pedidos(produtosPedido1, nomeUsuarioPedido1, nomeLojaPedido1, false);
        historicoDeCompras.add(pedido1);

        // Dados do pedido 2
        ArrayList<MapProduto> produtosPedido2 = new ArrayList<>();
        produtosPedido2.add(new MapProduto(new Produto("Produto 3", 30.0, "Tipo 3", "Marca 3", "Descrição 3", 3), 3));
        produtosPedido2.add(new MapProduto(new Produto("Produto 4", 40.0, "Tipo 4", "Marca 4", "Descrição 4", 4), 4));
        String nomeUsuarioPedido2 = "User 2";
        String nomeLojaPedido2 = "Loja 2";
        Pedidos pedido2 = new Pedidos(produtosPedido2, nomeUsuarioPedido2, nomeLojaPedido2, false);
        historicoDeCompras.add(pedido2);

        // Dados do pedido 3
        ArrayList<MapProduto> produtosPedido3 = new ArrayList<>();
        produtosPedido3.add(new MapProduto(new Produto("Produto 5", 50.0, "Tipo 5", "Marca 5", "Descrição 5", 5), 5));
        produtosPedido3.add(new MapProduto(new Produto("Produto 6", 60.0, "Tipo 6", "Marca 6", "Descrição 6", 6), 6));
        String nomeUsuarioPedido3 = "User 3";
        String nomeLojaPedido3 = "Loja 3";
        Pedidos pedido3 = new Pedidos(produtosPedido3, nomeUsuarioPedido3, nomeLojaPedido3, false);
        historicoDeCompras.add(pedido3);

        comprador.setHistoricoDeCompras(historicoDeCompras);

        // Criação de um objeto StringWriter para capturar a saída do método imprimirCompras()
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);

        System.setOut(new PrintStream(new OutputStream() {
            @Override
            public void write(int b) {
                printWriter.write(b);
            }
        }));

        comprador.imprimirCompras();

        System.setOut(System.out);

        String output = stringWriter.toString();

        assertTrue(output.contains("HISTORICO DE COMPRAS:"));
        assertTrue(output.contains("Loja: " + nomeLojaPedido1));
        assertTrue(output.contains("Usuario: " + nomeUsuarioPedido1));
        assertTrue(output.contains("Loja: " + nomeLojaPedido2));
        assertTrue(output.contains("Usuario: " + nomeUsuarioPedido2));
        assertTrue(output.contains("Loja: " + nomeLojaPedido3));
        assertTrue(output.contains("Usuario: " + nomeUsuarioPedido3));
        assertTrue(output.contains("--------------------------------------------------------------"));
    }

    @Test
    public void testConstrutorComprador() {
        // Dados de exemplo
        String nome = "Arthur";
        String email = "arthur@example.com";
        String senha = "123";
        String cpf = "123456789";
        String endereco = "123";
        int ID = 1;
        Carrinho carrinho = new Carrinho();
        ArrayList<Pedidos> historicoDeCompras = new ArrayList<>();        
        ArrayList<Avaliacao> avaliacoes = new ArrayList<>();

        Comprador comprador = new Comprador(nome, email, senha, cpf, endereco, ID, avaliacoes, carrinho, historicoDeCompras);

        assertEquals(nome, comprador.getNome());
        assertEquals(email, comprador.getEmail());
        assertEquals(senha, comprador.getSenha());
        assertEquals(cpf, comprador.getCpf());
        assertEquals(endereco, comprador.getEndereco());
        assertEquals(ID, comprador.getID());
        assertEquals(carrinho, comprador.getCarrinho());
        assertEquals(historicoDeCompras, comprador.getHistoricoDeCompras());
    }

    @Test
    public void testAvaliarPedidosTodosPedidosAvaliados() {
        // Teste: Avaliar pedidos quando todos os pedidos já foram avaliados deve lançar uma exceção
        ArrayList<Pedidos> historico = new ArrayList<>();
        historico.add(new Pedidos(new ArrayList<>(), "João", "Loja A", true));
        comprador.setHistoricoDeCompras(historico);

        try {
            comprador.avaliarPedidos();
            fail("Deveria ter lançado uma exceção");
        } catch (Exception e) {
            assertEquals("todos os pedidos ja foram avaliados", e.getMessage());
        }
    }



}