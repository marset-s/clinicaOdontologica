package com.clinicaodontologica.DrMuelitas.service;

import com.clinicaodontologica.DrMuelitas.dto.PacienteDto;
import com.clinicaodontologica.DrMuelitas.entity.Paciente;
import com.clinicaodontologica.DrMuelitas.exception.BadRequestException;
import com.clinicaodontologica.DrMuelitas.exception.ResourceNotFoundException;

import java.util.List;

public interface IPacienteService {

    //C
    PacienteDto registrarPaciente(Paciente paciente);

    //R
    List<PacienteDto> listarPacientes();

    PacienteDto buscarPacientePorId(Long id) throws ResourceNotFoundException;

    //U
    PacienteDto actualizarPaciente(Paciente paciente) throws ResourceNotFoundException;

    //D
    void eliminarPaciente(Long id) throws ResourceNotFoundException;

}
