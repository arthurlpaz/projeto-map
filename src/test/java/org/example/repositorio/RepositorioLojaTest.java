package org.example.repositorio;

import junit.framework.TestCase;

import org.example.entidades.Loja;
import org.example.produto.Estoque;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class RepositorioLojaTest extends TestCase {
    private RepositorioLoja repositorio;
    private Loja loja1;
    private Loja loja2;

    private Loja loja3;
    @Before
    public void setUp(){
        repositorio = RepositorioLoja.getInstancia();
        loja1 = new Loja("Loja 1", "loja1@example.com", "senha123", "12345678900", "Rua 1", 1, new Estoque());
        loja2 = new Loja("Loja 2", "loja2@example.com", "senha456", "98765432100", "Rua 2", 2, new Estoque());
        loja3 = new Loja("Loja 3", "loja3@example.com", "senha3", "555555555", "Endereço 3", 3, new Estoque(), null);

        repositorio.inserir(loja1);
        repositorio.inserir(loja2);
        repositorio.inserir(loja3);
    }

    @Test
    public void testInserirLoja() throws Exception {
        Estoque estoque = new Estoque();
        String nome = "Loja Teste";
        String email = "loja@example.com";
        String senha = "senha123";
        String cpf = "12341234121";
        String endereco = "Rua A";

        repositorio.inserir(nome, email, senha, cpf, endereco, estoque);

        Loja loja = repositorio.getLojaPorCPF(cpf);

        assertNotNull(loja);
        assertEquals(nome, loja.getNome());
        assertEquals(email, loja.getEmail());
        assertEquals(senha, loja.getSenha());
        assertEquals(cpf, loja.getCpf());
        assertEquals(endereco, loja.getEndereco());
        assertEquals(estoque, loja.getEstoque());

        repositorio.removerPorCpf(loja.getCpf());
    }

    @Test
    public void testRemoverLojaPorCPF() throws Exception {
        Estoque estoque = new Estoque();
        String nome = "Loja A";
        String email = "loja@example.com";
        String senha = "senha987";
        String cpf = "55566677788";
        String endereco = "Rua A";

        repositorio.inserir(nome, email, senha, cpf, endereco, estoque);

        repositorio.removerPorCpf(cpf);

        Loja loja = repositorio.getLojaPorCPF(cpf);

        repositorio.removerPorCpf(cpf);
    }

    @Test
    public void testRemoverLojaPorID() throws Exception {
        String nome = "Loja B";
        String email = "loja@example.com";
        String senha = "senha456";
        String cpf = "32132132132";
        String endereco = "Rua A";
        Estoque estoque = new Estoque();

        repositorio.inserir(nome, email, senha, cpf, endereco, estoque);

        int id = repositorio.getLojaPorCPF(cpf).getID();

        repositorio.removerPorID(id);

        Loja loja = repositorio.getLojaPorCPF(cpf);
        assertNull(loja);
    }

    @Test
    public void testListarLojas() throws Exception {
        String nome1 = "Loja A";
        String email1 = "lojaa@example.com";
        String senha1 = "senha789";
        String cpf1 = "11122233344";
        String endereco1 = "Rua A";
        Estoque estoque1 = new Estoque();

        String nome2 = "Loja B";
        String email2 = "lojab@example.com";
        String senha2 = "senha012";
        String cpf2 = "44455566677";
        String endereco2 = "Rua B";
        Estoque estoque2 = new Estoque();

        repositorio.inserir(nome1, email1, senha1, cpf1, endereco1, estoque1);
        repositorio.inserir(nome2, email2, senha2, cpf2, endereco2, estoque2);

        // Listando as lojas
        repositorio.listarLojas();
        System.out.println(repositorio);

        repositorio.removerPorCpf(cpf1);
        repositorio.removerPorCpf(cpf2);
    }


    public void testSetListaLojas() {
        // Criação das lojas de teste
        Loja loja1 = new Loja("Loja 1", "loja1@example.com", "senha1", "11111111111", "Endereço 1", 1, new Estoque());
        Loja loja2 = new Loja("Loja 2", "loja2@example.com", "senha2", "22222222222", "Endereço 2", 2, new Estoque());

        // Criação da lista de lojas de teste
        ArrayList<Loja> listaLojas = new ArrayList<>();
        listaLojas.add(loja1);
        listaLojas.add(loja2);

        // Definição da lista de lojas no repositório
        repositorio.setListaLojas(listaLojas);

        // Verificação se a lista de lojas foi definida corretamente
        assertEquals(listaLojas, repositorio.getListaLojas());

        repositorio.removerPorCpf("11111111111");
        repositorio.removerPorCpf("22222222222");
    }

    @Test
    public void testListarTodosProdutos(){
        RepositorioLoja repositorioLoja = RepositorioLoja.getInstancia();

        Estoque estoque1 = new Estoque();
        estoque1.inserir("Produto 1 Loja 1", 10, "Tipo 1", "Marca 1", "Descrição 1", 10);
        estoque1.inserir("Produto 2 Loja 1", 20, "Tipo 2", "Marca 2", "Descrição 2", 20);
        Loja loja1 = new Loja("Loja 1", "email1@example.com", "senha1", "CPF1", "Endereço 1", 1, estoque1);
        repositorioLoja.inserir(loja1);

        Estoque estoque2 = new Estoque();
        estoque2.inserir("Produto 1 Loja 2", 10, "Tipo 1", "Marca 1", "Descrição 1", 10);
        estoque2.inserir("Produto 2 Loja 2", 20, "Tipo 2", "Marca 2", "Descrição 2", 20);
        estoque2.inserir("Produto 3 Loja 3", 30, "Tipo 1", "Marca 3", "Descrição 3", 30);
        Loja loja2 = new Loja("Loja 2", "email2@example.com", "senha2", "CPF2", "Endereço 2", 2, estoque2);
        repositorioLoja.inserir(loja2);

        repositorioLoja.listarTodosOsProdutos();
    }

    @Test
    public void testRemoverPorNome() throws Exception {
        repositorio.removerPorNome("Loja 2");

        assertEquals(5, repositorio.getListaLojas().size());
    }

    @Test
    public void testGetLojaPorID() {
        Loja resultado = RepositorioLoja.getLojaPorID(3);
        assertEquals(loja3, resultado);
    }

    @Test
    public void testGetLojaPorNome() throws Exception {
        Loja resultado = RepositorioLoja.getLojaPorNome("Loja 3");
        assertEquals(loja3, resultado);
    }


}

