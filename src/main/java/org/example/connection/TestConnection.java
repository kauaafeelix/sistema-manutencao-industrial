package org.example.connection;

import java.sql.SQLException;

public class TestConnection {
    public static void main(String[] args) {
        try {
            Conexao.conectar();
            System.out.println("Conexão bem-sucedida!");
        } catch (SQLException e) {
            System.out.println("Falha na conexão: " + e.getMessage());
        }
    }
}
