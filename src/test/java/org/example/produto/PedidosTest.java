package org.example.produto;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PedidosTest {
    private Pedidos pedidos;
    private ArrayList<MapProduto> produtos;
    @Before
    public void setUp() {
        pedidos = new Pedidos();
        produtos = new ArrayList<>();

        MapProduto produto1 = new MapProduto(new Produto("Produto 1", 10.0, "Tipo 1", "Marca 1", "Descrição 1", 1), 10);
        MapProduto produto2 = new MapProduto(new Produto("Produto 2", 20.0, "Tipo 2", "Marca 2", "Descrição 2", 2), 20);
        MapProduto produto3 = new MapProduto(new Produto("Produto 3", 30.0, "Tipo 3", "Marca 3", "Descrição 3", 3), 30);

        produtos.add(produto1);
        produtos.add(produto2);
        produtos.add(produto3);

        pedidos.setProdutos(produtos);
        pedidos.setNomeUsuario("Arthur");
        pedidos.setNomeLoja("Loja Arthur");
    }

    @Test
    public void testImprimirPedidos() {
        // Verifica se a impressão dos pedidos está correta
        pedidos.imprimirPedidos();
    }

    @Test
    public void testGetProdutos() {
        // Verifica se a lista de produtos retornada é igual à lista de produtos configurada no setUp()
        assertEquals(produtos, pedidos.getProdutos());
    }

    @Test
    public void testSetProdutos() {
        // Cria uma nova lista de produtos
        ArrayList<MapProduto> novosProdutos = new ArrayList<>();
        MapProduto produto4 = new MapProduto(new Produto("Produto 4", 40.0, "Tipo 4", "Marca 4", "Descrição 4", 3), 40);
        novosProdutos.add(produto4);

        // Configura a nova lista de produtos no objeto pedidos
        pedidos.setProdutos(novosProdutos);

        // Verifica se a lista de produtos foi atualizada corretamente
        assertEquals(novosProdutos, pedidos.getProdutos());
    }

    @Test
    public void testGetNomeUsuario() {
        // Verifica se o nome do usuário retornado é igual ao nome configurado no setUp()
        assertEquals("Arthur", pedidos.getNomeUsuario());
    }

    @Test
    public void testGetNomeLoja() {
        // Verifica se o nome da loja retornado é igual ao nome configurado no setUp()
        assertEquals("Loja Arthur", pedidos.getNomeLoja());
    }

    @Test
    public void testConstrutor() {
        // Cria uma lista de produtos
        ArrayList<MapProduto> produtos = new ArrayList<>();
        MapProduto produto1 = new MapProduto(new Produto("Produto 1", 10.0, "Tipo 1", "Marca 1", "Descrição 1", 1), 10);
        MapProduto produto2 = new MapProduto(new Produto("Produto 2", 20.0, "Tipo 2", "Marca 2", "Descrição 2", 2), 20);
        produtos.add(produto1);
        produtos.add(produto2);

        // Cria um novo objeto Pedidos utilizando o construtor
        Pedidos pedidos = new Pedidos(produtos, "Arthur", "Loja Arthur", false);

        // Verifica se os atributos foram inicializados corretamente
        assertEquals(produtos, pedidos.getProdutos());
        assertEquals("Arthur", pedidos.getNomeUsuario());
        assertEquals("Loja Arthur", pedidos.getNomeLoja());
    }

    @Test
    public void testGetSetAvaliado() {
        boolean avaliado = true;

        pedidos.setAvaliado(avaliado);
        assertEquals(avaliado, pedidos.getAvaliado());
    }
}

