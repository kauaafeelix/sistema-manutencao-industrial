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
        System.out.println("\n====== MENU MÁQUINA ======");
        System.out.println("1 - Cadastrar Máquina");
        System.out.println("0 - Voltar ao Menu Principal");
        System.out.print("Escolha uma opção: ");
        int opcao = scNum.nextInt();
        return opcao;
    }


    public Maquina cadastroMaquina() {
            System.out.println("\n====== CADASTRO DE MÁQUINA ======");

            System.out.println("Digite o nome da máquina: ");
            String nome = scStr.nextLine();

            System.out.println("Digite o setor da máquina: ");
            String setor = scStr.nextLine();

        var novaMaquina = new Maquina(nome, setor);

        return novaMaquina;
    }

    public void mensagemNaoExisteMaquina(){
        System.err.println("\n[ERRO] Não existe máquina cadastrada com esse ID.");
    }

}
