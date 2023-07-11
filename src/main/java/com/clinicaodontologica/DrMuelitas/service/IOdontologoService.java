package com.clinicaodontologica.DrMuelitas.service;

import com.clinicaodontologica.DrMuelitas.dto.OdontologoDto;
import com.clinicaodontologica.DrMuelitas.entity.Odontologo;

import java.util.List;

public interface IOdontologoService {

    //C
    OdontologoDto registrarOdontologo(Odontologo odontologo);

    //R
    OdontologoDto buscarOdontologoPorId(Long id);

    List<OdontologoDto> listarOdontologos();

    //U
    OdontologoDto actualizarOdontologo(Odontologo odontologo);

    //D
    void eliminarOdontologo(Long id);


}
