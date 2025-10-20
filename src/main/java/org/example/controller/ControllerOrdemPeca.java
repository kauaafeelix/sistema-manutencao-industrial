package org.example.controller;

import org.example.model.OrdemPeca;
import org.example.service.OrdemManutencaoService;
import org.example.service.OrdemPecaService;
import org.example.view.ViewGeral;
import org.example.view.ViewOrdemPeca;

public class ControllerOrdemPeca {
    ViewOrdemPeca viewOrdemPeca = new ViewOrdemPeca();
    OrdemPecaService ordemPecaService = new OrdemPecaService();
    ViewGeral viewGeral = new ViewGeral();

    public void ordemPecaController() {
        do {
            switch (viewOrdemPeca.menuOrdemPeca()) {
                case 1 ->{
                    ordemPecaService.cadastrarOrdemPeca();
                }
                case 0 ->{
                    viewGeral.menuGeral();
                }
            }
        }while (viewOrdemPeca.menuOrdemPeca() != 0);
    }
}
