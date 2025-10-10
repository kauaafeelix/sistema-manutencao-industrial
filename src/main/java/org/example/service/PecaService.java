package org.example.service;

import org.example.dao.PecaDAO;
import org.example.model.Peca;
import org.example.utils.UtilsGerais;
import org.example.view.ViewPeca;

import java.sql.SQLException;

public class PecaService {

    ViewPeca viewPeca = new ViewPeca();
    PecaDAO pecaDAO = new PecaDAO();
    UtilsGerais utils = new UtilsGerais();

    public void cadastrarPeca () {
        var peca = new Peca();
        peca = viewPeca.cadastrarPeca();

        if(peca.getNome() == null || peca.getNome().isEmpty() || peca.getEstoque() == null || peca.getEstoque() < 0){
            System.out.println("[ERRO] Dados inválidos. Por favor, tente novamente.");
        } else {

            try {
                peca = new Peca(peca.getNome(), peca.getEstoque());
                pecaDAO.cadastrarPeca(peca);
                utils.mostarMensagemCadastro();
            } catch (SQLException e) {
                utils.mostrarMensagemErro();
                e.printStackTrace();
            }
        }
    }
}
