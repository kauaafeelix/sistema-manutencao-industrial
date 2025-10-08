package org.example.controller;

import org.example.dao.PecaDAO;
import org.example.model.Peca;

import java.sql.SQLException;

public class ControllerPeca {

    private PecaDAO pecaDAO = new PecaDAO();

    public void cadastrarPeca(String nome, Double estoque) throws SQLException {
        if (nome == null || nome.isEmpty() || estoque == null || estoque < 0) {
            System.out.println("Nome não pode ser vazio e estoque não pode ser negativo.");
        } else {
            Peca peca = new Peca(nome, estoque);

            pecaDAO.cadastrarPeca(peca);
        }
    }
}
