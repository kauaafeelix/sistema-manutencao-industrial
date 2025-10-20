package org.example.view;

import org.example.model.Maquina;
import org.example.model.OrdemManutencao;
import org.example.model.Tecnico;

import java.util.Scanner;

public class ViewOrdemManutencao {

    Scanner scNum = new Scanner(System.in);
    Scanner scStr = new Scanner(System.in);

    public int menuOrdemManutencao(){
        System.out.println("----- Menu Ordem de Manutenção -----");
        System.out.println("1 - Cadastrar Ordem de Manutenção");
        System.out.println("2 - Atualizar Ordem de Manutenção");
        System.out.println("3 - Excluir Ordem de Manutenção");
        System.out.println("4 - Listar Ordens de Manutenção");
        System.out.println("5 - Buscar Ordem de Manutenção por ID");
        System.out.println("0 - Voltar ao Menu Principal");
        System.out.print("Escolha uma opção: ");

        int opcao = scNum.nextInt();
        return opcao;
    }

    public void menuCriarOrdemManutencao() {
        System.out.println("----- Criar Ordem de Manutenção -----");

    }
    public int criarOrdemManutencaoIdMaquina(){
        System.out.println("Digite o ID da Máquina: ");
        int idMaquina = scNum.nextInt();
        return idMaquina;
    }
    public int criarOrdemManutencaoIdTecnico(){
        System.out.println("Digite o ID do Técnico: ");
        int idTecnico = scNum.nextInt();
        return idTecnico;
    }

    public void naoExisteOrdemManutencao(){
        System.err.println("[ERRO] Não existe uma Ordem de Manutenção cadastrada com esse ID.");
    }
}
