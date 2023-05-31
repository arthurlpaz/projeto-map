package org.example.repositorio;

import org.example.entidades.Comprador;
import org.example.entidades.Entidades;
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
    public static Loja getLojaPorNome(String nome){
        Loja lojaAuxiliar = null;
        for (Loja loja : listaLojas) {
            if (loja.getCpf().equals(nome)) {
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
    public static void inserir(String nome, String email, String senha, String cpf, String endereco, Estoque estoque) throws Exception {
        for (Loja loja : listaLojas) {
            if(loja.getNome().equals(nome)){
                throw new Exception("já existe um usuario com esse nome no sistema");
            }
            if(loja.getEmail().equals(email)){
                throw new Exception("Email ja cadastrado no sistema");
            }
            if(loja.getCpf().equals(cpf)){
                throw new Exception("CPF ja cadastrado no sistema");
            }
        }
        listaLojas.add(new Loja(nome, email, senha, cpf, endereco, ID, estoque));
        ID++;
    }
    public static void inserir(Loja newLoja){
        listaLojas.add(newLoja);
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
    public static void listarLojas(){
        for (Loja loja : listaLojas) {
            System.out.println(loja);
        }
    }

    public static void listarTodosOsProdutos(){
        for (Loja loja : listaLojas) {
            System.out.println("Loja: " + loja.getNome());
            loja.getEstoque().listarProdutos();
        }
    }

    public static ArrayList<Loja> getListaLojas() {
        return listaLojas;
    }

    public static void setListaLojas(ArrayList<Loja> listaLojas) {
        RepositorioLoja.listaLojas = listaLojas;
    }

}
