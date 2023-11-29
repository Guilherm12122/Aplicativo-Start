package com.example.app_start.ui.produto.model;

public class ProdutoModel {

    private Integer id_produto;
    private String nome_produto;
    private Float preco;

    public ProdutoModel(String nome_produto, Float preco) {
        this.nome_produto = nome_produto;
        this.preco = preco;
    }

    public Integer getId_produto() {
        return id_produto;
    }

    public void setId_produto(Integer id_produto) {
        this.id_produto = id_produto;
    }

    public String getNome_produto() {
        return nome_produto;
    }

    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }
}
