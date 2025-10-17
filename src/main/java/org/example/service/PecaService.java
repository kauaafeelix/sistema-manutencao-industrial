package org.example.service;

import org.example.dao.PecaDAO;
import org.example.model.Peca;
import org.example.view.ViewGeral;
import org.example.view.ViewPeca;

import java.sql.SQLException;

public class PecaService {

    ViewPeca viewPeca = new ViewPeca();
    PecaDAO pecaDAO = new PecaDAO();
    ViewGeral viewGeral = new ViewGeral();

    public void cadastrarPeca () {
        var peca = new Peca();
        peca = viewPeca.cadastrarPeca();

        if(peca.getNome() == null || peca.getNome().isEmpty() || peca.getEstoque() < 0){
            viewGeral.mostrarMensagemErroPorSerNulo();
        } else {

            try {
                peca = new Peca(peca.getNome(), peca.getEstoque());
                pecaDAO.cadastrarPeca(peca);
                viewGeral.mostarMensagemCadastro();
            } catch (SQLException e) {
                viewGeral.mostrarMensagemErro();
                e.printStackTrace();
            }
        }
    }
}
