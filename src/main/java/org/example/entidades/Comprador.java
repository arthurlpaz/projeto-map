package org.example.entidades;

import org.example.produto.Carrinho;
import org.example.produto.Pedido;

import java.util.ArrayList;

public class Comprador implements Entidades{
    private String nome;
    private String email;
    private String senha;
    private String cpf;
    private String endereco;
    private int ID;
    private ArrayList<Pedido> historicoDePedidos;
    private Carrinho carrinhoDeCompras;

    public Comprador(String nome, String email, String senha, String cpf, String endereco, int ID) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
        this.endereco = endereco;
        this.ID = ID;
        this.carrinhoDeCompras = new Carrinho();
        this.historicoDePedidos = new ArrayList<>();
    }
    public Comprador(String nome, String email, String senha, String cpf, String endereco, int ID, Carrinho carrinhoDeCompras, ArrayList<Pedido> historicoDePedidos) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
        this.endereco = endereco;
        this.ID = ID;
        this.carrinhoDeCompras = carrinhoDeCompras;
        this.historicoDePedidos = historicoDePedidos;
    }
    public void completarCompra(){
        historicoDePedidos.add(new Pedido(carrinhoDeCompras.getProdutos(), "succesfull"));
        carrinhoDeCompras.clear();
    }

    public void cancelarCompra(){
        carrinhoDeCompras.clear();
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
    public ArrayList<Pedido> getHistoricoDePedidos() {
        return historicoDePedidos;
    }
    public void setHistoricoDePedidos(ArrayList<Pedido> historicoDePedidos) {
        this.historicoDePedidos = historicoDePedidos;
    }
    public Carrinho getCarrinhoDeCompras() {
        return carrinhoDeCompras;
    }
    public void setCarrinhoDeCompras(Carrinho carrinhoDeCompras) {
        this.carrinhoDeCompras = carrinhoDeCompras;
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
