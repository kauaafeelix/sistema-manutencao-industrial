package org.example.service;

import org.example.dao.MaquinaDAO;
import org.example.model.Maquina;
import org.example.utils.UtilsGerais;
import org.example.view.ViewMaquina;

import java.sql.SQLException;

public class MaquinaService {

    ViewMaquina viewMaquina = new ViewMaquina();
    MaquinaDAO maquinaDAO = new MaquinaDAO();
    UtilsGerais utils = new UtilsGerais();


    public void cadastrarMaquina() {
        var maquina = new Maquina();
        maquina = viewMaquina.cadastroMaquina();
        if(maquina.getNome() == null || maquina.getNome().isEmpty()|| maquina.getSetor() == null || maquina.getSetor().isEmpty()){
            System.out.println("[ERRO] Dados inválidos. Por favor, tente novamente.");
        } else {
            try {
                maquina = new Maquina(maquina.getNome(), maquina.getSetor());
                maquinaDAO.cadastrarMaquina(maquina);
                utils.mostarMensagemCadastro();
            } catch (SQLException e) {
                utils.mostrarMensagemErro();
                e.printStackTrace();
            }
        }
    }
}
