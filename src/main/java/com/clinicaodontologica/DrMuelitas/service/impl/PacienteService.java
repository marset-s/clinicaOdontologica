package com.clinicaodontologica.DrMuelitas.service.impl;


import com.clinicaodontologica.DrMuelitas.dto.PacienteDto;
import com.clinicaodontologica.DrMuelitas.entity.Paciente;
import com.clinicaodontologica.DrMuelitas.repository.PacienteRepository;
import com.clinicaodontologica.DrMuelitas.service.IPacienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PacienteService implements IPacienteService {

    private final PacienteRepository pacienteRepository;
    private final ObjectMapper mapper;

    @Autowired
    public PacienteService(PacienteRepository pacienteRepository, ObjectMapper mapper) {
        this.pacienteRepository = pacienteRepository;
        this.mapper = mapper;
    }

    @Override
    public PacienteDto registrarPaciente(Paciente paciente) {
        return null;
    }

    @Override
    public List<PacienteDto> listarPacientes() {
        return null;
    }

    @Override
    public PacienteDto buscarPacientePorId(Long id) {
        return null;
    }

    @Override
    public PacienteDto actualizarPaciente(Paciente paciente) {
        return null;
    }

    @Override
    public void eliminarPaciente(Long id) {

    }
}
