package org.example.view;

import org.example.controller.ControllerMaquina;
import org.example.dao.MaquinaDAO;
import org.example.model.Maquina;

import java.sql.SQLException;
import java.util.Scanner;

public class ViewMaquina {

    Scanner scNum = new Scanner(System.in);
    Scanner scStr = new Scanner(System.in);

    public Maquina cadastroMaquina() {
        System.out.println("====== CADASTRO DE MÁQUINA ======");

        System.out.println("Digite o nome da máquina: ");
        String nome = scStr.nextLine();

        System.out.println("Digite o setor da máquina: ");
        String setor = scStr.nextLine();

        var novaMaquina = new Maquina(nome, setor);

        return novaMaquina;
    }

    public void mostarMensagemCadastro(){
        System.out.println("[OK] Máquina cadastrada com sucesso!");
    }

    public void mostrarMensagemErro(){
        System.out.println("[ERRO] Erro ao cadastrar máquina.");
    }
}
