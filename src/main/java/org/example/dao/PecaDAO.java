package org.example.dao;

import org.example.connection.Conexao;
import org.example.model.OrdemManutencao;
import org.example.model.OrdemPeca;
import org.example.model.Peca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PecaDAO {

    public void cadastrarPeca(Peca peca) throws SQLException {

        String sqlPeca = "INSERT INTO Peca (nome, estoque) VALUES (?, ?)";

        String sqlGetId = """
                SELECT id FROM Peca ORDER BY id DESC LIMIT 1
                """;

        String sqlOrdemPeca = """
                INSERT IGNORE INTO OrdemPeca
                (idOrdem, idPeca, quantidade)
                VALUES (?, ?, ?)
                """;
        try (Connection conn = Conexao.conectar()) {

            try (PreparedStatement psPeca = conn.prepareStatement(sqlPeca)) {
                psPeca.setString(1, peca.getNome());
                psPeca.setDouble(2, peca.getEstoque());
                psPeca.executeUpdate();
            }

            try (PreparedStatement psGetId = conn.prepareStatement(sqlGetId);
                 ResultSet rs = psGetId.executeQuery()) {
                if (rs.next()) {
                    rs.getInt("id");
                    return;
                }
            }

            try(PreparedStatement psOrdemPeca = conn.prepareStatement(sqlOrdemPeca)){
                var op = new OrdemPeca();
                var ordem = new OrdemManutencao();
                psOrdemPeca.setInt(1, ordem.getId());
                psOrdemPeca.setInt(2, peca.getId());
                psOrdemPeca.setDouble(3, op.getQuantidade());

        }
    }
}
}
