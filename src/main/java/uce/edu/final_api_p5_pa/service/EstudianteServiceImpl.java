package uce.edu.final_api_p5_pa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uce.edu.final_api_p5_pa.repository.IEstudianteRepo;
import uce.edu.final_api_p5_pa.repository.modelo.Estudiante;
import uce.edu.final_api_p5_pa.service.to.EstudianteTO;

@Service
public class EstudianteServiceImpl implements IEstudianteService{

    @Autowired
    private IEstudianteRepo repo;
    
    @Override
    public void guardar(Estudiante e) {
        this.repo.insertar(e);
        
    }

    @Override
    public List<EstudianteTO> consultarTodos() {
        List<EstudianteTO> listaFinal = new ArrayList<>();
        List<Estudiante> lista = this.repo.seleccionarTodos();
        for (Estudiante estudiante : lista) {
            listaFinal.add(this.convertir(estudiante));
        }
        return listaFinal;
    }

    private EstudianteTO convertir(Estudiante e) {
        EstudianteTO estudianteTO = new EstudianteTO();
        estudianteTO.setId(e.getId());
        estudianteTO.setNombre(e.getNombre());
        estudianteTO.setApellido(e.getApellido());
        estudianteTO.setCedula(e.getCedula());
        return estudianteTO;        
    }

    @Override
    public EstudianteTO consultarCedula(String cedula) {
        
        return this.convertir(this.repo.seleccionarCedula(cedula));
    }

}
