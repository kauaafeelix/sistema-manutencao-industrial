package org.example.view;

import org.example.controller.ControllerMaquina;
import org.example.dao.MaquinaDAO;
import org.example.model.Maquina;

import java.sql.SQLException;
import java.util.Scanner;

public class ViewMaquina {

    static Scanner scNum = new Scanner (System.in);
    static Scanner scStr = new Scanner (System.in);

    public static void cadastroMaquina() {
        System.out.println("====== CADASTRO DE MÁQUINA ======");

        System.out.println("Digite o nome da máquina: ");
        String nome = scStr.nextLine();

        System.out.println("Digite o setor da máquina: ");
        String setor = scStr.nextLine();

        var controllerMaquina = new ControllerMaquina();

        try{
            controllerMaquina.cadastrarMaquina(nome, setor);
            System.out.println("Máquina cadastrada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar máquina: " + e.getMessage());
        }
    }
}
