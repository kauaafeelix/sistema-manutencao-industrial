package org.example.model;

public class OrdemPeca {
    private OrdemManutencao idOrdem;
    private Peca idPeca;
    private Double quantidade;

    public OrdemPeca(OrdemManutencao idOrdem, Peca idPeca, Double quantidade) {
        this.idOrdem = idOrdem;
        this.idPeca = idPeca;
        this.quantidade = quantidade;
    }

    public OrdemPeca() {

    }

    public OrdemManutencao getIdOrdem() {
        return idOrdem;
    }

    public void setIdOrdem(OrdemManutencao idOrdem) {
        this.idOrdem = idOrdem;
    }

    public Peca getIdPeca() {
        return idPeca;
    }

    public void setIdPeca(Peca idPeca) {
        this.idPeca = idPeca;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }
}
