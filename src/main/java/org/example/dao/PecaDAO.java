package org.example.dao;

import org.example.connection.Conexao;
import org.example.model.Peca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PecaDAO {

    public void cadastrarPeca(Peca peca) throws SQLException {

        String sql = "INSERT INTO Peca (nome, estoque) VALUES (?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setString(1, peca.getNome());
            ps.setDouble(2, peca.getEstoque());
        }
    }
}
