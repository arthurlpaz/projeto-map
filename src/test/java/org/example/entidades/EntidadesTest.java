package org.example.entidades;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class EntidadesTest extends TestCase {
    @Test
    public void testarMetodoDaClasseEntidades() {
        Entidades entidade = new Entidades("a", "a", "a", "a", "a", 2);
        assertNotNull(entidade);
    }

    @Test
    public void testGetNome() {
        Entidades entidade = new Entidades("João", "joao@example.com", "senha123", "123456789", "Rua A", 1);
        String nome = entidade.getNome();
        assertEquals("João", nome);
    }

    @Test
    public void testSetNome() {
        Entidades entidade = new Entidades("Maria", "maria@example.com", "senha456", "987654321", "Rua B", 2);
        entidade.setNome("Mariana");
        String novoNome = entidade.getNome();
        Assert.assertEquals("Mariana", novoNome);
    }

    @Test
    public void testGetEmail() {
        Entidades entidade = new Entidades("João", "joao@example.com", "senha123", "123456789", "Rua A", 1);
        String email = entidade.getEmail();
        Assert.assertEquals("joao@example.com", email);
    }

    @Test
    public void testSetEmail() {
        Entidades entidade = new Entidades("Maria", "maria@example.com", "senha456", "987654321", "Rua B", 2);
        entidade.setEmail("novoemail@example.com");
        String novoEmail = entidade.getEmail();
        assertEquals("novoemail@example.com", novoEmail);
    }

    @Test
    public void testGetSenha(){
        Entidades entidade = new Entidades("Pedro", "pedro@example.com", "senha789", "555555555", "Rua C", 3);
        String senha = entidade.getSenha();
        assertEquals("senha789", senha);
    }

    @Test
    public void testSetSenha() {
        Entidades entidade = new Entidades("Pedro", "pedro@example.com", "senha789", "555555555", "Rua C", 3);
        entidade.setSenha("novasenha");
        String novaSenha = entidade.getSenha();
        assertEquals("novasenha", novaSenha);
    }

    @Test
    public void testGetCpf() {
        Entidades entidade = new Entidades("João", "joao@example.com", "senha123", "123456789", "Rua A", 1);
        String cpf = entidade.getCpf();
        assertEquals("123456789", cpf);
    }

    @Test
    public void testSetCpf() {
        Entidades entidade = new Entidades("Maria", "maria@example.com", "senha456", "987654321", "Rua B", 2);
        entidade.setCpf("987654321");
        String novoCpf = entidade.getCpf();
        Assert.assertEquals("987654321", novoCpf);
    }

    @Test
    public void testGetEndereco() {
        Entidades entidade = new Entidades("Maria", "maria@example.com", "senha456", "987654321", "Rua B", 2);
        String endereco = entidade.getEndereco();
        assertEquals("Rua B", endereco);
    }

    @Test
    public void testSetEndereco() {
        Entidades entidade = new Entidades("Maria", "maria@example.com", "senha456", "987654321", "Rua B", 2);
        entidade.setEndereco("Avenida X");
        String novoEndereco = entidade.getEndereco();
        assertEquals("Avenida X", novoEndereco);
    }

    @Test
    public void testSetID() {
        Entidades entidade = new Entidades("Pedro", "pedro@example.com", "senha789", "555555555", "Rua C", 3);
        entidade.setID(4);
        int novoID = entidade.getID();
        assertEquals(4, novoID);
    }

    @Test
    public void testToString() {
        Entidades entidade = new Entidades("Pedro", "pedro@example.com", "senha789", "555555555", "Rua C", 3);
        String expectedString = "nome -> Pedro | email -> pedro@example.com | endereco -> Rua C | ID -> 3";
        String compradorString = entidade.toString();
        assertEquals(expectedString, compradorString);
    }

    @Test
    public void testEntidade() {
        Entidades entidade = new Entidades("Ana", "ana@example.com", "senha987", "987654321", "Rua D", 5);
        assertEquals("Ana", entidade.getNome());
        assertEquals("ana@example.com", entidade.getEmail());
        assertEquals("senha987", entidade.getSenha());
        assertEquals("987654321", entidade.getCpf());
        assertEquals("Rua D", entidade.getEndereco());
        assertEquals(5, entidade.getID());
    }
}