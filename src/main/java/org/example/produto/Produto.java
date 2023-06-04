package org.example.produto;

public class Produto {
    private String nome;
    private double valor;
    private String tipo;
    private String marca;
    private String descricao;
    private int ID;

    public Produto(String nome, double valor, String tipo, String marca, String descricao, int ID) {
        this.nome = nome;
        this.valor = valor;
        this.tipo = tipo;
        this.marca = marca;
        this.descricao = descricao;
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public String toString()  {
        return "nome do produto -> " +this.nome + " | ID -> " + this.ID + " | valor -> " + this.valor;
    }

    public boolean equals(Produto produto) throws Exception {
        return this.nome.equals(produto.getNome());
    }
}
