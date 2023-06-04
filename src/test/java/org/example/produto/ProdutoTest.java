package org.example.produto;

import junit.framework.TestCase;
import org.junit.Test;

public class ProdutoTest extends TestCase {
    @Test
    public void testGetNome() {
        Produto produto = new Produto("Produto 1", 10.0, "Tipo 1", "Marca 1", "Descrição 1", 1);
        assertEquals("Produto 1", produto.getNome());
    }

    @Test
    public void testSetNome() {
        Produto produto = new Produto("Produto 1", 10.0, "Tipo 1", "Marca 1", "Descrição 1", 1);
        produto.setNome("Mercadoria 1");

        assertEquals("Mercadoria 1", produto.getNome());
    }

    @Test
    public void testGetValor() {
        Produto produto = new Produto("Produto 1", 10.0, "Tipo 1", "Marca 1", "Descrição 1", 1);
        assertEquals(10.0, produto.getValor());
    }

    @Test
    public void testSetValor() {
        Produto produto = new Produto("Produto 1", 10.0, "Tipo 1", "Marca 1", "Descrição 1", 1);
        produto.setValor(5.0);

        assertEquals(5.0, produto.getValor());
    }

    @Test
    public void testGetTipo() {
        Produto produto = new Produto("Produto 1", 10.0, "Tipo 1", "Marca 1", "Descrição 1", 1);
        assertEquals("Tipo 1", produto.getTipo());
    }

    @Test
    public void testSetTipo() {
        Produto produto = new Produto("Produto 1", 10.0, "Tipo 1", "Marca 1", "Descrição 1", 1);
        produto.setTipo("Tipo EE");

        assertEquals("Tipo EE", produto.getTipo());
    }

    @Test
    public void testGetMarca() {
        Produto produto = new Produto("Produto 1", 10.0, "Tipo 1", "Marca 1", "Descrição 1", 1);
        assertEquals("Marca 1", produto.getMarca());
    }

    @Test
    public void testSetMarca() {
        Produto produto = new Produto("Produto 1", 10.0, "Tipo 1", "Marca 1", "Descrição 1", 1);
        produto.setMarca("Marca EE");

        assertEquals("Marca EE", produto.getMarca());
    }

    @Test
    public void testGetDescricao() {
        Produto produto = new Produto("Produto 1", 10.0, "Tipo 1", "Marca 1", "Descrição 1", 1);
        assertEquals("Descrição 1", produto.getDescricao());
    }

    @Test
    public void testSetDescricao() {
        Produto produto = new Produto("Produto 1", 10.0, "Tipo 1", "Marca 1", "Descrição 1", 1);
        produto.setDescricao("Descrição EE");

        assertEquals("Descrição EE", produto.getDescricao());
    }

    @Test
    public void testGetID() {
        Produto produto = new Produto("Produto 1", 10.0, "Tipo 1", "Marca 1", "Descrição 1", 1);
        assertEquals(1, produto.getID());
    }

    @Test
    public void testSetID() {
        Produto produto = new Produto("Produto 1", 10.0, "Tipo 1", "Marca 1", "Descrição 1", 1);
        produto.setID(2);

        assertEquals(2, produto.getID());
    }

    @Test
    public void testToString() {
        Produto produto = new Produto("Produto 1", 10.0, "Tipo 1", "Marca 1", "Descrição 1", 1);

        String expectedString = "nome do produto -> Produto 1 | ID -> 1 | valor -> 10.0";
        assertEquals(expectedString, produto.toString());
    }

    @Test
    public void testProduto(){
        Produto produto = new Produto("Produto 1", 10.0, "Tipo 1", "Marca 1", "Descrição 1", 1);
        assertEquals("Produto 1", produto.getNome());
        assertEquals(10.0, produto.getValor());
        assertEquals("Tipo 1", produto.getTipo());
        assertEquals("Marca 1", produto.getMarca());
        assertEquals("Descrição 1", produto.getDescricao());
        assertEquals(1, produto.getID());

    }
}