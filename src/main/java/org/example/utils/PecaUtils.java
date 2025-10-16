package org.example.utils;

import org.example.model.Peca;

import java.util.List;

public class PecaUtils {

    public void exibirPeca(List<Peca>pecas){
        if(pecas !=null && !pecas.isEmpty()){
            System.out.println("----- Lista de Peças -----");
            for(Peca peca : pecas){
                System.out.println("ID: " + peca.getId());
                System.out.println("Nome: " + peca.getNome());
                System.out.println("Estoque: " + peca.getEstoque());
                System.out.println("--------------------------");
            }
        } else {
            System.out.println("[AVISO] Nenhuma peça encontrada.");
        }

    }
}
