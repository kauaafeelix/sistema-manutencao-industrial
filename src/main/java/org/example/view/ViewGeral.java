package org.example.view;

import java.util.Scanner;

public class ViewGeral {

    static Scanner scNum = new Scanner (System.in);

    public static int menuGeral (){
        System.out.println("""
                ====== SISTEMA DE MANUTENÇÃO INDUSTRIAL ======
                1 - CADASTRAR MÁQUINA
                2 - CADASTRAR TÉCNICO
                3 - CADASTRAR PEÇA
                4 - CRIAR ORDEM DE MANUTENÇÃO
                5 - ASSOCIAS PEÇAS À ORDEM
                6 - EXECUTAR MANUTENÇÃO
                
                0 - SAIR
                
                Digite a opção desejada: 
                ==============================================
                """);
        int opcao = scNum.nextInt();

        return opcao;
    }
    public void mostarMensagemCadastro(){
        System.out.println("[OK] Cadastro realizado com sucesso!");
    }
    public void mostrarMensagemErro(){
        System.out.println("[ERRO] Erro ao cadastrar.");
    }
    public void mostrarMensagemErroPorSerNulo(){
        System.out.println("[ERRO] Os dados não podem ser NULOS. Por favor, tente novamente.");

    }
}
