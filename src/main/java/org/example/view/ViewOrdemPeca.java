package org.example.view;

import java.util.Scanner;

public class ViewOrdemPeca {

    Scanner scNum = new Scanner (System.in);
    Scanner scStr = new Scanner(System.in);

    public void menuOrdemPeca(){
        System.out.println("\n----- Menu de Peças na Ordem de Manutenção -----");
        System.out.println("1 - Cadastrar Peça na Ordem de Manutenção");
        System.out.println("2 - Voltar ao Menu Principal");
        System.out.print("Escolha uma opção: ");
    }

    public void cadastroOrdemPecaIdOrdemManutencao(){
        System.out.print("Digite o ID da Ordem de Manutenção: ");
        int idOrdem = scNum.nextInt();
    }

    public void cadastroOrdemPecaIdPeca(){
        System.out.print("Digite o ID da Peça: ");
        int idPeca = scNum.nextInt();
    }

    public void cadastroOrdemPecaQuantidade(){
        System.out.print("Digite a quantidade da Peça: ");
        double quantidade = scNum.nextDouble();
    }
}
