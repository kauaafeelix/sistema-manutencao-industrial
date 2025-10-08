package org.example.view;

import org.example.controller.ControllerPeca;

import java.sql.SQLException;
import java.util.Scanner;

public class ViewPeca {

    static Scanner scNum = new Scanner (System.in);
    static Scanner scStr = new Scanner (System.in);

    public static void cadastrarPeca(){
        System.out.println("Digite o nome da Peça: ");
        String nome = scStr.nextLine();

        System.out.println("Digite a quantidade em Estoque: ");
        Double estoque = scNum.nextDouble();

        var controllerPeca = new ControllerPeca();

        try{
            controllerPeca.cadastrarPeca(nome, estoque);
            System.out.println("Peça cadastrada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar peça "+ e.getMessage());
        }
    }
}
