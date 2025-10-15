package org.example.service;

import org.example.dao.MaquinaDAO;
import org.example.dao.OrdemManutencaoDAO;
import org.example.dao.TecnicoDAO;
import org.example.model.Maquina;
import org.example.model.OrdemManutencao;
import org.example.model.Tecnico;
import org.example.utils.MaquinaUtils;
import org.example.utils.TecnicoUtils;
import org.example.view.ViewGeral;
import org.example.view.ViewMaquina;
import org.example.view.ViewOrdemManutencao;
import org.example.view.ViewTecnico;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrdemManutencaoService {


    ViewOrdemManutencao viewOrdemManutencao = new ViewOrdemManutencao();
    OrdemManutencaoDAO ordemManutencaoDAO = new OrdemManutencaoDAO();
    MaquinaDAO maquinaDAO = new MaquinaDAO();
    TecnicoDAO tecnicoDAO = new TecnicoDAO();
    ViewGeral viewGeral = new ViewGeral();
    ViewMaquina viewMaquina = new ViewMaquina();
    ViewTecnico viewTecnico = new ViewTecnico();
    MaquinaUtils maquinaUtils = new MaquinaUtils();
    TecnicoUtils tecnicoUtils = new TecnicoUtils();

    public void cadastrarOrdemManutencao() {

        viewOrdemManutencao.menuCriarOrdemManutencao();

        try {
            List<Maquina>maquinas = new ArrayList<>();
            if (maquinas.isEmpty() || maquinas == null) {
            maquinaUtils.exibirMaquinas(maquinas);
            return;
            }else {
                maquinaUtils.exibirMaquinas(maquinas);
                int idMaquina = viewOrdemManutencao.criarOrdemManutencaoIdMaquina();
                var maquina = maquinaDAO.buscarMaquinaPorId(idMaquina);
                if (maquina == null) {
                    viewMaquina.mensagemNaoExisteMaquina();
                    return;
                } else {
                    int idTecnico = viewOrdemManutencao.criarOrdemManutencaoIdTecnico();
                    var tecnico = tecnicoDAO.buscarTecnicoPorId(idTecnico);
                    if (tecnico == null) {
                        viewTecnico.mensagemNaoExisteTecnico();
                        return;
                    }
                    else{
                        var ordemManutencaoDAO = new OrdemManutencaoDAO();
                        OrdemManutencao ordemManutencao = new OrdemManutencao(maquina, tecnico);
                        ordemManutencaoDAO.criarOrdemManutencao(ordemManutencao);
                        viewGeral.mostarMensagemCadastro();
                    }
                }
            }
        } catch (SQLException e) {
            viewGeral.mostrarMensagemErro();
            e.printStackTrace();
        }
    }
}
