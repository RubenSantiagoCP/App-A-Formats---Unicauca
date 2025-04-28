package co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.entities.ObservationEntity;

public interface ObservationRepositoryInt extends JpaRepository<ObservationEntity, Long> {
    
}
