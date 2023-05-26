package org.example.repositorio;

import junit.framework.TestCase;
import org.junit.Before;

public class RepositorioLojaTest extends TestCase {
    private RepositorioLoja repositorio;

    @Before
    public void setUp(){ repositorio = RepositorioLoja.getInstancia(); }
}