package com.example.login;

public class AutoraDate {

    private String nome;
    private String livros;
    private String biografia;
    private String premios;

    public AutoraDate(String nome, String livros, String biografia, String premios) {
        this.nome = nome;
        this.livros = biografia;
        this.biografia = biografia;
        this.premios = premios;
    }

    public String getNome() {
        return nome;
    }

    public String getLivros() {
        return livros;
    }

    public String getBiografia() {
        return biografia;
    }

    public String getPremios() {
        return premios;
    }
}
