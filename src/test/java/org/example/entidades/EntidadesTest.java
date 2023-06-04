package org.example.entidades;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.*;

public class EntidadesTest extends TestCase {
    @Test
    public void testarMetodoDaClasseEntidades() {
        Entidades entidade = new Entidades();

        assertNotNull(entidade);
    }
}