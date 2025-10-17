package org.example.controller;

import org.example.dao.TecnicoDAO;
import org.example.model.Tecnico;
import org.example.service.TecnicoService;
import org.example.view.ViewGeral;
import org.example.view.ViewTecnico;

import java.sql.SQLException;

public class ControllerTecnico {

    ViewTecnico viewTecnico = new ViewTecnico();
    TecnicoService tecnicoService = new TecnicoService();
    ViewGeral viewGeral = new ViewGeral();

    public void tecnicoController(){

        do{
        switch (viewTecnico.menuTecnico()){
            case 1-> {
                tecnicoService.cadastrarTecnico();
            }
            case 0->{
                viewGeral.menuGeral();
            }
        }
        }while(viewTecnico.menuTecnico() != 0);
    }
}
