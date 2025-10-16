package org.example.utils;

import org.example.model.Maquina;

import java.util.List;
import java.util.Scanner;

public class MaquinaUtils {

    Scanner scNum = new Scanner(System.in);
    Scanner scStr = new Scanner(System.in);

    public void exibirMaquinas(List<Maquina>maquinas){
        if(maquinas!= null && !maquinas.isEmpty()){
            for(Maquina m : maquinas){
                System.out.println("------Lista de Máquinas------");
                System.out.println("\nID: " + m.getId() + "\n | Nome: " + m.getNome() + "\n | Setor: " + m.getSetor() + "\n Status: "+ m.getStatus());

            }
        }else{
            System.out.println("[AVISO] Nenhuma máquina cadastrada.");
        }
    }
}
