package org.example.repositorio;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.*;

// Neste caso, não temos uma implementação concreta da interface,
// então não é possível testar o comportamento real do método
// Apenas verificamos se não ocorreu uma exceção ao chamar o método
public class RepositorioTest extends TestCase {
    @Test
    public void testInserir() {
        Repositorio.inserir();
    }

    @Test
    public void testRemoverPorCpf() {
        Repositorio.removerPorCpf();
    }

    @Test
    public void testRemoverPorID() {
        Repositorio.removerPorID();
    }

}