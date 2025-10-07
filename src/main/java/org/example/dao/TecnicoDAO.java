package org.example.dao;

import org.example.connection.Conexao;
import org.example.model.Tecnico;

import java.io.PipedReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TecnicoDAO {

    public void cadastrarTecnico(Tecnico tecnico) throws SQLException {

        String sql = """
                INSERT INTO Tecnico (
                nome,
                especialidade )
                VALUES (?, ?);
                """;

        try (Connection conn = Conexao.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setString(1, tecnico.getNome());
            ps.setString(2, tecnico.getEspecialidade());
            ps.executeUpdate();
        }

    }
}
