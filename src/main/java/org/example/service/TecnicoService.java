package org.example.service;

import org.example.dao.TecnicoDAO;
import org.example.model.Tecnico;
import org.example.view.ViewGeral;
import org.example.view.ViewTecnico;

import java.sql.SQLException;

public class TecnicoService {

    ViewTecnico viewTecnico = new ViewTecnico();
    TecnicoDAO tecnicoDAO = new TecnicoDAO();
    ViewGeral viewGeral = new ViewGeral();

    public void cadastrarTecnico(){
        var tecnico = new Tecnico();
        tecnico = viewTecnico.cadastrarTecnico();
        if(tecnico.getNome() == null || tecnico.getNome().isEmpty() ||tecnico.getEspecialidade() == null || tecnico.getEspecialidade().isEmpty()){
            viewGeral.mostrarMensagemErroPorSerNulo();
        }else{
            try{
                tecnico = new Tecnico(tecnico.getNome(), tecnico.getEspecialidade());
                tecnicoDAO.cadastrarTecnico(tecnico);
                viewGeral.mostarMensagemCadastro();
            } catch (SQLException e) {
                viewGeral.mostrarMensagemErro();
                e.printStackTrace();
            }
        }
    }
}
