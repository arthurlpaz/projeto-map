package org.example.entidades;

import org.example.utils.Avaliacao;

import java.util.ArrayList;


public class Entidades {
    private String nome;
    private String email;
    private String senha;
    private String cpf;
    private String endereco;
    private int ID;
    private ArrayList<Avaliacao> avaliacoes;

    public Entidades(String nome, String email, String senha, String cpf, String endereco, int ID) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
        this.endereco = endereco;
        this.ID = ID;
        this.avaliacoes = new ArrayList<>();
    }
    
    public Entidades(String nome, String email, String senha, String cpf, String endereco, int ID, ArrayList<Avaliacao> avaliacoes) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
        this.endereco = endereco;
        this.ID = ID;
        this.avaliacoes = avaliacoes;
    }

    public double getMediaAvaliacoes(){
        int totalNotas = 0;

        if(avaliacoes == null || avaliacoes.size() == 0){
            avaliacoes = new ArrayList<>();
            return totalNotas;
        }
        else{
            for (int i = 0; i < avaliacoes.size(); i++) {
                totalNotas+=avaliacoes.get(i).getNota();
            }
        }
        
        return totalNotas / avaliacoes.size();
    }

    public void imprimeComentarios() throws Exception{
        if(avaliacoes == null){
            avaliacoes = new ArrayList<>();
        }

        if(avaliacoes.size() == 0){
            throw new Exception("Nenhuma avaliacao foi feita sobre este usuario");
        }
        
        for (int i = 0; i < avaliacoes.size(); i++) {
            System.out.println(avaliacoes.get(i));  
        }
    }

    public void adicionarAvaliacao(Avaliacao avaliacao){
        avaliacoes.add(avaliacao);
    }

    @Override
    public String toString(){
        return "nome -> " + this.nome + " | email -> " + this.email + " | endereco -> " + this.endereco + " | ID -> " + this.ID;
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

    public ArrayList<Avaliacao> getAvaliacoes() {
        if(avaliacoes == null){
            this.avaliacoes = new ArrayList<>();
        }
        return avaliacoes;
    }

    public void setAvaliacoes(ArrayList<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }
}
