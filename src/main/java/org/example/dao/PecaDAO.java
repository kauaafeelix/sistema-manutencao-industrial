package org.example.dao;

import org.example.connection.Conexao;
import org.example.model.OrdemManutencao;
import org.example.model.OrdemPeca;
import org.example.model.Peca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PecaDAO {

    public void cadastrarPeca(Peca peca) throws SQLException {

        String sqlPeca = "INSERT INTO Peca (nome, estoque) VALUES (?, ?)";

        String sqlGetId = """
                SELECT id FROM Peca ORDER BY id DESC LIMIT 1
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
    }
}

    public List<Peca> listarPecas() throws SQLException {

        List<Peca> pecas = new ArrayList<>();

        String sql = """
                SELECT id, nome, estoque
                FROM Peca
                """;
        try (Connection conn = Conexao.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)){

            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                double estoque = rs.getDouble("estoque");

                Peca peca = new Peca(id, nome, estoque);
                pecas.add(peca);
            }
        }
        return pecas;
    }

    public boolean existeIdPeca(int id) throws SQLException{
        boolean existe = false;

        String sql = """
                SELECT id, nome, estoque
                FROM Peca
                WHERE id = ?
                """;

        try (Connection conn = Conexao.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                existe = true;
            }
        }
        return existe;
    }
}
