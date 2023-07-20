package com.clinicaodontologica.DrMuelitas.service.impl;


import com.clinicaodontologica.DrMuelitas.dto.DomicilioDto;
import com.clinicaodontologica.DrMuelitas.dto.PacienteDto;
import com.clinicaodontologica.DrMuelitas.entity.Paciente;
import com.clinicaodontologica.DrMuelitas.exception.BadRequestException;
import com.clinicaodontologica.DrMuelitas.exception.ResourceNotFoundException;
import com.clinicaodontologica.DrMuelitas.repository.PacienteRepository;
import com.clinicaodontologica.DrMuelitas.service.IPacienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PacienteService implements IPacienteService {

    private final PacienteRepository pacienteRepository;


    @Autowired
    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    public PacienteDto registrarPaciente(Paciente paciente) {
        Paciente pacienteParaGuardar = pacienteRepository.save(paciente);
        PacienteDto pacienteConvertido = new PacienteDto(pacienteParaGuardar);
        LOGGER.info("🤩 Se guardó exitosamente tu paciente: {}", pacienteConvertido);
        return pacienteConvertido;
    }

    @Override
    public List<PacienteDto> listarPacientes() {
        List<PacienteDto> pacientes = pacienteRepository.findAll()
                .stream()
                .map(PacienteDto::new)
                .toList();
        LOGGER.info("🫡 Listando todos nuestros pacientes: {}", pacientes);
        return pacientes;
    }

    @Override
    public PacienteDto buscarPacientePorId(Long id) throws ResourceNotFoundException {
        Paciente pacienteEncontrado = pacienteRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("😬 No encontrado."));
        PacienteDto pacienteConvertido = new PacienteDto(pacienteEncontrado);
        LOGGER.info("🤩 Paciente encontrado: {}", pacienteConvertido);
        return pacienteConvertido;
    }


        @Override
        public PacienteDto actualizarPaciente(Paciente paciente) throws ResourceNotFoundException {
            PacienteDto pacienteActualizado;
            if (!pacienteRepository.existsById(paciente.getId())){
                LOGGER.warn("😬 No es posible actualizar el paciente.");
                throw new ResourceNotFoundException("🫤 El paciente no existe en la base de datos.");
            } else {
                pacienteActualizado = registrarPaciente(paciente);
                LOGGER.warn("🤩 Se ha actualizado al paciente con Id {}: {}", pacienteActualizado.getId(), pacienteActualizado);
            }
            return pacienteActualizado;
        }


    @Override
    public void eliminarPaciente(Long id) throws ResourceNotFoundException {
        if (pacienteRepository.existsById(id)) {
            pacienteRepository.deleteById(id);
            LOGGER.warn("🫡 Se ha eliminado el paciente.");
        } else {
            LOGGER.warn("😯 El paciente con id {}, no existe en la base de datos", id);
            throw new ResourceNotFoundException("😬 El paciente con id {}, no existe en la base de datos.");
        }
    }
}
