package org.example.produto;

import junit.framework.TestCase;
import org.junit.Test;

public class MapProdutoTest extends TestCase {

    @Test
    public void testGetProduto() {
        Produto produto = new Produto("Produto 1", 10.0, "Tipo 1", "Marca 1", "Descrição 1", 1);
        MapProduto mapProduto = new MapProduto(produto, 10);

        assertEquals(produto, mapProduto.getProduto());
        assertEquals(10, mapProduto.getQuantidade());
    }

    @Test
    public void testSetProduto() {
        Produto produto = new Produto("Produto 1", 10.0, "Tipo 1", "Marca 1", "Descrição 1", 1);
        MapProduto mapProduto = new MapProduto(produto, 10);

        Produto produto2 = new Produto("Produto 2", 20.0, "Tipo 2", "Marca 2", "Descrição 2", 2);
        mapProduto.setProduto(produto2);

        assertEquals(produto2, mapProduto.getProduto());

    }

    @Test
    public void testGetQuantidade() {
        Produto produto = new Produto("Produto 1", 10.0, "Tipo 1", "Marca 1", "Descrição 1", 1);
        MapProduto mapProduto = new MapProduto(produto, 10);

        assertEquals(10, mapProduto.getQuantidade());
    }

    @Test
    public void testSetQuantidade() {
        Produto produto = new Produto("Produto 1", 10.0, "Tipo 1", "Marca 1", "Descrição 1", 1);
        MapProduto mapProduto = new MapProduto(produto, 10);

        mapProduto.setQuantidade(35);
        assertEquals(35, mapProduto.getQuantidade());
    }

    @Test
    public void testConstructorMapProduto(){
        Produto produto = new Produto("Produto 1", 10.0, "Tipo 1", "Marca 1", "Descrição 1", 1);
        MapProduto mapProduto = new MapProduto(produto, 10);

        assertEquals("Produto 1", mapProduto.produto.getNome());
        assertEquals(10.0, mapProduto.produto.getValor());
        assertEquals("Tipo 1", mapProduto.produto.getTipo());
        assertEquals("Marca 1", mapProduto.produto.getMarca());
        assertEquals("Descrição 1", mapProduto.produto.getDescricao());
        assertEquals(1, mapProduto.produto.getID());
        assertEquals(10, mapProduto.getQuantidade());

    }

}