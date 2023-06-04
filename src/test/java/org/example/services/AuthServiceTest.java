package org.example.services;

import junit.framework.TestCase;
import org.example.entidades.Comprador;
import org.example.entidades.Loja;
import org.example.produto.Estoque;
import org.example.repositorio.RepositorioComprador;
import org.example.repositorio.RepositorioLoja;
import org.example.repositorio.RepositorioLojaTest;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertThrows;

public class AuthServiceTest extends TestCase {

    @Before
    public void setUp() {
        try{
            RepositorioLoja.getInstancia();
            RepositorioComprador.getInstancia();

            RepositorioLoja.inserir("testeLoja", "testeLoja@email.com", "12345", "11111111111", "enderecoTeste", null);

            RepositorioComprador.inserir("testeComprador", "testeComprador@email.com", "12345", "11111111111", "enderecoTeste");
        }catch (Exception e){
        }
    }

    @Test
    public void testGetInstanciaNull() {
        assertThrows(Exception.class,
                () -> {
                    AuthService.getInstancia();
                });
    }

    @Test
    public void testGetInstanciaLoja() {
        try{
            AuthService.login("testeLoja", "loja");
        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            assertEquals("org.example.entidades.Loja", AuthService.getInstancia().getClass().getName());
        }catch (Exception e){
            e.printStackTrace();
        }

        AuthService.logout();
    }

    @Test
    public void testGetInstanciaComprador() {
        try{
            AuthService.login("testeComprador", "comprador");
        }catch (Exception e){
            e.printStackTrace();
        }

        try{
            assertEquals("org.example.entidades.Comprador", AuthService.getInstancia().getClass().getName());
        }catch (Exception e){
            e.printStackTrace();
        }

        AuthService.logout();
    }
    @Test
    public void testLogout() {
        try{
            AuthService.login("testeLoja", "loja");
        }catch (Exception e){
            e.printStackTrace();
        }

        try{
            AuthService.logout();
        }catch (Exception e){
            e.printStackTrace();
        }

        assertThrows(Exception.class,
            () -> {
                AuthService.getInstancia();
            });
    }

    @Test
    public void testIsLoggedFalse() {
        assertFalse(AuthService.isLogged());
    }

    @Test
    public void testIsLoggedTrue() {
        try {
            AuthService.login("testeLoja", "loja");
        }catch (Exception e){
            e.printStackTrace();
        }
        assertTrue(AuthService.isLogged());

        AuthService.logout();
    }

    @Test
    public void testTipoUsuarioNull() {
        assertThrows(Exception.class,
            () -> {
                AuthService.tipoUsuario();
            });
    }

    @Test
    public void testTipoUsuarioLoja() {
        try {
            AuthService.login("testeLoja", "loja");
        }catch (Exception e){
            e.printStackTrace();
        }

        try{
            assertEquals("org.example.entidades.Loja", AuthService.tipoUsuario());
        }catch (Exception e){
            e.printStackTrace();
        }

        AuthService.logout();
    }

    @Test
    public void testTipoUsuarioComprador() {
        try {
            AuthService.login("testeComprador", "comprador");
        }catch (Exception e){
            e.printStackTrace();
        }

        try{
            assertEquals("org.example.entidades.Comprador", AuthService.tipoUsuario());
        }catch (Exception e){
            e.printStackTrace();
        }

        AuthService.logout();
    }

    @Test
    public void testLoginUserNaoEncontrado(){
        assertThrows(Exception.class,
                () -> {
                    AuthService.login("nao existe", "nao existe");
                });
    }

    @Test
    public void testLoginCompradorInexistente(){
        assertThrows(Exception.class,
                () -> {
                    AuthService.login("nao existe", "comprador");
                });
    }

    @Test
    public void testLoginLojaInexistente(){
        assertThrows(Exception.class,
                () -> {
                    AuthService.login("nao existe", "loja");
                });
    }

    @Test
    public void testLoginCompradorExistente(){
        try {
            AuthService.login("testeComprador", "comprador");
        }catch (Exception e){
            e.printStackTrace();
        }

        try{
            assertTrue(AuthService.tipoUsuario().equals("org.example.entidades.Comprador"));
        }catch (Exception e){
            e.printStackTrace();
        }

        AuthService.logout();
    }

    @Test
    public void testLoginLojaExistente(){
        try {
            AuthService.login("testeLoja", "loja");
        }catch (Exception e){
            e.printStackTrace();
        }

        Loja auxLoja = new Loja("testeLoja", "testeLoja@email.com", "12345", "11111111111", "enderecoTeste", 0,null);

        try{
            assertTrue(AuthService.tipoUsuario().equals("org.example.entidades.Loja"));
        }catch (Exception e){
            e.printStackTrace();
        }

        AuthService.logout();
    }
}