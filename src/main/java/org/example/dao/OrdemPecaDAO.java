package org.example.dao;

import org.example.connection.Conexao;
import org.example.model.OrdemPeca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrdemPecaDAO {
    public void cadastrarOrdemPeca(OrdemPeca ordemPeca) throws SQLException {

        String sql = """
                INSERT INTO OrdemPeca (idOrdem, idPeca, quantidade)
                VALUES (?, ?, ?)
                """;

        try (Connection conn = Conexao.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setInt(1, ordemPeca.getIdOrdem().getId());
            ps.setInt(2, ordemPeca.getIdPeca().getId());
            ps.setDouble(3, ordemPeca.getQuantidade());
            ps.executeUpdate();
        }
    }
}
