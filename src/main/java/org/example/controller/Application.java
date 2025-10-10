package org.example.controller;

import org.example.service.MaquinaService;
import org.example.service.PecaService;
import org.example.service.TecnicoService;
import org.example.view.ViewGeral;

public class Application {
    int opcao = ViewGeral.menuGeral();

    public int controllerGeral (){

        switch (opcao){
            case 1 ->{
                ControllerMaquina controllerMaquina = new ControllerMaquina();
                controllerMaquina.maquinaController();
            }
            case 2 ->{
                ControllerTecnico controllerTecnico = new ControllerTecnico();
                controllerTecnico.tecnicoController();
            }
            case 3 ->{
                ControllerPeca controllerPeca = new ControllerPeca();
                controllerPeca.pecaController();
            }
        }
        return 0;
    }
}
