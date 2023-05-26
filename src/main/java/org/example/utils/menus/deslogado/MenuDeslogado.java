package org.example.utils.menus.deslogado;

import org.example.services.AuthService;
import org.example.repositorio.RepositorioComprador;
import org.example.repositorio.RepositorioLoja;

import java.util.Scanner;

public class MenuDeslogado {
    public static void initialPage(){
        System.out.println("Escolha a opção");
        System.out.println("1 - Fazer cadastro no sistema");
        System.out.println("2 - Fazer login");
        System.out.println("9 - Fechar sistema");
    }
    public static void registerPage(String tipoUsuario) throws Exception {
        if(tipoUsuario.equals("comprador")){
            registerPageComprador();
        } else if (tipoUsuario.equals("loja")) {
            registerPageLoja();
        }else{
            throw new Exception("Tipo de usuario nao identificado");
        }
    }

    //TODO
    public static void deletePage(){

    }

    public static void registerPageComprador() throws Exception {
        Scanner sc = new Scanner(System.in);

        String nome;
        String email;
        String senha;
        String cpf;
        String endereco;

        System.out.println("insira os dados: Nome");
        nome = sc.nextLine();

        System.out.println("insira os dados: Email");
        email = sc.nextLine();

        System.out.println("insira os dados: Senha");
        senha = sc.nextLine();

        System.out.println("insira os dados: Cpf");
        cpf = sc.nextLine();

        System.out.println("insira os dados: Endereco");
        endereco = sc.nextLine();

        if(nome.equals("") || senha.equals("") || cpf.equals("") || email.equals("") || endereco.equals("")){
            throw new Exception();
        }
        if(nome.equals(" ") || senha.equals(" ") || cpf.equals(" ") || email.equals(" ") || endereco.equals(" ")){
            throw new Exception();
        }

        RepositorioComprador.inserir(nome,email,senha,cpf,endereco);
    }

    public static void registerPageLoja() throws Exception {
        Scanner sc = new Scanner(System.in);

        String nome;
        String email;
        String senha;
        String cpf;
        String endereco;

        System.out.println("insira os dados: Nome");
        nome = sc.nextLine();

        System.out.println("insira os dados: Email");
        email = sc.nextLine();

        System.out.println("insira os dados: Senha");
        senha = sc.nextLine();

        System.out.println("insira os dados: Cpf");
        cpf = sc.nextLine();

        System.out.println("insira os dados: Endereco");
        endereco = sc.nextLine();

        if(nome.equals("") || senha.equals("") || cpf.equals("") || email.equals("") || endereco.equals("")){
            throw new Exception("Algum dado nao foi fornecido corretamente");
        }
        if(nome.equals(" ") || senha.equals(" ") || cpf.equals(" ") || email.equals(" ") || endereco.equals(" ")){
            throw new Exception("Algum dado nao foi fornecido corretamente");
        }

        RepositorioLoja.inserir(nome,email,senha,cpf,endereco,null);
    }

    public static void loginPage() throws Exception {
        Scanner sc = new Scanner(System.in);

        String nome;
        String tipoUsuario;

        System.out.println("insira os dados: Tipo de usuario que vai logar ");
        tipoUsuario = sc.nextLine();
        System.out.println("insira os dados: nome" );
        nome = sc.nextLine();

        AuthService.login(nome, tipoUsuario);
    }
}
