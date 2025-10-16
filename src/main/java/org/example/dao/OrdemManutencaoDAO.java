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

        String sqlGetId = "SELECT id FROM OrdemManutencao ORDER BY id DESC LIMIT 1";

        String sqlOrdemPeca = """
                INSERT INTO OrdemPeca (
                idOrdemManutencao,
                idPeca,
                quantidade)
                VALUES (?, ?, ?)
                """;

        String sqlMaquina = """
                UPDATE Maquina
                SET status = 'EM_MANUTENCAO'
                WHERE id = ?
                """;


        try (Connection conn = Conexao.conectar()) {

            try (PreparedStatement psOrdem = conn.prepareStatement(sqlOrdem)) {

                psOrdem.setInt(1, ordem.getIdMaquina().getId());
                psOrdem.setInt(2, ordem.getIdTecnico().getId());
                psOrdem.executeUpdate();
            }

            try (PreparedStatement psGetId = conn.prepareStatement(sqlGetId);
                 ResultSet rs = psGetId.executeQuery()) {
                if (rs.next()) {
                    rs.getInt("id");
                    return;
                }
            }

            try (PreparedStatement psMaquina = conn.prepareStatement(sqlMaquina)) {
                psMaquina.setInt(1, ordem.getIdMaquina().getId());
                psMaquina.executeUpdate();
            }

            try (PreparedStatement psOrdemPeca = conn.prepareStatement(sqlOrdemPeca)) {
                var op = new OrdemPeca();
                var peca = new Peca();
                psOrdemPeca.setInt(1, ordem.getId());
                psOrdemPeca.setInt(2, peca.getId());
                psOrdemPeca.setDouble(3, op.getQuantidade());

            }
        }
    }

    public List<OrdemManutencao> ordemManutencaos() throws SQLException {
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
}
