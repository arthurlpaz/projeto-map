package org.example;

import org.example.entidades.Comprador;
import org.example.repositorio.RepositorioComprador;

public class Fachada {
    public static void main(String[] args) {
        RepositorioComprador.getInstancia();

        criarUsuario();
        criarUsuario();
        criarUsuario();
        criarUsuario();
        criarUsuario();

        listarUsuarios();
    }

    public static void criarUsuario(){
        RepositorioComprador.inserir("a","a","a","a","a",null, null);
    }
    public static void listarUsuarios() {
        RepositorioComprador.listar();
    }
}
