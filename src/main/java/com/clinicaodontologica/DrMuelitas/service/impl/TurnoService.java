package com.clinicaodontologica.DrMuelitas.service.impl;

import com.clinicaodontologica.DrMuelitas.dto.TurnoDto;
import com.clinicaodontologica.DrMuelitas.entity.Turno;
import com.clinicaodontologica.DrMuelitas.repository.TurnoRepository;
import com.clinicaodontologica.DrMuelitas.service.ITurnoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TurnoService implements ITurnoService {


    private final TurnoRepository turnoRepository;

    private final ObjectMapper mapper;

    @Autowired
    public TurnoService(TurnoRepository turnoRepository, ObjectMapper mapper) {
        this.turnoRepository = turnoRepository;
        this.mapper = mapper;
    }


    @Override
    public TurnoDto registrarTurno(Turno turno) {
        return null;
    }

    @Override
    public List<TurnoDto> listarTurnos() {
        return null;
    }

    @Override
    public TurnoDto buscarTurnoPorId(Long id) {
        return null;
    }

    @Override
    public TurnoDto actualizarTurno(Turno turno) {
        return null;
    }

    @Override
    public void eliminarTurno(Long id) {

    }
}
