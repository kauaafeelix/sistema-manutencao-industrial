package org.example.view;

import java.util.Scanner;

public class ViewOrdemPeca {

    Scanner scNum = new Scanner (System.in);
    Scanner scStr = new Scanner(System.in);

    public void cadastroOrdemPeca(){
        System.out.println("\n----- Cadastro de Peças na Ordem de Manutenção -----");
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
