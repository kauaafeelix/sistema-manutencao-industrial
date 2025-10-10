package org.example.service;

import org.example.dao.TecnicoDAO;
import org.example.model.Tecnico;
import org.example.utils.UtilsGerais;
import org.example.view.ViewTecnico;

import java.sql.SQLException;

public class TecnicoService {

    ViewTecnico viewTecnico = new ViewTecnico();
    TecnicoDAO tecnicoDAO = new TecnicoDAO();
    UtilsGerais utils = new UtilsGerais();

    public void cadastrarTecnico(){
        var tecnico = new Tecnico();
        tecnico = viewTecnico.cadastrarTecnico();
        if(tecnico.getNome() == null || tecnico.getNome().isEmpty()
                ||tecnico.getEspecialidade() == null || tecnico.getEspecialidade().isEmpty()){
            System.out.println("Dados inválidos. Tente novamente.");

        }else{
            try{
                tecnico = new Tecnico(tecnico.getNome(), tecnico.getEspecialidade());
                tecnicoDAO.cadastrarTecnico(tecnico);
                utils.mostarMensagemCadastro();
            } catch (SQLException e) {
                utils.mostrarMensagemErro();
                e.printStackTrace();
            }
        }
    }
}
