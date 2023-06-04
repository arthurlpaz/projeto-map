package org.example.utils.menus.loja;

import org.example.entidades.Loja;
import org.example.repositorio.RepositorioLoja;

import java.util.Scanner;

public class MenuLoja {
    public static void initialPage(){
        System.out.println("Escolha a opção");
        System.out.println("1 - visualizar produtos em estoque");
        System.out.println("2 - adicionar produtos ao estoque");
        System.out.println("3 - remover produtos do estoque");
        System.out.println("4 - atualizar dados de produtos");
        System.out.println("8 - Fazer logout");
        System.out.println("9 - Fechar sistema");
    }

    public static void inserirProdutoNoEstoque(org.example.entidades.Loja lojaLogada) throws Exception {
        Scanner sc = new Scanner(System.in);

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
        sc.nextLine();

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

    public static void removerProdutoDoEstoque(Loja lojaLogada) {
        Scanner sc = new Scanner(System.in);

        String nome;
        int quantidade;
        System.out.println("digite o nome do produto de que deseja remover");
        nome = sc.nextLine();
        System.out.println("digite a quantidade do produto de que deseja remover");
        quantidade = sc.nextInt();

        try{
            lojaLogada.getEstoque().removerPorNome(nome, quantidade);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void atualizarDadosDoProduto(Loja lojaLogada) {
        Scanner sc = new Scanner(System.in);
        lojaLogada.getEstoque().listarProdutos();

        int ID_produto;
        System.out.println("digite o ID do produto que voce deseja alterar");
        ID_produto = sc.nextInt();

        String nome;
        double valor;
        String tipo;
        String marca;
        String descricao;

        System.out.println("insira os dados: nome");
        nome = sc.nextLine();

        System.out.println("insira os dados: valor");
        valor = sc.nextDouble();
        sc.nextLine();

        System.out.println("insira os dados: tipo");
        tipo = sc.nextLine();

        System.out.println("insira os dados: marca");
        marca = sc.nextLine();

        System.out.println("insira os dados: descricao");
        descricao = sc.nextLine();

        try {
            lojaLogada.getEstoque().getProdutoPorID(ID_produto).getProduto().setNome(nome);
            lojaLogada.getEstoque().getProdutoPorID(ID_produto).getProduto().setValor(valor);
            lojaLogada.getEstoque().getProdutoPorID(ID_produto).getProduto().setTipo(tipo);
            lojaLogada.getEstoque().getProdutoPorID(ID_produto).getProduto().setMarca(marca);
            lojaLogada.getEstoque().getProdutoPorID(ID_produto).getProduto().setDescricao(descricao);
        }catch (Exception e){
            System.out.println(e);
        }

    }
}
