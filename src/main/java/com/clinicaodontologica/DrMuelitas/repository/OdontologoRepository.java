package com.clinicaodontologica.DrMuelitas.repository;

import com.clinicaodontologica.DrMuelitas.entity.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OdontologoRepository extends JpaRepository<Odontologo, Long> {

}
