package org.example.dao;

import org.example.connection.Conexao;
import org.example.model.OrdemManutencao;
import org.example.model.OrdemPeca;
import org.example.model.Peca;

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

          try(PreparedStatement psMaquina = conn.prepareStatement(sqlMaquina)){
              psMaquina.setInt(1, ordem.getIdMaquina().getId());
              psMaquina.executeUpdate();
          }

          try(PreparedStatement psOrdemPeca = conn.prepareStatement(sqlOrdemPeca)){
              var op = new OrdemPeca();
              var peca = new Peca();
              psOrdemPeca.setInt(1, ordem.getId());
              psOrdemPeca.setInt(2, peca.getId());
              psOrdemPeca.setDouble(3, op.getQuantidade());

          }
      }
  }
}
