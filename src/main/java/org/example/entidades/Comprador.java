package org.example.entidades;

import java.util.ArrayList;

public class Comprador implements Entidades{
    private String nome;
    private String email;
    private String senha;
    private String cpf;
    private String endereco;
    private int ID;


    public Comprador(String nome, String email, String senha, String cpf, String endereco, int ID) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
        this.endereco = endereco;
        this.ID = ID;

    }

    @Override
    public String toString(){
        return "nome do comprador -> " + this.nome + " email -> " + this.email + " endereco -> " + this.endereco + " ID -> " + this.ID;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }


    // TODO
    @Override
    public void login() {

    }
    //TODO
    @Override
    public void logout() {

    }
}
