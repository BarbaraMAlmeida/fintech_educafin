package br.com.fiap.store.bean;

import java.io.Serializable;

public class Categoria implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String nomeCategoria;
    private String descricao;

    public Categoria() {

    }

    public Categoria(int id, String nomeCategoria, String descricao) {
        this.id = id;
        this.nomeCategoria = nomeCategoria;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Categoria [codigo = " + id
                + ", nome = " + nomeCategoria
                + ", descricao = " + descricao
                + "]";
    }

}
