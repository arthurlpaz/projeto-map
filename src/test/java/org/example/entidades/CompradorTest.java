package org.example.entidades;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class CompradorTest extends TestCase {
    @Test
    public void testGetNome() {
        Comprador comprador = new Comprador("João", "joao@example.com", "senha123", "123456789", "Rua A", 1);
        String nome = comprador.getNome();
        assertEquals("João", nome);
    }

    @Test
    public void testSetNome() {
        Comprador comprador = new Comprador("Maria", "maria@example.com", "senha456", "987654321", "Rua B", 2);
        comprador.setNome("Mariana");
        String novoNome = comprador.getNome();
        Assert.assertEquals("Mariana", novoNome);
    }

    @Test
    public void testGetEmail() {
        Comprador comprador = new Comprador("João", "joao@example.com", "senha123", "123456789", "Rua A", 1);
        String email = comprador.getEmail();
        Assert.assertEquals("joao@example.com", email);
    }

    @Test
    public void testSetEmail() {
        Comprador comprador = new Comprador("Maria", "maria@example.com", "senha456", "987654321", "Rua B", 2);
        comprador.setEmail("novoemail@example.com");
        String novoEmail = comprador.getEmail();
        assertEquals("novoemail@example.com", novoEmail);
    }

    @Test
    public void testGetSenha(){
        Comprador comprador = new Comprador("Pedro", "pedro@example.com", "senha789", "555555555", "Rua C", 3);
        String senha = comprador.getSenha();
        assertEquals("senha789", senha);
    }

    @Test
    public void testSetSenha() {
        Comprador comprador = new Comprador("Pedro", "pedro@example.com", "senha789", "555555555", "Rua C", 3);
        comprador.setSenha("novasenha");
        String novaSenha = comprador.getSenha();
        assertEquals("novasenha", novaSenha);
    }

    @Test
    public void testGetCpf() {
        Comprador comprador = new Comprador("João", "joao@example.com", "senha123", "123456789", "Rua A", 1);
        String cpf = comprador.getCpf();
        assertEquals("123456789", cpf);
    }

    @Test
    public void testSetCpf() {
        Comprador comprador = new Comprador("Maria", "maria@example.com", "senha456", "987654321", "Rua B", 2);
        comprador.setCpf("987654321");
        String novoCpf = comprador.getCpf();
        Assert.assertEquals("987654321", novoCpf);
    }

    @Test
    public void testGetEndereco() {
        Comprador comprador = new Comprador("Maria", "maria@example.com", "senha456", "987654321", "Rua B", 2);
        String endereco = comprador.getEndereco();
        assertEquals("Rua B", endereco);
    }

    @Test
    public void testSetEndereco() {
        Comprador comprador = new Comprador("Maria", "maria@example.com", "senha456", "987654321", "Rua B", 2);
        comprador.setEndereco("Avenida X");
        String novoEndereco = comprador.getEndereco();
        assertEquals("Avenida X", novoEndereco);
    }

    @Test
    public void testSetID() {
        Comprador comprador = new Comprador("Pedro", "pedro@example.com", "senha789", "555555555", "Rua C", 3);
        comprador.setID(4);
        int novoID = comprador.getID();
        assertEquals(4, novoID);
    }

    @Test
    public void testToString() {
        Comprador comprador = new Comprador("Pedro", "pedro@example.com", "senha789", "555555555", "Rua C", 3);
        String expectedString = "nome do comprador -> Pedro email -> pedro@example.com endereco -> Rua C ID -> 3";
        String compradorString = comprador.toString();
        assertEquals(expectedString, compradorString);
    }

    @Test
    public void testComprador() {
        Comprador comprador = new Comprador("Ana", "ana@example.com", "senha987", "987654321", "Rua D", 5);
        assertEquals("Ana", comprador.getNome());
        assertEquals("ana@example.com", comprador.getEmail());
        assertEquals("senha987", comprador.getSenha());
        assertEquals("987654321", comprador.getCpf());
        assertEquals("Rua D", comprador.getEndereco());
        assertEquals(5, comprador.getID());
    }

    @Test
    public void testEquals() {
        Comprador comprador1 = new Comprador("Ana", "ana@example.com", "senha987", "987654321", "Rua D", 4);
        Comprador comprador2 = new Comprador("Ana", "ana@example.com", "senha987", "987654321", "Rua D", 4);
        Comprador comprador3 = new Comprador("João", "joao@example.com", "senha123", "123456789", "Rua A", 1);

        System.out.println(comprador1.equals(comprador3));
        assertFalse(comprador1.equals(comprador3));

        System.out.println(comprador1.equals(comprador3));
    }
}