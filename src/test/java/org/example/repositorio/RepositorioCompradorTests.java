package org.example.repositorio;

import junit.framework.TestCase;
import org.example.repositorio.RepositorioComprador;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RepositorioCompradorTests extends TestCase {
    private RepositorioComprador repositorio;

    @Before
    public void setUp() {
        repositorio = RepositorioComprador.getInstancia();
    }

    @Test
    public void insertComprador() throws Exception {
        int quantidadeInicial = repositorio.getListaCompradores().size();

        repositorio.inserir("Nome 1", "email1@example.com", "senha1", "11111111111", "Endereço 1");

        assertEquals(quantidadeInicial + 1, repositorio.getListaCompradores().size());
        assertEquals("Nome 1", repositorio.getListaCompradores().get(quantidadeInicial).getNome());
        assertEquals("email1@example.com", repositorio.getListaCompradores().get(quantidadeInicial).getEmail());
        assertEquals("senha1", repositorio.getListaCompradores().get(quantidadeInicial).getSenha());
        assertEquals("11111111111", repositorio.getListaCompradores().get(quantidadeInicial).getCpf());
        assertEquals("Endereço 1", repositorio.getListaCompradores().get(quantidadeInicial).getEndereco());

        // Remover no final por conta dos outros testes (Só pode haver uma instância)
        repositorio.removerPorID(0);
    }

    @Test
    public void removerCompradorPorCpfTest() throws Exception {
        repositorio.inserir("Nome 1", "email1@example.com", "senha1", "11111111111", "Endereço 1");
        repositorio.inserir("Nome 2", "email2@example.com", "senha2", "22222222222", "Endereço 2");

        int quantidadeInicial = repositorio.getListaCompradores().size();
        String cpfPraRemocao = "11111111111";

        repositorio.removerPorCpf(cpfPraRemocao);

        assertEquals(quantidadeInicial - 1, repositorio.getListaCompradores().size());
        assertEquals(null, repositorio.GetCompradoresPorCPF(cpfPraRemocao));

        repositorio.removerPorID(0);
        repositorio.removerPorID(1);
    }

    @Test
    public void removerCompradorPorIdTest() throws Exception {
        repositorio.inserir("Nome 1", "email1@example.com", "senha1", "11111111111", "Endereço 1");
        repositorio.inserir("Nome 2", "email2@example.com", "senha2", "22222222222", "Endereço 2");

        int quantidadeInicial = repositorio.getListaCompradores().size();
        int idPraRemocao = repositorio.getListaCompradores().get(0).getID();

        repositorio.removerPorID(idPraRemocao);

        assertEquals(quantidadeInicial - 1, repositorio.getListaCompradores().size());
        assertNull(repositorio.getCompradorPorID(idPraRemocao));

        repositorio.removerPorID(0);
        repositorio.removerPorID(1);
    }
}