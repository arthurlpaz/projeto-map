package org.example.utils;

import org.example.services.AuthService;
import org.example.produto.Produto;
import org.example.repositorio.RepositorioComprador;
import org.example.repositorio.RepositorioLoja;
import org.example.utils.menus.comprador.MenuComprador;
import org.example.utils.menus.deslogado.MenuDeslogado;

import java.util.Scanner;

public class Fachada {
    public static void main(String[] args) {
        RepositorioComprador.getInstancia();
        RepositorioLoja.getInstancia();

        int escolha = 0;
        while(escolha != 9){
            if(AuthService.isLogged()){
                try{
                    if(AuthService.tipoUsuario().equals("org.example.entidades.Comprador")){
                        escolha = menuComprador();
                    }else if(AuthService.tipoUsuario().equals("org.example.entidades.Loja")){
                        escolha = menuLoja();
                    }else{
                        System.out.println("Tipo de usuario nao identificado");
                    }
                }catch (Exception e){
                    System.out.println(e);
                }
            }
            else{
                escolha = menuUsuarioDeslogado();
            }
        }
    }
    public static int menuUsuarioDeslogado(){
        int escolha;

        Scanner sc = new Scanner(System.in);

        MenuDeslogado.initialPage();

        escolha = sc.nextInt();
        sc.nextLine();

        switch (escolha) {
            case 1 -> {
                try {
                    String tipoUsuario;
                    System.out.println("Digite o tipo de usuario que quer cadastrar");
                    tipoUsuario = sc.nextLine();
                    MenuDeslogado.registerPage(tipoUsuario);
                }
                catch (Exception exception){
                    System.out.println("Algum dos dados fornecidos não é válido");
                }
            }

            case 2 ->{
                try{
                    MenuDeslogado.loginPage();
                }catch (Exception exception){
                    System.out.println("Algum dos dados fornecidos não é válido");
                }
            }

            case 9 -> {
                System.out.println("fechando sistema!");
            }

            default -> System.out.println("escolha inválida");
        }

        return escolha;
    }
    public static int menuComprador(){
        int escolha;

        Scanner sc = new Scanner(System.in);

        MenuComprador.initialPage();

        escolha = sc.nextInt();
        sc.nextLine();

        switch (escolha) {
            case 1 -> {
                try {
                    String tipoUsuario;
                    System.out.println("Digite o tipo de usuario que quer cadastrar");
                    tipoUsuario = sc.nextLine();
                    MenuDeslogado.registerPage(tipoUsuario);
                }
                catch (Exception exception){
                    System.out.println("Algum dos dados fornecidos não é válido");
                }
            }

            case 2 ->{
                try{
                    MenuDeslogado.loginPage();
                }catch (Exception exception){
                    System.out.println("Algum dos dados fornecidos não é válido");
                }
            }

            case 9 -> {
                System.out.println("fechando sistema!");
            }

            default -> System.out.println("escolha inválida");
        }

        return escolha;
    }
    public static int menuLoja(){
        System.out.println("");
        return 2;
    }
    public static void criarComprador(String nome, String email, String senha, String cpf, String endereco){
        try {
            RepositorioComprador.inserir(nome, email, senha, cpf, endereco);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void criarLoja(String nome, String email, String senha, String cpf, String endereco){
        try {
            RepositorioLoja.inserir(nome, email, senha, cpf, endereco, null);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void listarLojas(){
        RepositorioLoja.listar();
    }
    public static void adicionarProdutoALoja(Produto produto){

    }
}
