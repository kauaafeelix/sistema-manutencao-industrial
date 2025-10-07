package org.example.controller;

import org.example.dao.TecnicoDAO;
import org.example.model.Tecnico;

import java.sql.SQLException;

public class ControllerTecnico {

    TecnicoDAO tecnicoDAO = new TecnicoDAO();

    public void cadastrarTecnico(String nome, String especialidade) throws SQLException {

        if (nome == null || nome.isEmpty() || especialidade == null || especialidade.isEmpty() ) {
            System.out.println("Nome ou especialidade não podem ser vazios");
        }else {
            Tecnico tecnico = new Tecnico(nome, especialidade);

            tecnicoDAO.cadastrarTecnico(tecnico);
        }
    }
}
