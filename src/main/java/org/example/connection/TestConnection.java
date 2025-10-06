package org.example.connection;

public class TestConnection {
    public static void main(String[] args) {
        try {
            Conexao.conectar();
            System.out.println("Conexão bem-sucedida!");
        } catch (Exception e) {
            System.out.println("Falha na conexão: " + e.getMessage());
        }
    }
}
