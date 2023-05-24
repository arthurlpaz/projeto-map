package org.example.repositorio;

import org.example.entidades.Loja;
import org.example.produto.Estoque;

import java.util.ArrayList;

public class RepositorioLoja {

    private static RepositorioLoja instanciaUnicaRepositorio = null;
    private static ArrayList<Loja> listaLojas;
    private static int ID;

    private RepositorioLoja(){
        int ID = 1;
        listaLojas = new ArrayList<>();
    }

    public static RepositorioLoja getInstancia(){
        if(instanciaUnicaRepositorio == null){
            return instanciaUnicaRepositorio = new RepositorioLoja();
        }
        return instanciaUnicaRepositorio;
    }
    public static Loja getLojaPorID(int ID){
        Loja lojaAuxiliar = null;
        for (Loja loja : listaLojas) {
            if (loja.getID() == ID) {
                lojaAuxiliar = loja;
                break;
            }
        }
        return lojaAuxiliar;
    }
    public static Loja getLojaPorCPF(String Cpf){
        Loja lojaAuxiliar = null;
        for (Loja loja : listaLojas) {
            if (loja.getCpf().equals(Cpf)) {
                lojaAuxiliar = loja;
                break;
            }
        }
        return lojaAuxiliar;
    }
//    public static void inserir(String nome, String email, String senha, String cpf, String endereco, Estoque estoque, ArrayList<Pedido> historicoPedidos) {
//        listaLojas.add(new Loja(nome, email, senha, cpf, endereco, ID, estoque, historicoPedidos));
//        ID++;
//    }
    public static void inserir(String nome, String email, String senha, String cpf, String endereco, Estoque estoque) {
        listaLojas.add(new Loja(nome, email, senha, cpf, endereco, ID, estoque));
        ID++;
    }
    public static void removerPorCpf(String Cpf) {
        for (int i = 0; i < listaLojas.size(); i++) {
            if(listaLojas.get(i).getCpf().equals(Cpf)){
                listaLojas.remove(i);
                break;
            }
        }
    }
    public static void removerPorID(int ID) {
        for (int i = 0; i < listaLojas.size(); i++) {
            if(listaLojas.get(i).getID() == ID){
                listaLojas.remove(i);
                break;
            }
        }
    }
    public static void listar(){
        for (Loja loja : listaLojas) {
            System.out.println(loja);
        }
    }
}
