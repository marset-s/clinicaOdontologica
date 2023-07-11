package com.clinicaodontologica.DrMuelitas.repository;

import com.clinicaodontologica.DrMuelitas.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

}
