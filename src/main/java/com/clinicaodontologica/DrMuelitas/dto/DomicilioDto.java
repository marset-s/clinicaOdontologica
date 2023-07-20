package com.clinicaodontologica.DrMuelitas.dto;


import com.clinicaodontologica.DrMuelitas.entity.Domicilio;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class DomicilioDto {

    private Long id;

    @Size(min = 2, max = 50, message = "🧐 El nombre de la calle debe contener entre 2 y 50 caracteres.")
    @NotBlank(message = "😬 El nombre de la calle no puede estar vacío ni ser nulo.")
    private String calle;

    private Integer numero;

    @Size(min = 2, max = 50, message = "🧐 El nombre de la localidad debe contener entre 2 y 50 caracteres.")
    @NotBlank(message = "😬 El nombre de la localidad no puede estar vacío ni ser nulo.")
    private String localidad;

    @Size(min = 2, max = 50, message = "🧐 El nombre del departamento debe contener entre 2 y 50 caracteres.")
    @NotBlank(message = "😬 El nombre del departamento no puede estar vacío ni ser nulo.")
    private String departamento;


    public DomicilioDto(Domicilio domicilio) {
        this.setId(domicilio.getId());
        this.setCalle(domicilio.getCalle());
        this.setNumero(domicilio.getNumero());
        this.setLocalidad(domicilio.getLocalidad());
        this.setDepartamento(domicilio.getDepartamento());
    }

}
