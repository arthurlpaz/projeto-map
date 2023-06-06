package org.example.produto;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class EstoqueTest extends TestCase {
    private Estoque estoque;

    @Before
    public void setUp() {
        estoque = new Estoque();
    }

    @Test
    public void testarListarProdutos() {
        // Cria uma instância do Estoque
        Estoque estoque = new Estoque();

        // Adiciona produtos à lista estoque
        estoque.inserir("Produto 1", 10, "Tipo 1", "Marca 1", "Descrição 1", 10);
        estoque.inserir("Produto 2", 20, "Tipo 2", "Marca 2", "Descrição 2", 20);
        // Adicione mais produtos, se necessário

        // Redireciona a saída padrão para um objeto ByteArrayOutputStream
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        PrintStream originalPrintStream = System.out;
        System.setOut(printStream);

        // Chama o método listarProdutos()
        estoque.listarProdutos();

        // Restaura a saída padrão do console
        System.out.flush();
        System.setOut(originalPrintStream);

        // Obtém a saída do console como uma String
        String consoleOutput = outputStream.toString();

        // Verifica a saída do console com o resultado esperado
        String expectedOutput = "nome do produto -> Produto 1 | ID -> 1 | valor -> 10.0 | quantidade -> 10\n" +
                                "nome do produto -> Produto 2 | ID -> 2 | valor -> 20.0 | quantidade -> 20\n";
        System.out.println(expectedOutput);

        System.out.println(consoleOutput);

        assertEquals(expectedOutput, consoleOutput);
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
    public void testRemoverPorID() {
        estoque.inserir("Produto 1", 10.0, "Tipo 1", "Marca 1", "Descrição 1", 10);
        estoque.inserir("Produto 2", 20.0, "Tipo 2", "Marca 2", "Descrição 2", 20);

        try{
            estoque.removerPorID(1, 10);
        }catch (Exception e){
            e.printStackTrace();
        }

        ArrayList<MapProduto> estoqueAtual = estoque.getEstoque();
        assertEquals(1, estoqueAtual.size());

        MapProduto produto = estoqueAtual.get(0);

        assertEquals("Produto 2", produto.getProduto().getNome());
        assertEquals(20.0, produto.getProduto().getValor(), 0.01);
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

//    @Test
//    public void testSetEstoque() {
//        ArrayList<MapProduto> novoEstoque = new ArrayList<>();
//
//        novoEstoque.add(new MapProduto(new Produto("Produto 1", 10.0, "Tipo 1", "Marca 1", "Descrição 1", 1), 10));
//        novoEstoque.add(new MapProduto(new Produto("Produto 2", 20.0, "Tipo 2", "Marca 2", "Descrição 2", 2), 20) );
//
//        estoque.setEstoque(novoEstoque);
//
//        ArrayList<MapProduto> estoqueAtual = estoque.getEstoque();
//        assertEquals(2, estoqueAtual.size());
//
//        MapProduto produto1 = estoqueAtual.get(0);
//        assertEquals("Produto 1", produto1.getProduto().getNome());
//        assertEquals(10.0, produto1.getProduto().getValor());
//        assertEquals("Tipo 1", produto1.getProduto().getTipo());
//        assertEquals("Marca 1", produto1.getProduto().getMarca());
//        assertEquals("Descrição 1", produto1.getProduto().getDescricao());
//
//        MapProduto produto2 = estoqueAtual.get(1);
//        assertEquals("Produto 2", produto2.getProduto().getNome());
//        assertEquals(20.0, produto2.getProduto().getValor());
//        assertEquals("Tipo 2", produto2.getProduto().getTipo());
//        assertEquals("Marca 2", produto2.getProduto().getMarca());
//        assertEquals("Descrição 2", produto2.getProduto().getDescricao());
//
//        //remover itens do estoque, reiniciando repositorio para proximos testes
//        try{
//            estoque.removerPorID(1, 10);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//        try{
//            estoque.removerPorID(2, 20);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//    }

    @Test
    public void testListarProdutos() {

    }

    @Test
    public void testRemoverPorNome() {
        estoque.inserir("Produto 1", 10.0, "Tipo 1", "Marca 1", "Descrição 1", 10);
        estoque.inserir("Produto 2", 20.0, "Tipo 2", "Marca 2", "Descrição 2", 20);

        try{
            estoque.removerPorNome("Produto 1", 10);
        }catch (Exception e ){
            e.printStackTrace();
        }

        ArrayList<MapProduto> novoEstoque = estoque.getEstoque();

        assertEquals(1, novoEstoque.size());
        assertEquals("Produto 2", novoEstoque.get(0).getProduto().getNome());
        assertEquals(20.0, novoEstoque.get(0).getProduto().getValor());
        assertEquals("Tipo 2", novoEstoque.get(0).getProduto().getTipo());
        assertEquals("Marca 2", novoEstoque.get(0).getProduto().getMarca());
        assertEquals("Descrição 2", novoEstoque.get(0).getProduto().getDescricao());
        assertEquals(2, novoEstoque.get(0).getProduto().getID());
        assertEquals(20, novoEstoque.get(0).getQuantidade());
    }

    @Test
    public void testGetProdutoPorIDExistente() {
        estoque.inserir("Produto 1", 10.0, "Tipo 1", "Marca 1", "Descrição 1", 10);
        estoque.inserir("Produto 2", 20.0, "Tipo 2", "Marca 2", "Descrição 2", 20);

        try {
            MapProduto resultado = estoque.getProdutoPorID(1);
            assertEquals("Produto 1", resultado.getProduto().getNome());
            assertEquals(10.0, resultado.getProduto().getValor(), 0.01);
            // Adicione mais verificações, se necessário
        } catch (Exception e) {
            fail("Exceção lançada: " + e.getMessage());
        }
    }

    @Test
    public void testGetProdutoPorIDNaoExistente() {
        try {
            estoque.getProdutoPorID(10);
            fail("Exceção esperada não foi lançada.");
        } catch (Exception e) {
            assertEquals("produto nao encontrado", e.getMessage());
        }
    }



}