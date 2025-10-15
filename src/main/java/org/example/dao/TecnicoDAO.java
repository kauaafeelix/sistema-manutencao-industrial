package org.example.dao;

import org.example.connection.Conexao;
import org.example.model.Tecnico;

import java.io.PipedReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public List<Tecnico> listarTecnicos()throws SQLException {
        List<Tecnico> tecnicos = new ArrayList<>();

            String sql = """
                    SELECT id, nome, especialidade
                    FROM Tecnico
                    """;

            try (Connection conn = Conexao.conectar();
                 PreparedStatement ps = conn.prepareStatement(sql)){

                ResultSet rs = ps.executeQuery();

                while (rs.next()){
                    int id = rs.getInt("id");
                    String nome = rs.getString("nome");
                    String especialidade = rs.getString("especialidade");

                    Tecnico tecnico = new Tecnico(id, nome, especialidade);
                    tecnicos.add(tecnico);
                }
            }
        return tecnicos;
    }

    public Tecnico buscarTecnicoPorId(int id) throws SQLException{
        String sql = """
                SELECT id, nome, especialidade
                FROM Tecnico
                WHERE id = ?
                """;
        try (Connection conn = Conexao.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                int idTecnico = rs.getInt("id");
                String nome = rs.getString("nome");
                String especialidade = rs.getString("especialidade");

                return new Tecnico(idTecnico, nome, especialidade);
            }
        }
        return null;
    }
}
