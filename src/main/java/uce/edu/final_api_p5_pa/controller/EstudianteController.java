package uce.edu.final_api_p5_pa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uce.edu.final_api_p5_pa.repository.modelo.Estudiante;
import uce.edu.final_api_p5_pa.service.IEstudianteService;
import uce.edu.final_api_p5_pa.service.to.EstudianteTO;

@RestController
@RequestMapping("/estudiantes")
@CrossOrigin

/**
 * 
 */
public class EstudianteController {

    @Autowired
    private IEstudianteService estuService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void guardar(@RequestBody Estudiante entity) {
        this.estuService.guardar(entity);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EstudianteTO>> consultarTodos() {

        return ResponseEntity.status(HttpStatus.OK).body(this.estuService.consultarTodos());
    }

    @GetMapping(path = "/{cedula}", produces = "application/json")
    public ResponseEntity<EstudianteTO> consultarTelefono(@PathVariable String cedula) {
        EstudianteTO estudianteTO = this.estuService.consultarCedula(cedula);
        return ResponseEntity.status(HttpStatus.OK).body(estudianteTO);
    }
}
