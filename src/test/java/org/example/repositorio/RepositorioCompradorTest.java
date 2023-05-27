package org.example.repositorio;

import org.example.entidades.Comprador;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class RepositorioCompradorTest {

    private RepositorioComprador repositorio;

    @Before
    public void setUp() {
        repositorio = RepositorioComprador.getInstancia();
        repositorio.setListaCompradores(new ArrayList<>());
    }

    @Test
    public void testInserirComprador() throws Exception {
        repositorio.inserir("Joao", "joao@email.com", "password", "123456789", "Rua A");
        assertEquals(1, repositorio.getListaCompradores().size());
    }

    @Test(expected = Exception.class)
    public void testInserirCompradorExistente() throws Exception {
        repositorio.inserir("Joao", "joao@email.com", "password", "123456789", "Rua A");
        repositorio.inserir("Joao", "joao2@email.com", "password", "987654321", "Rua B");
    }

    @Test
    public void testRemoverPorCpf() throws Exception {
        repositorio.inserir("Joao", "joao@email.com", "password", "123456789", "Rua A");
        repositorio.removerPorCpf("123456789");
        assertEquals(0, repositorio.getListaCompradores().size());
    }

    @Test
    public void testRemoverPorID() throws Exception {
        repositorio.inserir("Joao", "joao@email.com", "password", "123456789", "Rua A");
        int id = repositorio.getListaCompradores().get(0).getID();
        repositorio.removerPorID(id);
        assertEquals(0, repositorio.getListaCompradores().size());
    }

    @Test
    public void testGetCompradorPorID() throws Exception {
        repositorio.inserir("Joao", "joao@email.com", "password", "123456789", "Rua A");
        int id = repositorio.getListaCompradores().get(0).getID();
        Comprador comprador = repositorio.getCompradorPorID(id);
        assertNotNull(comprador);
        assertEquals("Joao", comprador.getNome());
    }

    @Test
    public void testGetCompradorPorNome() throws Exception {
        repositorio.inserir("Joao", "joao@email.com", "password", "123456789", "Rua A");
        Comprador comprador = repositorio.getCompradorPorNome("Joao");
        assertNotNull(comprador);
        assertEquals("123456789", comprador.getCpf());
    }

    @Test
    public void testGetCompradorPorCPF() throws Exception {
        repositorio.inserir("Joao", "joao@email.com", "password", "123456789", "Rua A");
        Comprador comprador = repositorio.GetCompradoresPorCPF("123456789");
        assertNotNull(comprador);
        assertEquals("Joao", comprador.getNome());
    }

    @Test
    public void testGetListaCompradores() {
        ArrayList<Comprador> listaCompradores = new ArrayList<>();
        listaCompradores.add(new Comprador("Joao", "joao@email.com", "password", "123456789", "Rua A", 1));
        listaCompradores.add(new Comprador("Jose", "jose@email.com", "password", "987654321", "Rua B", 2));

        repositorio.setListaCompradores(listaCompradores);

        assertEquals(listaCompradores, repositorio.getListaCompradores());
    }

    @Test
    public void testSetListaCompradores() {
        ArrayList<Comprador> listaCompradores = new ArrayList<>();
        listaCompradores.add(new Comprador("Joao", "joao@email.com", "password", "123456789", "Rua A", 1));
        listaCompradores.add(new Comprador("Jose", "jose@email.com", "password", "987654321", "Rua B", 2));

        repositorio.setListaCompradores(listaCompradores);

        assertEquals(listaCompradores, repositorio.getListaCompradores());
    }


}