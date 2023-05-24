package org.example.repositorio;


import java.util.ArrayList;
import org.example.entidades.Comprador;

public class RepositorioComprador implements Repositorio{

    private static RepositorioComprador instanciaUnicaRepositorio = null;
    private static ArrayList<Comprador> listaCompradores;
    private static int ID;

    private RepositorioComprador(){
        int ID = 1;
        listaCompradores = new ArrayList<>();
    }

    public static RepositorioComprador getInstancia(){
        if(instanciaUnicaRepositorio == null){
            return instanciaUnicaRepositorio = new RepositorioComprador();
        }
        return instanciaUnicaRepositorio;
    }
    public static Comprador getCompradorPorID(int ID){
        Comprador compradorAuxiliar = null;
        for (Comprador listaCompradore : listaCompradores) {
            if (listaCompradore.getID() == ID) {
                compradorAuxiliar = listaCompradore;
                break;
            }
        }
        return compradorAuxiliar;
    }
    public static Comprador GetCompradoresPorCPF(String Cpf){
        Comprador compradorAuxiliar = null;
        for (Comprador listaCompradore : listaCompradores) {
            if (listaCompradore.getCpf().equals(Cpf)) {
                compradorAuxiliar = listaCompradore;
                break;
            }
        }
        return compradorAuxiliar;
    }
//    public static void inserir(String nome, String email, String senha, String cpf, String endereco, Carrinho carrinhoDeCompras, ArrayList<Pedido> historicoPedidos) {
//        listaCompradores.add(new Comprador(nome, email, senha, cpf, endereco, ID, carrinhoDeCompras, historicoPedidos));
//        ID++;
//    }
    public static void inserir(String nome, String email, String senha, String cpf, String endereco) {
        listaCompradores.add(new Comprador(nome, email, senha, cpf, endereco, ID));
        ID++;
    }
    public static void removerPorCpf(String Cpf) {
        for (int i = 0; i < listaCompradores.size(); i++) {
            if(listaCompradores.get(i).getCpf().equals(Cpf)){
                listaCompradores.remove(i);
                break;
            }
        }
    }
    public static void removerPorID(int ID) {
        for (int i = 0; i < listaCompradores.size(); i++) {
            if(listaCompradores.get(i).getID() == ID){
                listaCompradores.remove(i);
                break;
            }
        }
    }
    public static void listar(){
        for (Comprador listaCompradore : listaCompradores) {
            System.out.println(listaCompradore);
        }
    }
}
