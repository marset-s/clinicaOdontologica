package com.clinicaodontologica.DrMuelitas.repository;

import com.clinicaodontologica.DrMuelitas.entity.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurnoRepository extends JpaRepository<Turno, Long> {

}
