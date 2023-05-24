package org.example.utils;

import org.example.entidades.Comprador;
import org.example.produto.Produto;
import org.example.repositorio.RepositorioComprador;
import org.example.repositorio.RepositorioLoja;

public class Fachada {
    public static void run() {
        RepositorioComprador.getInstancia();
        RepositorioLoja.getInstancia();


        Produto testeProduto = new Produto("b",5.65,"b","b","b", 1);
    }

    public static void criarComprador(String nome, String email, String senha, String cpf, String endereco){
        RepositorioComprador.inserir(nome, email, senha, cpf, endereco);
    }
    public static void criarLoja(String nome, String email, String senha, String cpf, String endereco){
        RepositorioLoja.inserir(nome, email, senha, cpf, endereco, null);
    }

    public static void listarLojas(){
        RepositorioLoja.listar();
    }
    public static void adicionarProdutoALoja(Produto produto){

    }
}
