package org.example.dao;

import org.example.connection.Conexao;
import org.example.model.OrdemManutencao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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

          try (PreparedStatement psOrdem = conn.prepareStatement(sqlOrdem)) {

              psOrdem.setInt(1, ordem.getIdMaquina().getId());
              psOrdem.setInt(2, ordem.getIdTecnico().getId());
              psOrdem.setDate(3, Date.valueOf(ordem.getDataSolicitacao()));
              psOrdem.executeUpdate();
          }

          try(PreparedStatement psMaquina = conn.prepareStatement(sqlMaquina)){
              psMaquina.setInt(1, ordem.getIdMaquina().getId());
              psMaquina.executeUpdate();
          }
      }
  }
}
