package org.example.model;

public class OrdemPeca {
    private OrdemManutencao idOrdem;
    private Peca idPeca;
    private int quantidade;

    public OrdemPeca(OrdemManutencao idOrdem, Peca idPeca, int quantidade) {
        this.idOrdem = idOrdem;
        this.idPeca = idPeca;
        this.quantidade = quantidade;
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

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
