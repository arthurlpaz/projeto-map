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
        for (Comprador listaComprador : listaCompradores) {
            if (listaComprador.getID() == ID) {
                compradorAuxiliar = listaComprador;
                break;
            }
        }
        return compradorAuxiliar;
    }
    public static Comprador getCompradorPorNome(String nome) throws Exception{
        Comprador compradorAuxiliar = null;
        for (Comprador listaComprador : listaCompradores) {
            if (listaComprador.getNome().equals(nome)) {
                return compradorAuxiliar = listaComprador;
            }
        }
        throw new Exception("Usuario nao encontrado");
    }
    public static Comprador getCompradoresPorCPF(String Cpf){
        Comprador compradorAuxiliar = null;
        for (Comprador listaComprador : listaCompradores) {
            if (listaComprador.getCpf().equals(Cpf)) {
                compradorAuxiliar = listaComprador;
                break;
            }
        }
        return compradorAuxiliar;
    }

    public static void inserir(Comprador newComprador){
        listaCompradores.add(newComprador);
        if(newComprador.getID() >= ID){
            ID = newComprador.getID() + 1;
        }
    }

    public static void inserir(String nome, String email, String senha, String cpf, String endereco) throws Exception {
        for (Comprador listaComprador : listaCompradores) {
            if(listaComprador.getNome().equals(nome)){
                throw new Exception("já existe um usuario com esse nome no sistema");
            }
            if(listaComprador.getEmail().equals(email)){
                throw new Exception("Email ja cadastrado no sistema");
            }
            if(listaComprador.getCpf().equals(cpf)){
                throw new Exception("CPF ja cadastrado no sistema");
            }
        }
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

    public static void removerPorNome(String nome) {
        for (int i = 0; i < listaCompradores.size(); i++) {
            if(listaCompradores.get(i).getNome().equals(nome)){
                listaCompradores.remove(i);
                break;
            }
        }
    }

    public static ArrayList<Comprador> getListaCompradores() {
        return listaCompradores;
    }

    public static void setListaCompradores(ArrayList<Comprador> listaCompradores) {
        RepositorioComprador.listaCompradores = listaCompradores;
    }

    public static void listar(){
        for (Comprador listaComprador : listaCompradores) {
            System.out.println(listaComprador);
        }
    }
}
