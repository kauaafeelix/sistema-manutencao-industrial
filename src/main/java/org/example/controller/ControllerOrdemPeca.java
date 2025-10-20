package org.example.controller;

import org.example.service.OrdemManutencaoService;
import org.example.view.ViewGeral;
import org.example.view.ViewOrdemPeca;

public class ControllerOrdemPeca {
    ViewOrdemPeca viewOrdemPeca = new ViewOrdemPeca();
    OrdemManutencaoService ordemManutencaoService = new OrdemManutencaoService();
    ViewGeral viewGeral = new ViewGeral();

    public void ordemPecaController() {
        do {
            switch (viewOrdemPeca.menuOrdemPeca()) {
                case 1 ->{
                    ordemManutencaoService.cadastrarOrdemManutencao();
                }
                case 0 ->{
                    viewGeral.menuGeral();
                }
            }
        }while (viewOrdemPeca.menuOrdemPeca() != 0);
    }
}
