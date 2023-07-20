package com.clinicaodontologica.DrMuelitas.service;

import com.clinicaodontologica.DrMuelitas.dto.TurnoDto;
import com.clinicaodontologica.DrMuelitas.entity.Turno;
import com.clinicaodontologica.DrMuelitas.exception.BadRequestException;
import com.clinicaodontologica.DrMuelitas.exception.ResourceNotFoundException;

import java.util.List;

public interface ITurnoService {

    //C
    TurnoDto registrarTurno(Turno turno) throws BadRequestException;

    //R
    List<TurnoDto> listarTurnos();

    TurnoDto buscarTurnoPorId(Long id) throws ResourceNotFoundException;

    //U
    TurnoDto actualizarTurno(Turno turno) throws ResourceNotFoundException, BadRequestException;

    //D
    void eliminarTurno(Long id) throws ResourceNotFoundException;


}
