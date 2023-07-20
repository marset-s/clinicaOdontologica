package com.clinicaodontologica.DrMuelitas.service.impl;

import com.clinicaodontologica.DrMuelitas.dto.OdontologoDto;
import com.clinicaodontologica.DrMuelitas.entity.Odontologo;
import com.clinicaodontologica.DrMuelitas.exception.ResourceNotFoundException;
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


    @Autowired
    public OdontologoService(OdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }

    @Override
    public OdontologoDto registrarOdontologo(Odontologo odontologo) {
        Odontologo odontologoParaGuardar = odontologoRepository.save(odontologo);
        OdontologoDto odontologoConvertido =new OdontologoDto(odontologoParaGuardar);
        LOGGER.info("😉 Se guardó exitosamente tu odontólogo: {}", odontologoConvertido);
        return odontologoConvertido;
    }

    @Override
    public OdontologoDto buscarOdontologoPorId(Long id) throws ResourceNotFoundException {
        Odontologo odontologoEncontrado = odontologoRepository
                .findById(id).orElseThrow(() -> new ResourceNotFoundException("No encontrado"));
        OdontologoDto odontologoConvertido = new OdontologoDto(odontologoEncontrado);
        LOGGER.info("🤩 Odontólogo encontrado: {}", odontologoConvertido);
        return odontologoConvertido;
    }

    @Override
    public List<OdontologoDto> listarOdontologos() {
        List<OdontologoDto> odontologos = odontologoRepository.findAll()
                .stream()
                .map(OdontologoDto::new)
                .toList();
        LOGGER.info("😎 Listando todos nuestros odontólogos: {}", odontologos);
        return odontologos;
    }

    @Override
    public OdontologoDto actualizarOdontologo(Odontologo odontologo) throws ResourceNotFoundException {
        OdontologoDto odontologoActualizado;
        if(!odontologoRepository.existsById(odontologo.getId())){
            LOGGER.warn("😬 No es posible actualizar el odontólogo.");
            throw new ResourceNotFoundException("😯 El odontólogo no existe en la base de datos");
        }else {
            odontologoActualizado = registrarOdontologo(odontologo);
            LOGGER.warn("😯 Se ha actualizado al odontólogo con Id {}: {}", odontologoActualizado.getId(), odontologoActualizado);
        }
        return odontologoActualizado;
    }

    @Override
    public void eliminarOdontologo(Long id) throws ResourceNotFoundException {
        if (odontologoRepository.existsById(id)) {
            odontologoRepository.deleteById(id);
            LOGGER.warn("🫡 Se ha eliminado el odontólogo");
        } else {
            LOGGER.warn("😯 El odontólogo con id {}, no existe en la base de datos", id);
            throw new ResourceNotFoundException("😬 El odontólogo con id {}, no existe en la base de datos");

        }
    }

}
