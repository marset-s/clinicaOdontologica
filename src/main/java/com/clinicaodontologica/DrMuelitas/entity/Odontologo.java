package com.clinicaodontologica.DrMuelitas.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "ODONTOLOGOS")
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Getter
@Setter
public class Odontologo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(value = AccessLevel.NONE)
    private Long id;

    @Size(min = 2, max = 50, message = "🧐 El nombre debe contener entre 2 y 50 caracteres.")
    @NotBlank(message = "😬 El campo de nombre no puede estar vacío ni ser nulo.")
    @NonNull
    private String nombre;

    @Size(min = 2, max = 50, message = "🧐 El apellido debe contener entre 2 y 50 caracteres.")
    @NotBlank(message = "😬 El campo de apellido no puede estar vacío ni ser nulo.")
    @NonNull
    private String apellido;

    @Size(min = 8, max = 9, message = "🧐 La matrícula profesional debe contener entre 8 y 9 caracteres.")
    @NotBlank(message = "😬 El campo de la matrícula no puede estar vacío ni ser nulo.")
    @NonNull
    private String matricula;

    @OneToMany(mappedBy = "odontologo", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Turno> turnos;
}
