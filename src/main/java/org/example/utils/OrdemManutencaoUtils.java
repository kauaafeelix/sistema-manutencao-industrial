package org.example.utils;

import org.example.model.OrdemManutencao;

import java.util.List;
import java.util.Scanner;

public class OrdemManutencaoUtils {
    Scanner scNum = new Scanner(System.in);
    Scanner scStr = new Scanner(System.in);

    public void exibirOrdens(List<OrdemManutencao>ordens){
        if (ordens != null && !ordens.isEmpty()) {
            System.out.println("----- Lista de Ordens de Manutenção -----");
            for (OrdemManutencao o : ordens) {
                System.out.println("ID: " + o.getId());
                System.out.println("Máquina: " + o.getIdMaquina().getId());
                System.out.println("Técnico: " + o.getIdTecnico().getId());
                System.out.println("Data de Solicitação: " + o.getDataSolicitacao());
                System.out.println("Status: " + o.getStatus());
                System.out.println("-----------------------------------------");
            }
        } else {
            System.out.println("[AVISO] Nenhuma ordem de manutenção encontrada.");
        }
    }
}
