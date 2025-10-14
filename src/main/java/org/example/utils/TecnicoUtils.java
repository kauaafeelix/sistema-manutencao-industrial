package org.example.utils;

import org.example.model.Tecnico;

import java.util.List;

public class TecnicoUtils {

    public void exibirTecnicos(List<Tecnico>tecnicos){
        if(tecnicos != null && !tecnicos.isEmpty()){
            System.out.println("----- Lista de Técnicos -----");
            for (Tecnico t : tecnicos) {
                System.out.println("ID: " + t.getId());
                System.out.println("Nome: " + t.getNome());
                System.out.println("Especialidade: " + t.getEspecialidade());
                System.out.println("-----------------------------");
            }
        } else {
            System.out.println("Nenhum técnico encontrado.");
        }

    }
}
