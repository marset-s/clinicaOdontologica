package com.clinicaodontologica.DrMuelitas.service.impl;

import com.clinicaodontologica.DrMuelitas.dto.OdontologoDto;
import com.clinicaodontologica.DrMuelitas.entity.Odontologo;
import com.clinicaodontologica.DrMuelitas.repository.OdontologoRepository;
import com.clinicaodontologica.DrMuelitas.service.IOdontologoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class OdontologoService implements IOdontologoService {


    private final OdontologoRepository odontologoRepository;

    private final ObjectMapper mapper;

    @Autowired
    public OdontologoService(OdontologoRepository odontologoRepository, ObjectMapper mapper) {
        this.odontologoRepository = odontologoRepository;
        this.mapper = mapper;
    }

    @Override
    public OdontologoDto registrarOdontologo(Odontologo odontologo) {
        return null;
    }

    @Override
    public OdontologoDto buscarOdontologoPorId(Long id) {
        return null;
    }

    @Override
    public List<OdontologoDto> listarOdontologos() {
        return null;
    }

    @Override
    public OdontologoDto actualizarOdontologo(Odontologo odontologo) {
        return null;
    }

    @Override
    public void eliminarOdontologo(Long id) {

    }
}
