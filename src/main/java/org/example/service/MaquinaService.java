package org.example.service;

import org.example.dao.MaquinaDAO;
import org.example.model.Maquina;
import org.example.view.ViewMaquina;

import java.sql.SQLException;

public class MaquinaService {

    ViewMaquina viewMaquina = new ViewMaquina();
    MaquinaDAO maquinaDAO = new MaquinaDAO();

    public void cadastrarMaquina(String nome, String setor) {
        if(nome == null || nome.isEmpty()|| setor == null || setor.isEmpty()){
            System.out.println("[ERRO] Nome e setor da máquina são obrigatórios.");
        } else {
            try {
                var maquina = new Maquina(nome, setor);
                maquinaDAO.cadastrarMaquina(maquina);
                viewMaquina.mostarMensagemCadastro();
            } catch (SQLException e) {
                viewMaquina.mostrarMensagemErro();
                e.printStackTrace();
            }
        }
    }
}
