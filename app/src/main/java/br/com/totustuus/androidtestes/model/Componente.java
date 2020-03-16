package br.com.totustuus.androidtestes.model;

import java.util.ArrayList;
import java.util.List;

public class Componente {

    private int id;
    private String nome;
    private List<String> pontos;
    private boolean expandido;

    public Componente(int id, String nome, List<String> pontos) {
        this.id = id;
        this.nome = nome;
        this.pontos = pontos;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public boolean isExpandido() {
        return expandido;
    }

    public void setExpandido(boolean expandido) {
        this.expandido = expandido;
    }

    public List<String> getPontos() {
        return pontos;
    }

    public void setPontos(List<String> pontos) {
        if(pontos == null) {
            pontos = new ArrayList<String>();
        }
        this.pontos = pontos;
    }
}
