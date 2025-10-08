package org.example.view;

import org.example.controller.ControllerTecnico;

import java.sql.SQLException;
import java.util.Scanner;

public class ViewTecnico {
    static Scanner scNum = new Scanner (System.in);
    static Scanner scStr = new Scanner(System.in);
    public static void cadastrarTecnico(){
        System.out.println("Digite o nome do Técnico: ");
        String nome = scStr.nextLine();

        System.out.println("Digite a especialidade: ");
        String especialidade = scStr.nextLine();

        var controllerTecnico = new ControllerTecnico();

        try{
            controllerTecnico.cadastrarTecnico(nome, especialidade);
            System.out.println("Técnico cadastrado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar técnico "+ e.getMessage());
        }
    }
}
