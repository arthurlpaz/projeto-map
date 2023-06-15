package org.example.entidades;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.example.produto.*;

import java.io.*;
import java.util.ArrayList;

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
        // Verifica se o histórico de compras inicial está vazio
        Assert.assertTrue(comprador.getHistoricoDeCompras().isEmpty());

        // Adiciona um pedido ao histórico de compras
        ArrayList<MapProduto> produtos = new ArrayList<>();
        produtos.add(new MapProduto(new Produto("Produto 1", 10.0, "Tipo 1", "Marca 1", "Descrição 1", 1), 2));
        Pedidos pedido = new Pedidos(produtos, comprador.getNome(), "Loja A");
        comprador.getHistoricoDeCompras().add(pedido);

        // Verifica se o histórico de compras contém o pedido adicionado
        Assert.assertEquals(1, comprador.getHistoricoDeCompras().size());
        Assert.assertEquals(pedido, comprador.getHistoricoDeCompras().get(0));
    }

    @Test
    public void testSetHistoricoDeCompras() {
        // Verifica se o histórico de compras inicial está vazio
        Assert.assertTrue(comprador.getHistoricoDeCompras().isEmpty());

        // Cria um novo histórico de compras
        ArrayList<Pedidos> novoHistorico = new ArrayList<>();
        ArrayList<MapProduto> produtos = new ArrayList<>();
        produtos.add(new MapProduto(new Produto("Produto 1", 10.0, "Tipo 1", "Marca 1", "Descrição 1", 1), 2));
        Pedidos pedido = new Pedidos(produtos, comprador.getNome(), "Loja A");
        novoHistorico.add(pedido);

        // Define o novo histórico de compras
        comprador.setHistoricoDeCompras(novoHistorico);

        // Verifica se o histórico de compras foi atualizado corretamente
        Assert.assertEquals(1, comprador.getHistoricoDeCompras().size());
        Assert.assertEquals(pedido, comprador.getHistoricoDeCompras().get(0));
    }

    @Test
    public void testGetCarrinho() {
        // Obtém o carrinho pela primeira vez
        Carrinho carrinho1 = comprador.getCarrinho();

        // Verifica se o carrinho obtido não é nulo
        Assert.assertNotNull(carrinho1);

        // Obtém o carrinho novamente
        Carrinho carrinho2 = comprador.getCarrinho();

        // Verifica se o carrinho obtido é o mesmo objeto retornado anteriormente
        Assert.assertSame(carrinho1, carrinho2);
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
        Pedidos pedido1 = new Pedidos(produtosPedido1, nomeUsuarioPedido1, nomeLojaPedido1);
        historicoDeCompras.add(pedido1);

        // Dados do pedido 2
        ArrayList<MapProduto> produtosPedido2 = new ArrayList<>();
        produtosPedido2.add(new MapProduto(new Produto("Produto 3", 30.0, "Tipo 3", "Marca 3", "Descrição 3", 3), 3));
        produtosPedido2.add(new MapProduto(new Produto("Produto 4", 40.0, "Tipo 4", "Marca 4", "Descrição 4", 4), 4));
        String nomeUsuarioPedido2 = "User 2";
        String nomeLojaPedido2 = "Loja 2";
        Pedidos pedido2 = new Pedidos(produtosPedido2, nomeUsuarioPedido2, nomeLojaPedido2);
        historicoDeCompras.add(pedido2);

        // Dados do pedido 3
        ArrayList<MapProduto> produtosPedido3 = new ArrayList<>();
        produtosPedido3.add(new MapProduto(new Produto("Produto 5", 50.0, "Tipo 5", "Marca 5", "Descrição 5", 5), 5));
        produtosPedido3.add(new MapProduto(new Produto("Produto 6", 60.0, "Tipo 6", "Marca 6", "Descrição 6", 6), 6));
        String nomeUsuarioPedido3 = "User 3";
        String nomeLojaPedido3 = "Loja 3";
        Pedidos pedido3 = new Pedidos(produtosPedido3, nomeUsuarioPedido3, nomeLojaPedido3);
        historicoDeCompras.add(pedido3);

        comprador.setHistoricoDeCompras(historicoDeCompras);

        // Criação de um objeto StringWriter para capturar a saída do método imprimirCompras()
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);

        // Redireciona a saída do método imprimirCompras() para o StringWriter
        System.setOut(new PrintStream(new OutputStream() {
            @Override
            public void write(int b) {
                printWriter.write(b);
            }
        }));

        // Chama o método imprimirCompras()
        comprador.imprimirCompras();

        // Restaura a saída padrão
        System.setOut(System.out);

        // Obtém a saída do método imprimirCompras()
        String output = stringWriter.toString();

        // Verifica se a saída contém as informações esperadas do histórico de compras
        Assert.assertTrue(output.contains("HISTORICO DE COMPRAS:"));
        Assert.assertTrue(output.contains("Loja: " + nomeLojaPedido1));
        Assert.assertTrue(output.contains("Usuario: " + nomeUsuarioPedido1));
        Assert.assertTrue(output.contains("Loja: " + nomeLojaPedido2));
        Assert.assertTrue(output.contains("Usuario: " + nomeUsuarioPedido2));
        Assert.assertTrue(output.contains("Loja: " + nomeLojaPedido3));
        Assert.assertTrue(output.contains("Usuario: " + nomeUsuarioPedido3));
        Assert.assertTrue(output.contains("--------------------------------------------------------------"));
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

        // Criação do objeto Comprador
        Comprador comprador = new Comprador(nome, email, senha, cpf, endereco, ID, carrinho, historicoDeCompras);

        // Verificação dos atributos
        Assert.assertEquals(nome, comprador.getNome());
        Assert.assertEquals(email, comprador.getEmail());
        Assert.assertEquals(senha, comprador.getSenha());
        Assert.assertEquals(cpf, comprador.getCpf());
        Assert.assertEquals(endereco, comprador.getEndereco());
        Assert.assertEquals(ID, comprador.getID());
        Assert.assertEquals(carrinho, comprador.getCarrinho());
        Assert.assertEquals(historicoDeCompras, comprador.getHistoricoDeCompras());
    }
}