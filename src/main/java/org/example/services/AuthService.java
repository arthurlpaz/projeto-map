package org.example.services;

import org.example.entidades.Entidades;
import org.example.repositorio.RepositorioComprador;
import org.example.repositorio.RepositorioLoja;

public class AuthService {
    private static Entidades usuarioLogado = null;
    public static void login(Entidades usuario){
        usuarioLogado = usuario;
    }
    public static void login(int ID, String tipo) throws Exception {
        if(tipo.equals("comprador")){
            usuarioLogado = RepositorioComprador.getCompradorPorID(ID);
        }else if(tipo.equals("loja")){
            usuarioLogado = RepositorioLoja.getLojaPorID(ID);
        }else{
            throw new Exception("Usuario nao encontrado");
        }
    }
    public static void logout(){
        usuarioLogado = null;
    }
    public static Entidades getInstancia() throws Exception {
        if(usuarioLogado == null){
            throw new Exception("Nenhum usuario Logado");
        }
        return usuarioLogado;
    }

    public static boolean isLogged(){
        return !(usuarioLogado == null);
    }
    public static String tipoUsuario() throws Exception{
        if(usuarioLogado == null){
            throw new Exception("nenhum usuario logado");
        }
        return usuarioLogado.getClass().getName();
    }
}
