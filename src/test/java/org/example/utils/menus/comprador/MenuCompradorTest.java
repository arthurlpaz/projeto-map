package org.example.utils.menus.comprador;

import junit.framework.TestCase;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class MenuCompradorTest extends TestCase {

    @Test
    public void testInitialPage() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        MenuComprador.initialPage();

        String expectedOutput = "Escolha a opção\r\n" +
                "1 - visualizar lojas\r\n" +
                "2 - visualizar produtos de uma loja especifica\r\n" +
                "3 - visualizar todos os produtos\r\n" +
                "8 - Fazer logout\r\n" +
                "9 - Fechar sistema\r\n";

        assertEquals(expectedOutput, outContent.toString());
    }
}