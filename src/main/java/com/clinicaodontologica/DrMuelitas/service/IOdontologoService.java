package com.clinicaodontologica.DrMuelitas.service;

import com.clinicaodontologica.DrMuelitas.dto.OdontologoDto;
import com.clinicaodontologica.DrMuelitas.entity.Odontologo;
import com.clinicaodontologica.DrMuelitas.exception.ResourceNotFoundException;

import java.util.List;

public interface IOdontologoService {

    //C
    OdontologoDto registrarOdontologo(Odontologo odontologo);

    //R
    OdontologoDto buscarOdontologoPorId(Long id) throws ResourceNotFoundException;

    List<OdontologoDto> listarOdontologos();

    //U
    OdontologoDto actualizarOdontologo(Odontologo odontologo) throws ResourceNotFoundException;

    //D
    void eliminarOdontologo(Long id) throws ResourceNotFoundException;


}
