package uce.edu.final_api_p5_pa.service;

import java.util.List;

import uce.edu.final_api_p5_pa.repository.modelo.Estudiante;
import uce.edu.final_api_p5_pa.service.to.EstudianteTO;

public interface IEstudianteService {
    public void guardar(Estudiante e);

    public List<EstudianteTO> consultarTodos();

    public EstudianteTO consultarCedula(String cedula);
}
