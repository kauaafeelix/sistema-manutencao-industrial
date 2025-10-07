package org.example.dao;

import org.example.connection.Conexao;
import org.example.model.Maquina;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MaquinaDAO {

    public void cadastrarMaquina(Maquina maquina) throws SQLException {

        String sql = """
                INSERT INTO Maquina (
                nome,
                setor,
                status )
                VALUES (?, ?, 'OPERACIONAL');
                """;

        try (Connection conn = Conexao.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, maquina.getNome());
            ps.setString(2, maquina.getSetor());
            ps.executeUpdate();
        }
    }
}
