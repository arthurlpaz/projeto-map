package org.example.entidades;

import junit.framework.TestCase;
import org.example.produto.Estoque;
import org.example.produto.Pedidos;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class LojaTest extends TestCase {

    private Loja loja;
    private Estoque estoque;
    private ArrayList<Pedidos> historicoVendas;
    @Before
    public void setUp() {
        estoque = new Estoque();
        historicoVendas = new ArrayList<>();

        loja = new Loja("Minha Loja", "loja@example.com", "senha123", "123456789", "Rua Principal", 1, estoque, historicoVendas);
    }

    @Test
    public void testConstructorComHistoricoDeVendas() {
        assertEquals("Minha Loja", loja.getNome());
        assertEquals("loja@example.com", loja.getEmail());
        assertEquals("senha123", loja.getSenha());
        assertEquals("123456789", loja.getCpf());
        assertEquals("Rua Principal", loja.getEndereco());
        assertEquals(1, loja.getID());
        assertEquals(estoque, loja.getEstoque());
        assertEquals(historicoVendas, loja.getHistoricoDeVendas());
    }
    @Test
    public void testGetNome() {
        String nome = loja.getNome();
        assertEquals("Minha Loja", nome);
    }

    @Test
    public void testSetNome() {
        loja.setNome("Nova Loja");
        String nome = loja.getNome();
        assertEquals("Nova Loja", nome);
    }

    @Test
    public void testGetEmail() {
        String email = loja.getEmail();
        assertEquals("loja@example.com", email);
    }

    @Test
    public void testSetEmail() {
        loja.setEmail("novaemail@example.com");
        String email = loja.getEmail();
        assertEquals("novaemail@example.com", email);
    }

    @Test
    public void testGetSenha() {
        String senha = loja.getSenha();
        assertEquals("senha123", senha);
    }

    @Test
    public void testSetSenha() {
        loja.setSenha("novasenha456");
        String senha = loja.getSenha();
        assertEquals("novasenha456", senha);
    }

    @Test
    public void testGetCpf() {
        String cpf = loja.getCpf();
        assertEquals("123456789", cpf);
    }

    @Test
    public void testSetCpf() {
        loja.setCpf("987654321");
        String cpf = loja.getCpf();
        assertEquals("987654321", cpf);
    }

    @Test
    public void testGetEndereco() {
        String endereco = loja.getEndereco();
        assertEquals("Rua Principal", endereco);
    }

    @Test
    public void testSetEndereco() {
        loja.setEndereco("Avenida Secundária");
        String endereco = loja.getEndereco();
        assertEquals("Avenida Secundária", endereco);
    }

    @Test
    public void testGetID() {
        int id = loja.getID();
        assertEquals(1, id);
    }

    @Test
    public void testSetID() {
        loja.setID(2);
        int id = loja.getID();
        assertEquals(2, id);
    }

    @Test
    public void testGetEstoque() {
        Estoque estoque = loja.getEstoque();
        assertNotNull(estoque);
    }

    @Test
    public void testSetEstoque() {
        Estoque novoEstoque = new Estoque();
        loja.setEstoque(novoEstoque);
        Estoque estoque = loja.getEstoque();
        assertEquals(novoEstoque, estoque);
    }

    @Test
    public void testToString() {
        String stringEsperada = "nome -> Minha Loja | email -> loja@example.com | endereco -> Rua Principal | ID -> 1";
        String stringAtual = loja.toString();
        assertEquals(stringEsperada, stringAtual);
    }

    @Test
    public void testGetHistoricoDeVendas_QuandoForNull() {
        ArrayList<Pedidos> historico = loja.getHistoricoDeVendas();

        assertNotNull(historico);
        assertTrue(historico.isEmpty());
    }

    @Test
    public void testGetHistoricoDeVendas_QuandoNaoForNull() {
        ArrayList<Pedidos> historicoExistente = new ArrayList<>();
        historicoExistente.add(new Pedidos());
        loja.setHistoricoDeVendas(historicoExistente);

        ArrayList<Pedidos> historico = loja.getHistoricoDeVendas();

        assertEquals(historicoExistente, historico);
    }

    @Test
    public void testSetHistoricoDeVendas() {
        ArrayList<Pedidos> historico = new ArrayList<>();
        historico.add(new Pedidos());
        historico.add(new Pedidos());

        loja.setHistoricoDeVendas(historico);

        ArrayList<Pedidos> historicoRetornado = loja.getHistoricoDeVendas();
        assertEquals(historico, historicoRetornado);
    }

}