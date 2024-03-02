package uce.edu.final_api_p5_pa.repository;

import java.util.List;

import uce.edu.final_api_p5_pa.repository.modelo.Estudiante;

public interface IEstudianteRepo {
    public void insertar(Estudiante e);

    public List<Estudiante> seleccionarTodos();

    public Estudiante seleccionarCedula(String cedula);

}