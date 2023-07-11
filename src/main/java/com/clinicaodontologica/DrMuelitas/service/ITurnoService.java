package com.clinicaodontologica.DrMuelitas.service;

import com.clinicaodontologica.DrMuelitas.dto.TurnoDto;
import com.clinicaodontologica.DrMuelitas.entity.Turno;

import java.util.List;

public interface ITurnoService {

    //C
    TurnoDto registrarTurno(Turno turno);

    //R
    List<TurnoDto> listarTurnos();

    TurnoDto buscarTurnoPorId(Long id);

    //U
    TurnoDto actualizarTurno(Turno turno);

    //D
    void eliminarTurno(Long id);


}
