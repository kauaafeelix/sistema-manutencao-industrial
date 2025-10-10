package org.example.controller;

import org.example.dao.MaquinaDAO;
import org.example.model.Maquina;
import org.example.service.MaquinaService;
import org.example.view.ViewMaquina;

import java.sql.SQLException;

public class ControllerMaquina {

    ViewMaquina viewMaquina = new ViewMaquina();
    MaquinaService maquinaService = new MaquinaService();

    public void maquinaController(){
        switch (viewMaquina.menuMaquina()){

            case 1-> {
                maquinaService.cadastrarMaquina();
            }
        }
    }

}
