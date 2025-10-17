package org.example.controller;

import org.example.service.OrdemManutencaoService;
import org.example.view.ViewGeral;
import org.example.view.ViewOrdemManutencao;

public class ControllerOrdemManutencao {

    ViewOrdemManutencao viewOrdemManutencao = new ViewOrdemManutencao();
    OrdemManutencaoService ordemManutencaoService = new OrdemManutencaoService();
    ViewGeral viewGeral = new ViewGeral();

    public void ordemManutencaoController(){

        do{
        switch (viewOrdemManutencao.menuOrdemManutencao()){
            case 1->{
                ordemManutencaoService.cadastrarOrdemManutencao();
            }
            case 0 ->{
                viewGeral.menuGeral();
            }
        }
    } while (viewOrdemManutencao.menuOrdemManutencao() != 0);
}
}
