package org.example.model;

public class OrdemPeca {
    private OrdemManutencao idOrdem;
    private Peca idPeca;
    private double quantidade;

    public OrdemPeca(OrdemManutencao idOrdem, Peca idPeca, double quantidade) {
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

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }
}
