package org.example.produto;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Map;

public class EstoqueTest extends TestCase {
    private Estoque estoque;

    @Before
    public void setUp() {
        estoque = new Estoque();
    }

    @Test
    public void testInserir() {
        estoque.inserir("Produto 1", 10.0, "Tipo 1", "Marca 1", "Descrição 1", 10);
        ArrayList<MapProduto> estoqueAtual = estoque.getEstoque();

        assertEquals(1, estoqueAtual.size());

        MapProduto produto = estoqueAtual.get(0);

        assertEquals("Produto 1", produto.getProduto().getNome());
        assertEquals(10.0, produto.getProduto().getValor());
        assertEquals("Tipo 1", produto.getProduto().getTipo());
        assertEquals("Marca 1", produto.getProduto().getMarca());
        assertEquals("Descrição 1", produto.getProduto().getDescricao());
    }

    @Test
    public void testRemoverProduto() {
        estoque.inserir("Produto 1", 10.0, "Tipo 1", "Marca 1", "Descrição 1", 10);
        estoque.inserir("Produto 2", 20.0, "Tipo 2", "Marca 2", "Descrição 2", 20);

        //id produto || quantidade a remover
        estoque.removerPorID(1,1);

        ArrayList<MapProduto> estoqueAtual = estoque.getEstoque();
        assertEquals(1, estoqueAtual.size());

        MapProduto produto = estoqueAtual.get(0);

        assertEquals("Produto 2", produto.getProduto().getNome());
        assertEquals(20.0, produto.getProduto().getValor());
        assertEquals("Tipo 2", produto.getProduto().getTipo());
        assertEquals("Marca 2", produto.getProduto().getMarca());
        assertEquals("Descrição 2", produto.getProduto().getDescricao());
    }

    @Test
    public void testGetEstoque() {
        ArrayList<MapProduto> estoqueAtual = estoque.getEstoque();

        assertNotNull(estoqueAtual);
        assertEquals(0, estoqueAtual.size());

        estoque.inserir("Produto 1", 10.0, "Tipo 1", "Marca 1", "Descrição 1", 10);

        estoqueAtual = estoque.getEstoque();
        assertEquals(1, estoqueAtual.size());
    }

    @Test
    public void testSetEstoque() {
        ArrayList<MapProduto> novoEstoque = new ArrayList<>();

        novoEstoque.add(new MapProduto(new Produto("Produto 1", 10.0, "Tipo 1", "Marca 1", "Descrição 1", 1), 10));
        novoEstoque.add(new MapProduto(new Produto("Produto 2", 20.0, "Tipo 2", "Marca 2", "Descrição 2", 2), 20) );

        estoque.setEstoque(novoEstoque);

        ArrayList<MapProduto> estoqueAtual = estoque.getEstoque();
        assertEquals(2, estoqueAtual.size());

        MapProduto produto1 = estoqueAtual.get(0);
        assertEquals("Produto 1", produto1.getProduto().getNome());
        assertEquals(10.0, produto1.getProduto().getValor());
        assertEquals("Tipo 1", produto1.getProduto().getTipo());
        assertEquals("Marca 1", produto1.getProduto().getMarca());
        assertEquals("Descrição 1", produto1.getProduto().getDescricao());

        MapProduto produto2 = estoqueAtual.get(1);
        assertEquals("Produto 2", produto2.getProduto().getNome());
        assertEquals(20.0, produto2.getProduto().getValor());
        assertEquals("Tipo 2", produto2.getProduto().getTipo());
        assertEquals("Marca 2", produto2.getProduto().getMarca());
        assertEquals("Descrição 2", produto2.getProduto().getDescricao());

    }

}