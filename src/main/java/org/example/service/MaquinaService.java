package org.example.service;

import org.example.dao.MaquinaDAO;
import org.example.model.Maquina;
import org.example.view.ViewGeral;
import org.example.view.ViewMaquina;

import java.sql.SQLException;

public class MaquinaService {

    ViewMaquina viewMaquina = new ViewMaquina();
    MaquinaDAO maquinaDAO = new MaquinaDAO();
    ViewGeral viewGeral = new ViewGeral();

    public void cadastrarMaquina() {
        var maquina = new Maquina();
        maquina = viewMaquina.cadastroMaquina();
        if(maquina.getNome() == null || maquina.getNome().isEmpty()|| maquina.getSetor() == null || maquina.getSetor().isEmpty()){
            viewGeral.mostrarMensagemErroPorSerNulo();
        } else {
            try {
                maquina = new Maquina(maquina.getNome(), maquina.getSetor());
                maquinaDAO.cadastrarMaquina(maquina);
                viewGeral.mostarMensagemCadastro();
            } catch (SQLException e) {
                viewGeral.mostrarMensagemErro();
                e.printStackTrace();
            }
        }
    }
}
