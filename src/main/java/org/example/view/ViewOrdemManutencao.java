package org.example.view;

import org.example.model.Maquina;
import org.example.model.OrdemManutencao;
import org.example.model.Tecnico;

import java.util.Scanner;

public class ViewOrdemManutencao {

    Scanner scNum = new Scanner(System.in);
    Scanner scStr = new Scanner(System.in);

    public int menuOrdemManutencao(){
        System.out.println("\n----- Menu Ordem de Manutenção -----");
        System.out.println("1 - Cadastrar Ordem de Manutenção");
        System.out.println("0 - Voltar ao Menu Principal");
        System.out.print("Escolha uma opção: ");

        int opcao = scNum.nextInt();
        return opcao;
    }

    public int criarOrdemManutencaoIdMaquina(){
        System.out.println("\nDigite o ID da Máquina: ");
        int idMaquina = scNum.nextInt();
        return idMaquina;
    }
    public int criarOrdemManutencaoIdTecnico(){
        System.out.println("\nDigite o ID do Técnico: ");
        int idTecnico = scNum.nextInt();
        return idTecnico;
    }

    public void naoExisteOrdemManutencao(){
        System.err.println("\n[ERRO] Não existe uma Ordem de Manutenção cadastrada com esse ID.");
    }
}
