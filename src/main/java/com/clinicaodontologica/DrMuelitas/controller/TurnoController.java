package com.clinicaodontologica.DrMuelitas.controller;

import com.clinicaodontologica.DrMuelitas.dto.TurnoDto;
import com.clinicaodontologica.DrMuelitas.entity.Turno;
import com.clinicaodontologica.DrMuelitas.exception.BadRequestException;
import com.clinicaodontologica.DrMuelitas.exception.ResourceNotFoundException;
import com.clinicaodontologica.DrMuelitas.service.impl.TurnoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/turnos")
public class TurnoController {

    private final TurnoService turnoService;

    public TurnoController(TurnoService turnoService) {
        this.turnoService = turnoService;
    }

    @PostMapping
    public ResponseEntity<TurnoDto> registrarTurno(@RequestBody @Valid Turno turno) throws BadRequestException {
        return ResponseEntity.status(HttpStatus.CREATED).body(turnoService.registrarTurno(turno));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TurnoDto> buscarTurnoPorId(@PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(turnoService.buscarTurnoPorId(id));
    }

    @GetMapping
    public List<TurnoDto> listarTurnos() {
        return turnoService.listarTurnos();
    }

    @PutMapping
    public ResponseEntity<TurnoDto> actualizarTurno(@RequestBody @Valid Turno turno) throws BadRequestException, ResourceNotFoundException {
        return ResponseEntity.ok(turnoService.actualizarTurno(turno));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarTurnoPorId(@PathVariable Long id) {
        return ResponseEntity.ok("😉 Turno eliminado con éxito.");
    }
}
