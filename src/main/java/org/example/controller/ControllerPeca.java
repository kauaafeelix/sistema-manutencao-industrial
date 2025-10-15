package org.example.controller;

import org.example.dao.PecaDAO;
import org.example.model.Peca;
import org.example.service.PecaService;
import org.example.view.ViewPeca;

import java.sql.SQLException;

public class ControllerPeca {

    ViewPeca viewPeca = new ViewPeca();
    PecaService pecaService = new PecaService();

    public void pecaController(){
        do {

        switch (viewPeca.menuPeca()){

            case 1-> {
                pecaService.cadastrarPeca();
            }
        }
        }while (viewPeca.menuPeca() != 0);
    }
}
