package org.example.dao;

import org.example.connection.Conexao;
import org.example.model.*;
import org.example.model.enums.StatusOrdemManutencao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrdemManutencaoDAO {

    public void criarOrdemManutencao(OrdemManutencao ordem) throws SQLException {
        String sqlOrdem = """
            INSERT INTO OrdemManutencao (
            idMaquina,
            idTecnico,
            dataSolicitacao,
            status )
            VALUES (?, ?, NOW(), 'PENDENTE')
            """;

        String sqlMaquina = """
            UPDATE Maquina
            SET status = 'EM_MANUTENCAO'
            WHERE id = ?
            """;

        try (Connection conn = Conexao.conectar()) {
            conn.setAutoCommit(false);
            try (PreparedStatement psOrdem = conn.prepareStatement(sqlOrdem, Statement.RETURN_GENERATED_KEYS)) {
                psOrdem.setInt(1, ordem.getIdMaquina().getId());
                psOrdem.setInt(2, ordem.getIdTecnico().getId());
                psOrdem.executeUpdate();

                try (ResultSet rs = psOrdem.getGeneratedKeys()) {
                    if (rs.next()) {
                        int ordemId = rs.getInt(1);
                        // opcional: atribuir ordemId à entidade se houver setter
                        // ordem.setId(ordemId);
                    }
                }
            }

            try (PreparedStatement psMaquina = conn.prepareStatement(sqlMaquina)) {
                psMaquina.setInt(1, ordem.getIdMaquina().getId());
                psMaquina.executeUpdate();
            }

            conn.commit();
        } catch (SQLException e) {
            throw e;
        }
    }


    public List<OrdemManutencao> listarOrdens() throws SQLException {
        List<OrdemManutencao> ordens = new ArrayList<>();

        String sql = """
                SELECT id, idMaquina, idTecnico, dataSolicitacao, status
                FROM OrdemManutencao
                WHERE status = 'PENDENTE'
                """;

        try (Connection conn = Conexao.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int idMaquina = rs.getInt("idMaquina");
                int idTecnico = rs.getInt("idTecnico");
                Date dataSolicitacao = rs.getDate("dataSolicitacao");
                String status = rs.getString("status");

                OrdemManutencao ordem = new OrdemManutencao(id, new Maquina(idMaquina), new Tecnico(idTecnico), dataSolicitacao.toLocalDate(), StatusOrdemManutencao.valueOf(status));
                ordens.add(ordem);
            }
        }
        return ordens;
    }

    public OrdemManutencao buscarOrdemPorId(int id) throws SQLException{
        String sql = """
                SELECT id, idMaquina, idTecnico, dataSolicitacao, status
                FROM OrdemManutencao
                WHERE id = ?
                """;
        try (Connection conn = Conexao.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                int idOrdem = rs.getInt("id");
                int idMaquina = rs.getInt("idMaquina");
                int idTecnico = rs.getInt("idTecnico");
                Date dataSolicitacao = rs.getDate("dataSolicitacao");
                String status = rs.getString("status");

                return new OrdemManutencao(idOrdem, new Maquina(idMaquina), new Tecnico(idTecnico), dataSolicitacao.toLocalDate(), StatusOrdemManutencao.valueOf(status));
            }
        }
        return null;
    }

    public boolean existeIdOrdem(int id) throws SQLException{
        boolean existe = false;

        String sql = """
                SELECT id, idMaquina, idTecnico, dataSolicitacao, status
                FROM OrdemManutencao
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
