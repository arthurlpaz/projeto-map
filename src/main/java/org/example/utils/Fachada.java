package org.example.utils;

import org.example.entidades.Loja;
import org.example.services.AuthService;
import org.example.produto.Produto;
import org.example.repositorio.RepositorioComprador;
import org.example.repositorio.RepositorioLoja;
import org.example.utils.menus.comprador.MenuComprador;
import org.example.utils.menus.deslogado.MenuDeslogado;
import org.example.utils.menus.loja.MenuLoja;

import java.util.Scanner;

public class Fachada {
    public static void main(String[] args) {
        //inicia os repositorios de comprador e de loja
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
            //cadastra um usuario
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

            //faz login no sistema
            case 2 ->{
                try{
                    MenuDeslogado.loginPage();
                }catch (Exception exception){
                    System.out.println("Algum dos dados fornecidos não é válido");
                }
            }

            //fecha a aplicação
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
            //lista todas as lojas
            case 1 -> {
                RepositorioLoja.listarLojas();
            }

            //pede o nome de uma loja e mostra todos os produtos dela
            case 2 -> {
                String nomeLoja;
                nomeLoja = sc.nextLine();

                Loja auxLoja = RepositorioLoja.getLojaPorNome(nomeLoja);
                auxLoja.listaProdutos();
            }

            //mostra todos os produtos de todas as lojas cadastradas
            case 3 -> {
                RepositorioLoja.listarTodosOsProdutos();
            }

            //desloga do aplicativo
            case 8 -> {
                AuthService.logout();
            }
            //fecha o aplicativo
            case 9 -> {
                System.out.println("fechando sistema!");
            }

            default -> System.out.println("escolha inválida");
        }

        return escolha;
    }
    public static int menuLoja() throws Exception {
        Loja lojaLogada;
        try {
            lojaLogada = (Loja) AuthService.getInstancia();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        int escolha;

        Scanner sc = new Scanner(System.in);

        MenuComprador.initialPage();

        escolha = sc.nextInt();
        sc.nextLine();

        switch (escolha) {
            //visualiza os produtos do estoque
            case 1 -> {
                lojaLogada.listaProdutos();
            }

            //adiciona produtos no estoque
            case 2 -> {
                String nome;
                double valor;
                String tipo;
                String marca;
                String descricao;
                int quantidade;

                System.out.println("insira os dados: nome");
                nome = sc.nextLine();

                System.out.println("insira os dados: valor");
                valor = sc.nextDouble();

                System.out.println("insira os dados: tipo");
                tipo = sc.nextLine();

                System.out.println("insira os dados: marca");
                marca = sc.nextLine();

                System.out.println("insira os dados: descricao");
                descricao = sc.nextLine();

                System.out.println("insira os dados: quantidade");
                quantidade = sc.nextInt();

                if(nome.equals("") || tipo.equals("") || marca.equals("")){
                    throw new Exception("algum dado foi preenchido incorretamente");
                }
                if(nome.equals(" ") || tipo.equals(" ") || marca.equals(" ")){
                    throw new Exception("algum dado foi preenchido incorretamente");
                }
                lojaLogada.getEstoque().inserir(nome, valor, tipo, marca, descricao, quantidade);
            }

            //remove produtos do estoque
            case 3 -> {
                String nome;
                int quantidade;
                System.out.println("digite o nome do produto de que deseja remover");
                nome = sc.nextLine();
                System.out.println("digite a quantidade do produto de que deseja remover");
                quantidade = sc.nextInt();

                lojaLogada.getEstoque().removerPorNome(nome, quantidade);
            }
            //atualizar dados de produtos do estoque
            case 4 -> {
//                lojaLogada.
            }

            //desloga do aplicativo
            case 8 -> {
                AuthService.logout();
            }
            //fecha o aplicativo
            case 9 -> {
                System.out.println("fechando sistema!");
            }

            default -> System.out.println("escolha inválida");
        }

        return escolha;
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
}
