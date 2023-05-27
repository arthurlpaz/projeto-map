package org.example.repositorio;

import junit.framework.TestCase;

import org.example.entidades.Loja;
import org.example.produto.Estoque;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class RepositorioLojaTest extends TestCase {
    private RepositorioLoja repositorio;

    @Before
    public void setUp(){ repositorio = RepositorioLoja.getInstancia(); }

    @Test
    public void testInserirLoja() throws Exception {
        Estoque estoque = new Estoque();
        String nome = "Loja A";
        String email = "loja@example.com";
        String senha = "senha123";
        String cpf = "12345678900";
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
        assertNull(loja);

        repositorio.removerPorCpf(cpf);
    }

    @Test
    public void testRemoverLojaPorID() throws Exception {
        String nome = "Loja B";
        String email = "loja@example.com";
        String senha = "senha456";
        String cpf = "98765432100";
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
        repositorio.listar();
        System.out.println(repositorio);

        repositorio.removerPorCpf(cpf1);
        repositorio.removerPorCpf(cpf2);
    }

    @Test
    public void testGetLojaPorIDExistente() throws Exception {
        // Dados de exemplo
        String nome = "Loja A";
        String email = "loja@example.com";
        String senha = "senha123";
        String cpf = "12345678900";
        String endereco = "Endereço 1";
        Estoque estoque = new Estoque();

        Loja loja = new Loja(nome, email, senha, cpf, endereco, 1, estoque);
        repositorio.getListaLojas().add(loja);

        Loja lojaObtida = repositorio.getLojaPorID(1);

        assertNotNull(lojaObtida);
        assertEquals(loja, lojaObtida);
    }

    @Test
    public void testGetListaLojas() throws Exception {
        // Inserir duas lojas no repositório
        repositorio.inserir("Loja1", "loja1@example.com", "senha123", "123456789", "Endereço 1", new Estoque());
        repositorio.inserir("Loja2", "loja2@example.com", "senha456", "987654321", "Endereço 2", new Estoque());

        // Obter a lista de lojas do repositório
        ArrayList<Loja> listaLojas = repositorio.getListaLojas();

        // Verificar se a lista de lojas contém as duas lojas inseridas
        assertEquals(2, listaLojas.size());
        assertEquals("Loja1", listaLojas.get(0).getNome());
        assertEquals("Loja2", listaLojas.get(1).getNome());
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

    }
}