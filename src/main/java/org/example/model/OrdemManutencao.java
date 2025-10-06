package org.example.model;

import org.example.model.enums.StatusOrdemManutencao;

import java.time.LocalDate;
import java.util.Date;

public class OrdemManutencao {

    private int id;
    private Maquina idMaquina;
    private Tecnico idTecnico;
    private LocalDate dataSolicitacao;
    private StatusOrdemManutencao status;

    public OrdemManutencao(int id, Maquina idMaquina, Tecnico idTecnico, LocalDate dataSolicitacao, StatusOrdemManutencao status) {
        this.id = id;
        this.idMaquina = idMaquina;
        this.idTecnico = idTecnico;
        this.dataSolicitacao = dataSolicitacao;
        this.status = status;
    }

    public OrdemManutencao(Maquina idMaquina, Tecnico idTecnico, LocalDate dataSolicitacao, StatusOrdemManutencao status) {
        this.idMaquina = idMaquina;
        this.idTecnico = idTecnico;
        this.dataSolicitacao = dataSolicitacao;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Maquina getIdMaquina() {
        return idMaquina;
    }

    public void setIdMaquina(Maquina idMaquina) {
        this.idMaquina = idMaquina;
    }

    public Tecnico getIdTecnico() {
        return idTecnico;
    }

    public void setIdTecnico(Tecnico idTecnico) {
        this.idTecnico = idTecnico;
    }

    public LocalDate getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(LocalDate dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public StatusOrdemManutencao getStatus() {
        return status;
    }

    public void setStatus(StatusOrdemManutencao status) {
        this.status = status;
    }
}
