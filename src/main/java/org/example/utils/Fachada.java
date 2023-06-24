package org.example.utils;

import org.example.entidades.Comprador;
import org.example.entidades.Loja;
import org.example.services.AuthService;
import org.example.services.DatabaseService;
import org.example.produto.Produto;
import org.example.repositorio.RepositorioComprador;
import org.example.repositorio.RepositorioLoja;
import org.example.utils.menus.comprador.MenuComprador;
import org.example.utils.menus.deslogado.MenuDeslogado;
import org.example.utils.menus.loja.MenuLoja;

import java.util.Scanner;

public class Fachada {
    public static void run() {
        //inicia os repositorios de comprador e de loja
        RepositorioComprador.getInstancia();
        RepositorioLoja.getInstancia();

        DatabaseService.readDatabaseCompradores();
        DatabaseService.readDatabaseLojas();

        int escolha = 0;
        while(escolha != 12){
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

        DatabaseService.writeDataBaseCompradores();
        DatabaseService.writeDataBaseLoja();

    }
    public static int menuUsuarioDeslogado(){
        int escolha;

        Scanner sc = new Scanner(System.in);

        MenuDeslogado.initialPage();

        try{
            escolha = sc.nextInt();
        }catch ( Exception e){
            escolha = 0;
        }
        sc.nextLine();

        switch (escolha) {
            //cadastra um usuario
            case 1 -> {
                try {
                    String tipoUsuario;
                    System.out.println("Digite o tipo de usuario que quer cadastrar (comprador / loja)");
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

            //excluir usuario
            case 3 -> {
                try{
                    String tipoUsuario;
                    String nomeUsuario;

                    System.out.println("Digite o tipo de usuario que quer excluir?");
                    tipoUsuario = sc.nextLine();

                    System.out.println("Digite o nome dd usuario que quer excluir");
                    nomeUsuario = sc.nextLine();

                    MenuDeslogado.deletePage(tipoUsuario, nomeUsuario);
                }catch (Exception exception){
                    System.out.println("Algum dos dados fornecidos não é válido");
                }
            }

            //fecha a aplicação
            case 12 -> {
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

        try{
            escolha = sc.nextInt();
        }catch ( Exception e){
            escolha = 0;
        }
        sc.nextLine();

        switch (escolha) {
            //lista todas as lojas
            case 1 -> {
                RepositorioLoja.listarLojas();
            }

            //pede o nome de uma loja e mostra todos os produtos dela
            case 2 -> {
                String nomeLoja;
                System.out.println("digite o nome da loja que deseja ver os produtos");
                nomeLoja = sc.nextLine();

                try{
                    Loja auxLoja = RepositorioLoja.getLojaPorNome(nomeLoja);
                    auxLoja.getEstoque().listarProdutos();
                }catch (Exception e){
                    System.out.println(e);
                }
            }

            //mostra todos os produtos de todas as lojas cadastradas
            case 3 -> {
                RepositorioLoja.listarTodosOsProdutos();
            }

            //ver itens do carrinho
            case 4 -> {
                try{
                    RepositorioComprador.getCompradorPorNome(AuthService.getInstancia().getNome()).getCarrinho().listarItemsCarrinho();
                }catch (Exception e){
                    System.out.println(e);
                }
            }

            //adiciona produtos no carrinho
            case 5 -> {
                String nomeLoja;
                String nomeProduto;
                int quantidade;

                try{

                    System.out.println("digite o nome da loja que possui o produto que vc deseja");
                    nomeLoja = sc.nextLine();

                    System.out.println("digite o nome do produto que vc deseja");
                    nomeProduto = sc.nextLine();

                    System.out.println("digite a quantidade do produto que vc deseja");
                    quantidade = sc.nextInt();
                    sc.nextLine();

                    Produto produto = RepositorioLoja.getLojaPorNome(nomeLoja).getEstoque().getProdutoPorNome(nomeProduto).getProduto();
                    RepositorioComprador.getCompradorPorNome(AuthService.getInstancia().getNome()).getCarrinho().inserirNoCarrinho(nomeLoja, produto, quantidade);
                }catch (Exception e){
                    System.out.println(e);
                }
            }

            //remove produtos do carrinho
            case 6 -> {
                String nomeLoja;
                String nomeProduto;
                int quantidade;

                try{

                    System.out.println("digite o nome da loja que possui o produto que vc deseja");
                    nomeLoja = sc.nextLine();

                    System.out.println("digite o nome do produto que vc deseja");
                    nomeProduto = sc.nextLine();

                    System.out.println("digite a quantidade do produto que vc deseja");
                    quantidade = sc.nextInt();
                    sc.nextLine();

                    Produto produto = RepositorioLoja.getLojaPorNome(nomeLoja).getEstoque().getProdutoPorNome(nomeProduto).getProduto();
                    RepositorioComprador.getCompradorPorNome(AuthService.getInstancia().getNome()).getCarrinho().removerDoCarrinho(nomeLoja, produto, quantidade);
                }catch (Exception e){
                    System.out.println(e);
                }
            }

            //finaliza compra
            case 7 -> {
                try {
                    RepositorioComprador.getCompradorPorNome(AuthService.getInstancia().getNome()).finalizarCompras();
                    System.out.println("compra finalizada");
                }catch (Exception e){
                    System.out.println(e);
                }
            }

            //Imprimir historico de compras
            case 8 -> {
                try {
                    RepositorioComprador.getCompradorPorNome(AuthService.getInstancia().getNome()).imprimirCompras();
                }catch (Exception e){
                    System.out.println(e);
                }
            }

/*
        System.out.println("9 - visualizar comentarios");        
        System.out.println("10 - avaliar pedidos");
*/
            //avaliar pedidos
            case 10 -> {
                try {
                  RepositorioComprador.getCompradorPorNome(AuthService.getInstancia().getNome()).avaliarPedidos();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }

            //desloga do aplicativo
            case 11 -> {
                AuthService.logout();
            }
            //fecha o aplicativo
            case 12 -> {
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

        MenuLoja.initialPage();

        try{
            escolha = sc.nextInt();
        }catch ( Exception e){
            escolha = 0;
        }
        sc.nextLine();

        switch (escolha) {
            //visualiza os produtos do estoque
            case 1 -> {
                lojaLogada.getEstoque().listarProdutos();
            }

            //adiciona produtos no estoque
            case 2 -> {
                MenuLoja.inserirProdutoNoEstoque(lojaLogada);
            }

            //remove produtos do estoque
            case 3 -> {
                MenuLoja.removerProdutoDoEstoque(lojaLogada);
            }
            //atualizar dados de produtos do estoque
            case 4 -> {
                MenuLoja.atualizarDadosDoProduto(lojaLogada);
            }
            //atualizar dados de produtos do estoque
            case 5 -> {
                lojaLogada.imprimirVendas();
            }

            //visualizar comentarios feitos sobre a loja
            case 6 -> {
                lojaLogada.imprimeComentarios();
            }

            //avaliar pedidos
            case 7 -> {
                try {
                  lojaLogada.avaliarPedidos();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }

            //ver avaliacao geral da loja
            case 8 -> {
                System.out.println("A loja é avaliada como: " + lojaLogada.getConceito());
            }
            //desloga do aplicativo
            case 11 -> {
                AuthService.logout();
            }
            //fecha o aplicativo
            case 12 -> {
                System.out.println("fechando sistema!");
            }

            default -> System.out.println("escolha inválida");
        }

        return escolha;
    }
}
