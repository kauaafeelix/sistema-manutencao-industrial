package org.example.view;

import java.sql.SQLException;
import java.util.Scanner;

public class ViewGeral {

    Scanner scNum = new Scanner (System.in);
    Scanner scStr = new Scanner (System.in);

    public int menuGeral (){
        System.out.println("""
                \n====== SISTEMA DE MANUTENÇÃO INDUSTRIAL ======
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
        System.out.println("\n[OK] Cadastro realizado com sucesso!");
    }
    public void mostrarMensagemErro(){
        System.err.println("\n[ERRO] Erro ao cadastrar.");
    }
    public void mostrarMensagemErroPorSerNulo(){
        System.err.println("\n[ERRO] Os dados não podem ser NULOS. Por favor, tente novamente.");
    }
    public void mostrarMensagemErroSQLException(SQLException e){
        System.err.println("\n[ERRO] Ocorreu um erro ao acessar o banco de dados: " + e.getMessage());
    }
    public void mostrarMensagemIdInvalido(){
        System.err.println("\n[ERRO] ID inválido. Por favor, tente novamente.");
    }

    public void encerrando() {
        try {
            System.out.print("\nS");
            Thread.sleep(500);
            System.out.print("i");
            Thread.sleep(500);
            System.out.print("s");
            Thread.sleep(500);
            System.out.print("t");
            Thread.sleep(500);
            System.out.print("e");
            Thread.sleep(500);
            System.out.print("m");
            Thread.sleep(500);
            System.out.print("a");
            Thread.sleep(500);
            System.out.println("");
            Thread.sleep(500);
            System.out.print("E");
            Thread.sleep(500);
            System.out.print("n");
            Thread.sleep(500);
            System.out.print("c");
            Thread.sleep(500);
            System.out.print("e");
            Thread.sleep(500);
            System.out.print("r");
            Thread.sleep(500);
            System.out.print("r");
            Thread.sleep(500);
            System.out.print("a");
            Thread.sleep(500);
            System.out.print("d");
            Thread.sleep(500);
            System.out.print("o");
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
