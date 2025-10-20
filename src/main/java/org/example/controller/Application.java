package org.example.controller;

import org.example.service.MaquinaService;
import org.example.service.PecaService;
import org.example.service.TecnicoService;
import org.example.view.ViewGeral;

public class Application {
    ViewGeral viewGeral = new ViewGeral();


    public void controllerGeral () {

        do {

            switch (viewGeral.menuGeral()) {
                case 1 -> {
                    ControllerMaquina controllerMaquina = new ControllerMaquina();
                    controllerMaquina.maquinaController();
                }
                case 2 -> {
                    ControllerTecnico controllerTecnico = new ControllerTecnico();
                    controllerTecnico.tecnicoController();
                }
                case 3 -> {
                    ControllerPeca controllerPeca = new ControllerPeca();
                    controllerPeca.pecaController();
                }
                case 4 -> {
                    ControllerOrdemManutencao controllerOrdemManutencao = new ControllerOrdemManutencao();
                    controllerOrdemManutencao.ordemManutencaoController();
                }
                case 5 ->{
                    ControllerOrdemPeca controllerOrdemPeca = new ControllerOrdemPeca();
                    controllerOrdemPeca.ordemPecaController();
                }
                case 0 -> {
                    viewGeral.encerrando();
                }
            }
        }while (viewGeral.menuGeral() != 0);
    }
}

