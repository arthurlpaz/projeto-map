package org.example.produto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MapLojaProdutoTest {

    private MapLojaProduto mapLojaProduto;
    private Produto produto1;
    private Produto produto2;

    @BeforeEach
    public void setUp() {
        produto1 = new Produto("Produto 1", 10.0, "Tipo 1", "Marca 1", "Descrição 1", 1);
        produto2 = new Produto("Produto 2", 20.0, "Tipo 2", "Marca 2", "Descrição 2", 2);

        mapLojaProduto = new MapLojaProduto("Loja 1");

    }
    @Test
    public void testSetListaProdutos() {
        ArrayList<MapProduto> listaProdutos = new ArrayList<>();
        listaProdutos.add(new MapProduto(produto1, 3));
        listaProdutos.add(new MapProduto(produto2, 2));

        mapLojaProduto.setListaProdutos(listaProdutos);

        ArrayList<MapProduto> atual = mapLojaProduto.getListaProdutos();

        assertEquals(listaProdutos.size(), atual.size());
        assertEquals(listaProdutos.get(0), atual.get(0));
        assertEquals(listaProdutos.get(1), atual.get(1));
    }

    @Test
    public void testSetLoja() {
        String novaLoja = "Loja 2";

        mapLojaProduto.setLoja(novaLoja);

        String atual = mapLojaProduto.getLoja();

        assertEquals(novaLoja, atual);
    }

//    @Test
//    public void testGetTotalLoja() throws Exception {
//        mapLojaProduto.inserirProduto(produto1, 3);
//        mapLojaProduto.inserirProduto(produto2, 2);
//
//        mapLojaProduto.calculaTotalLoja();
//
//        double totalEsperado = 70.0;
//        double totalAtual = mapLojaProduto.getTotalLoja();
//
//        assertEquals(totalEsperado, totalAtual, 0);
//    }

    @Test
    public void testSetTotalLoja() {
        double novoTotal = 100.0;

        mapLojaProduto.setTotalLoja(novoTotal);

        double atual = mapLojaProduto.getTotalLoja();
        assertEquals(novoTotal, atual);
    }
}