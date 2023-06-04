package org.example.entidades;

import junit.framework.TestCase;
import org.example.produto.Estoque;
import org.junit.Before;
import org.junit.Test;

public class LojaTest extends TestCase {

    private Loja loja;
    private Estoque estoque;
    @Before
    public void setUp() {
        estoque = new Estoque();
        loja = new Loja("Minha Loja", "loja@example.com", "senha123", "123456789", "Rua Principal", 1, estoque);
    }

    @Test
    public void testLoja() {
        String nome = "Minha Loja";
        String email = "loja@example.com";
        String senha = "senha123";
        String cpf = "123456789";
        String endereco = "Rua Principal";
        int id = 1;

        Loja loja = new Loja();

        assertEquals(nome, loja.getNome());
        assertEquals(email, loja.getEmail());
        assertEquals(senha, loja.getSenha());
        assertEquals(cpf, loja.getCpf());
        assertEquals(endereco, loja.getEndereco());
        assertEquals(id, loja.getID());
        assertNotNull(loja.getEstoque());
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
        String stringEsperada = "nome da loja-> Minha Loja email -> loja@example.com endereco -> Rua Principal ID -> 1";
        String stringAtual = loja.toString();
        assertEquals(stringEsperada, stringAtual);
    }

}