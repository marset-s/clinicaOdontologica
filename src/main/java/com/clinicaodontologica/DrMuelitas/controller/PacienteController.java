package com.clinicaodontologica.DrMuelitas.controller;

import com.clinicaodontologica.DrMuelitas.dto.PacienteDto;
import com.clinicaodontologica.DrMuelitas.entity.Paciente;
import com.clinicaodontologica.DrMuelitas.exception.ResourceNotFoundException;
import com.clinicaodontologica.DrMuelitas.service.impl.PacienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/pacientes")
public class PacienteController {

    private final PacienteService pacienteService;


    @Autowired
    public PacienteController(PacienteService pacienteService, ObjectMapper mapper) {
        this.pacienteService = pacienteService;
    }

    @PostMapping
    public ResponseEntity<PacienteDto> registrarPaciente(@RequestBody @Valid  Paciente paciente) {
        PacienteDto pacienteGuardado = pacienteService.registrarPaciente(paciente);
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteGuardado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteDto> buscarPacientePorId(@PathVariable Long id) throws ResourceNotFoundException {
        PacienteDto pacienteEncontrado = pacienteService.buscarPacientePorId(id);
        return ResponseEntity.ok(pacienteEncontrado);
    }

    @GetMapping
    public List<PacienteDto> listarPacientes() {
        return pacienteService.listarPacientes();
    }

    @PutMapping
    public ResponseEntity<PacienteDto> actualizarPaciente(@RequestBody @Valid Paciente paciente) throws ResourceNotFoundException {
        PacienteDto pacienteEncontrado = pacienteService.actualizarPaciente(paciente);
        return ResponseEntity.ok(pacienteEncontrado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPaciente(@PathVariable Long id) throws ResourceNotFoundException {
        pacienteService.eliminarPaciente(id);
        return ResponseEntity.ok("😉 Paciente eliminado con éxito.");
    }

}
