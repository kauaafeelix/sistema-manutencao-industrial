package org.example.dao;

import org.example.connection.Conexao;
import org.example.model.Maquina;
import org.example.model.enums.StatusMaquina;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public List<Maquina> listarMaquinas() throws SQLException{
        List<Maquina> maquinas = new ArrayList<>();
        String sql = """
                SELECT id, nome, setor, status
                FROM Maquina
                WHERE status = 'OPERACIONAL'
                """;
        try (Connection conn = Conexao.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)){

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String setor = rs.getString("setor");
                String status = rs.getString("status");

                Maquina maquina = new Maquina(id, nome, setor, StatusMaquina.valueOf(status));
                maquinas.add(maquina);
            }
        }
        return maquinas;
    }

    public Maquina buscarMaquinaPorId(int id) throws SQLException{
        String sql = """
                SELECT id, nome, setor, status
                FROM Maquina
                WHERE id = ? AND status = 'OPERACIONAL'
                """;
        try (Connection conn = Conexao.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                String nome = rs.getString("nome");
                String setor = rs.getString("setor");
                String status = rs.getString("status");

                return new Maquina(id, nome, setor, StatusMaquina.valueOf(status));
            }
        }
        return null;
    }
}
