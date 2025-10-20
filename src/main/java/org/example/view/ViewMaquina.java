package org.example.view;

import org.example.controller.ControllerMaquina;
import org.example.dao.MaquinaDAO;
import org.example.model.Maquina;

import java.sql.SQLException;
import java.util.Scanner;

public class ViewMaquina {

    Scanner scNum = new Scanner(System.in);
    Scanner scStr = new Scanner(System.in);

    public int menuMaquina() {
        System.out.println("====== MENU MÁQUINA ======");
        System.out.println("1 - Cadastrar Máquina");
        System.out.println("2 - Listar Máquinas");
        System.out.println("3 - Atualizar Máquina");
        System.out.println("4 - Deletar Máquina");
        System.out.println("0 - Voltar ao Menu Principal");
        System.out.print("Escolha uma opção: ");
        int opcao = scNum.nextInt();
        return opcao;
    }


    public Maquina cadastroMaquina() {
            System.out.println("====== CADASTRO DE MÁQUINA ======");

            System.out.println("Digite o nome da máquina: ");
            String nome = scStr.nextLine();

            System.out.println("Digite o setor da máquina: ");
            String setor = scStr.nextLine();

        var novaMaquina = new Maquina(nome, setor);

        return novaMaquina;
    }

    public void mensagemNaoExisteMaquina(){
        System.err.println("[ERRO] Não existe máquina cadastrada com esse ID.");
    }

}
