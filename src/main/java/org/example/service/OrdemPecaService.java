package org.example.service;

import org.example.dao.OrdemManutencaoDAO;
import org.example.dao.OrdemPecaDAO;
import org.example.dao.PecaDAO;
import org.example.model.OrdemManutencao;
import org.example.model.OrdemPeca;
import org.example.model.Peca;
import org.example.utils.OrdemManutencaoUtils;
import org.example.utils.PecaUtils;
import org.example.view.ViewGeral;
import org.example.view.ViewOrdemPeca;

import java.sql.SQLException;
import java.util.List;

public class OrdemPecaService {

    ViewOrdemPeca viewOrdemPeca = new ViewOrdemPeca();
    OrdemPecaDAO ordemPecaDAO = new OrdemPecaDAO();
    PecaDAO pecaDAO = new PecaDAO();
    OrdemManutencaoDAO ordemManutencaoDAO = new OrdemManutencaoDAO();
    OrdemManutencaoUtils ordemManutencaoUtils = new OrdemManutencaoUtils();
    PecaUtils pecaUtils = new PecaUtils();
    ViewGeral viewGeral = new ViewGeral();

    public void cadastrarOrdemPeca(){

        try{
            List<OrdemManutencao>ordens = ordemManutencaoDAO.listarOrdens();
            if(ordens == null || ordens.isEmpty()){
                ordemManutencaoUtils.exibirOrdens(ordens);
                return;
            }
            ordemManutencaoUtils.exibirOrdens(ordens);
            int idOrdem = viewOrdemPeca.cadastroOrdemPecaIdOrdemManutencao();
            var ordemManutencao = ordemManutencaoDAO.buscarOrdemPorId(idOrdem);
            if(ordemManutencao == null){
                viewGeral.mostrarMensagemIdInvalido();
                return;
            }

            List<Peca>pecas = pecaDAO.listarPecas();
            if (pecas == null || pecas.isEmpty()) {
                pecaUtils.exibirPeca(pecas);
                return;
            }
            pecaUtils.exibirPeca(pecas);
            int idPeca = viewOrdemPeca.cadastroOrdemPecaIdPeca();
            var peca = pecaDAO.buscarPecaPorId(idPeca);;
            if(peca == null){
                viewGeral.mostrarMensagemIdInvalido();
                return;
            }

            double quantidade = viewOrdemPeca.cadastroOrdemPecaQuantidade();
            var ordemPeca = new OrdemPeca(ordemManutencao, peca, quantidade);
            ordemPecaDAO.cadastrarOrdemPeca(ordemPeca);

            viewGeral.mostarMensagemCadastro();

        }catch (SQLException e){
            viewGeral.mostrarMensagemErro();
            e.printStackTrace();
        }
    }
}
