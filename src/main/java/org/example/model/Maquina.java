package org.example.model;

import org.example.model.enums.StatusMaquina;

public class Maquina {

    private int id;
    private String nome;
    private String setor;
    private StatusMaquina status;

    public Maquina(int id, String nome, String setor, StatusMaquina status) {
        this.id = id;
        this.nome = nome;
        this.setor = setor;
        this.status = status;
    }

    public Maquina(String nome, String setor, StatusMaquina status) {
        this.nome = nome;
        this.setor = setor;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public StatusMaquina getStatus() {
        return status;
    }

    public void setStatus(StatusMaquina status) {
        this.status = status;
    }
}
