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

      String sql = """
              INSERT INTO OrdemManutencao ( 
              idMaquina, 
              idTecnico,
              dataSolicitacao,
              status )
              VALUES (?, ?, ?, 'PENDENTE')
              """;

      try (Connection conn = Conexao.conectar();
           PreparedStatement ps = conn.prepareStatement(sql)){

          ps.setInt(1, ordem.getIdMaquina().getId());
          ps.setInt(2, ordem.getIdTecnico().getId());
          ps.setDate(3, Date.valueOf(ordem.getDataSolicitacao()));
          ps.executeUpdate();
      }
  }
}
