package org.example.view;

import org.example.controller.ControllerPeca;
import org.example.model.Peca;

import java.sql.SQLException;
import java.util.Scanner;

public class ViewPeca {

    Scanner scNum = new Scanner (System.in);
    Scanner scStr = new Scanner (System.in);

    public int menuPeca(){
        System.out.println("----- Menu Peça -----");
        System.out.println("1 - Cadastrar Peça");
        System.out.println("2 - Listar Peças");
        System.out.println("3 - Atualizar Peça");
        System.out.println("4 - Deletar Peça");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
        int opcao = scNum.nextInt();
        return opcao;
    }

    public Peca cadastrarPeca(){

        System.out.println("----- CADASTRO DE PEÇA -----");

        System.out.println("Digite o nome da Peça: ");
        String nome = scStr.nextLine();

        System.out.println("Digite a quantidade em Estoque: ");
        double estoque = scNum.nextDouble();

        var novaPeca = new Peca(nome, estoque);

        return novaPeca;
    }

    public void mensagemNaoExistePeca(){
        System.err.println("[ERRO] Não existe uma Peça cadastrada com esse ID.");
    }


}
