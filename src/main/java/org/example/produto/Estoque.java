package org.example.produto;

import java.util.ArrayList;

public class Estoque {
    ArrayList<MapProduto> estoque;
    int ID;

    public Estoque(){
        estoque = new ArrayList<MapProduto>();
        ID = 1;
    }
    public void listarProdutos(){
        for (MapProduto produto : estoque) {
            System.out.println(produto.getProduto() + " quantidade -> " + produto.getQuantidade());
        }
    }
    public void inserir(String nome, double valor, String tipo, String marca, String descricao, int quantidade){
        Produto auxProduto = new Produto(nome, valor, tipo, marca, descricao, ID);
        for (MapProduto mapProduto : estoque) {
            try{
                if (mapProduto.getProduto().equals(auxProduto)) {
                    mapProduto.setQuantidade(mapProduto.getQuantidade() + quantidade);
                    return;
                }
            }catch (Exception e){
                System.out.println(e);
                return;
            }
        }
        estoque.add(new MapProduto(auxProduto, quantidade));
        ID++;
    }
    public void removerPorID(int ID_produto_a_remover, int quantidade){
        for (int i = 0; i < estoque.size(); i++) {
            if(estoque.get(i).getQuantidade() < quantidade){
                estoque.remove(i);
                break;
            }else{
                estoque.get(i).setQuantidade(estoque.get(i).getQuantidade()-quantidade);
            }
        }
    }
    public void removerPorNome(String nome, int quantidade){
        for (int i = 0; i < estoque.size(); i++) {
            if(estoque.get(i).getProduto().getNome().equals(nome)){
                if(estoque.get(i).getQuantidade() < quantidade){
                    estoque.remove(i);
                    break;
                }else{
                    estoque.get(i).setQuantidade(estoque.get(i).getQuantidade()-quantidade);
                }
            };
        }
    }
    public ArrayList<MapProduto> getEstoque() {
        return estoque;
    }

    public void setEstoque(ArrayList<MapProduto> estoque) {
        this.estoque = estoque;
    }

    public MapProduto getProdutoPorID(int ID) throws Exception{
        for (MapProduto mapProduto : estoque) {
            if (mapProduto.getProduto().getID() == ID) {
                return mapProduto;
            }
        }
        throw new Exception("produto nao encontrado");
    }
}
