package org.example.view;

import java.util.Scanner;

public class ViewOrdemPeca {

    Scanner scNum = new Scanner(System.in);
    Scanner scStr = new Scanner(System.in);

    public int menuOrdemPeca() {
        System.out.println("\n----- Menu de Peças na Ordem de Manutenção -----");
        System.out.println("1 - Cadastrar Peça na Ordem de Manutenção");
        System.out.println("2 - Voltar ao Menu Principal");
        System.out.print("Escolha uma opção: ");
        int opcao = scNum.nextInt();
        return opcao;
    }

    public int cadastroOrdemPecaIdOrdemManutencao() {
        System.out.print("Digite o ID da Ordem de Manutenção: ");
        int idOrdem = scNum.nextInt();

        return idOrdem;
    }

    public int cadastroOrdemPecaIdPeca() {
        System.out.print("Digite o ID da Peça: ");
        int idPeca = scNum.nextInt();
        return idPeca;
    }

    public double cadastroOrdemPecaQuantidade() {
        System.out.print("Digite a quantidade da Peça: ");
        double quantidade = scNum.nextDouble();

        return quantidade;
    }

    public void mensagemMenorEstoque() {
        System.err.println("[ERRO] A quantidade solicitada é maior que o estoque disponível.");
    }

    public void naoPodeSerZeroOuNegativo() {
        System.err.println("[ERRO] A quantidade deve ser maior que zero.");
    }

}
