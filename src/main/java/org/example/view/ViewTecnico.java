package org.example.view;

import org.example.controller.ControllerTecnico;
import org.example.model.Tecnico;

import java.sql.SQLException;
import java.util.Scanner;

public class ViewTecnico {
    Scanner scNum = new Scanner (System.in);
    Scanner scStr = new Scanner(System.in);


    public int menuTecnico(){
        System.out.println("----- Menu Técnico -----");
        System.out.println("1 - Cadastrar Técnico");
        System.out.println("2 - Listar Técnicos");
        System.out.println("3 - Atualizar Técnico");
        System.out.println("4 - Deletar Técnico");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
        int opcao = scNum.nextInt();
        return opcao;
    }


    public Tecnico cadastrarTecnico(){

        System.out.println("----- CADASTRO DE TÉCNICO -----");

        System.out.println("Digite o nome do Técnico: ");
        String nome = scStr.nextLine();

        System.out.println("Digite a especialidade: ");
        String especialidade = scStr.nextLine();

        var novoTecnico = new Tecnico(nome, especialidade);
        return novoTecnico;
    }

    public void mensagemNaoExisteTecnico(){
        System.out.println("[ERRO] Não existe um Técnico cadastrado(a) com esse ID.");
    }
}
