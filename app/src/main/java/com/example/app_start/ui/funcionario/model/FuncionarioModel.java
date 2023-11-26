package com.example.app_start.ui.funcionario.model;

public class FuncionarioModel {
    private Integer id_usuario;
    private String nome_usuario;
    private String cargo;

    public FuncionarioModel(String nome_usuario, String cargo) {
        this.nome_usuario = nome_usuario;
        this.cargo = cargo;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNome_usuario() {
        return nome_usuario;
    }

    public void setNome_usuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
