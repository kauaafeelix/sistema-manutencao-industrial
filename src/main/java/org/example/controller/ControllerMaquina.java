package org.example.controller;

import org.example.dao.MaquinaDAO;
import org.example.model.Maquina;

import java.sql.SQLException;

public class ControllerMaquina {

    private MaquinaDAO maquinaDAO = new MaquinaDAO();

    public void cadastrarMaquina(String nome, String setor) throws SQLException {

        if(nome == null || nome.isEmpty()|| setor == null || setor.isEmpty()){

            System.out.println("Nome e setor da máquina são obrigatórios.");

        } else {
            Maquina maquina = new Maquina(nome, setor);

            maquinaDAO.cadastrarMaquina(maquina);
        }
    }
}
