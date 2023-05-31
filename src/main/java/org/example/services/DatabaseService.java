package org.example.services;
import com.google.gson.Gson;
import org.example.entidades.Comprador;
import org.example.entidades.Entidades;
import org.example.entidades.Loja;
import org.example.repositorio.RepositorioComprador;
import org.example.repositorio.RepositorioLoja;

import java.util.ArrayList;

public class DatabaseService {
    private static Gson gson = new Gson();

    public static String objectToJson(Entidades toJson){
        return gson.toJson(toJson);
    }

    public static void writeDataBaseCompradores(){
        RepositorioComprador.getInstancia();
        ArrayList<String> data = new ArrayList<>();

        try{
            for (int i = 0; i < RepositorioComprador.getListaCompradores().size(); i++) {
                data.add(objectToJson(RepositorioComprador.getCompradorPorID(i)));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        
        FileHandlerService.writeDataLineByLine("./src/main/java/org/example/databases/compradores.json", data);
    }

    public static void writeDataBaseLoja(){
        RepositorioLoja.getInstancia();

        ArrayList<String> data = new ArrayList<>();
        try{
            for (int i = 0; i < RepositorioLoja.getListaLojas().size(); i++) {
                data.add(objectToJson(RepositorioLoja.getLojaPorID(i)));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        FileHandlerService.writeDataLineByLine("./src/main/java/org/example/databases/lojas.json", data);
    }

    public static void readDatabaseCompradores() {
        RepositorioComprador.getInstancia();

        ArrayList<String> databaseCompradores = FileHandlerService.readDataDataLineByLine("./src/main/java/org/example/databases/compradores.json");

        for (String comprador : databaseCompradores) {
            try {
                RepositorioComprador.inserir(gson.fromJson(comprador, Comprador.class));
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void readDatabaseLojas() {
        RepositorioLoja.getInstancia();

        ArrayList<String> databaseLojas = FileHandlerService.readDataDataLineByLine("./src/main/java/org/example/databases/lojas.json");


        for (String lojas : databaseLojas) {
            try{
                RepositorioLoja.inserir(gson.fromJson(lojas, Loja.class));
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        Gson gson = new Gson();

        readDatabaseCompradores();
        readDatabaseLojas();

        RepositorioLoja.listarLojas();
        RepositorioComprador.listar();
    }
}
