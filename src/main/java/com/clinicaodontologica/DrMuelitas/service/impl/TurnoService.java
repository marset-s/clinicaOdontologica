package com.clinicaodontologica.DrMuelitas.service.impl;

import com.clinicaodontologica.DrMuelitas.dto.TurnoDto;
import com.clinicaodontologica.DrMuelitas.entity.Turno;
import com.clinicaodontologica.DrMuelitas.exception.BadRequestException;
import com.clinicaodontologica.DrMuelitas.exception.ResourceNotFoundException;
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
    public TurnoDto registrarTurno(Turno turno) throws BadRequestException {
        TurnoDto turnoGuardado;
        if (turno.getPaciente() == null || turno.getOdontologo() == null) {
            if (turno.getPaciente() == null && turno.getOdontologo() == null) {
                LOGGER.error("😬 El paciente y el odontólogo son nulos.");
                throw new BadRequestException("El paciente y el odontólogo son nulos.");
            } else if (turno.getPaciente() == null) {
                LOGGER.error("🫤 El paciente es nulo.");
                throw new BadRequestException("😯 El paciente es nulo.");
            } else {
                LOGGER.error("🫤 El odontólogo es nulo.");
                throw new BadRequestException("😯 El odontólogo es nulo.");
            }
        } else {
            turnoGuardado = new TurnoDto(turnoRepository.save(turno));
            LOGGER.info("🤩 Se guardó exitosamente tu turno: {}", turnoGuardado);
        }
        return turnoGuardado;
    }

    @Override
    public List<TurnoDto> listarTurnos() {
        List<TurnoDto> turnos = turnoRepository.findAll()
                .stream()
                .map(TurnoDto::new)
                .toList();
        LOGGER.info("😎 Listando todos nuestros turnos: {}", turnos);
        return turnos;
    }

    @Override
    public TurnoDto buscarTurnoPorId(Long id) throws ResourceNotFoundException {
        Turno turno = turnoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("🫤 No encontrado"));
        TurnoDto turnoConvertido = new TurnoDto(turno);
        LOGGER.info("😎 Turno encontrado: {}", turnoConvertido);
        return turnoConvertido;
    }

    @Override
    public TurnoDto actualizarTurno(Turno turno) throws ResourceNotFoundException, BadRequestException {
        TurnoDto turnoActualizado;
        if (!turnoRepository.existsById(turno.getId())) {
            LOGGER.warn("😬 No es posible actualizar el turno.");
            throw new ResourceNotFoundException("🫤 El turno no existe en la base de datos.");
        } else {
            turnoActualizado = registrarTurno(turno);
            LOGGER.warn("🤩 Se ha actualizado el turno con Id {}: {}", turnoActualizado.getId(), turnoActualizado);
        }
        return turnoActualizado;
    }

    @Override
    public void eliminarTurno(Long id) throws ResourceNotFoundException {
        if (turnoRepository.existsById(id)) {
            turnoRepository.deleteById(id);
            LOGGER.warn("🫡 Se ha eliminado el turno");
        } else {
            LOGGER.warn("😯 El turno con id {}, no existe en la base de datos", id);
            throw new ResourceNotFoundException("😬 El turno con id {}, no existe en la base de datos");
        }
    }
}
