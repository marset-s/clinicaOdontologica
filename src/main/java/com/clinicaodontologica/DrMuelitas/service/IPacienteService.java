package com.clinicaodontologica.DrMuelitas.service;

import com.clinicaodontologica.DrMuelitas.dto.PacienteDto;
import com.clinicaodontologica.DrMuelitas.entity.Paciente;

import java.util.List;

public interface IPacienteService {

    //C
    PacienteDto registrarPaciente(Paciente paciente);

    //R
    List<PacienteDto> listarPacientes();

    PacienteDto buscarPacientePorId(Long id);

    //U
    PacienteDto actualizarPaciente(Paciente paciente);

    //D
    void eliminarPaciente(Long id);

}
