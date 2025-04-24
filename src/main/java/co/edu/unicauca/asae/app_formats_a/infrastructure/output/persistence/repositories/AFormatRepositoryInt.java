package co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.entities.AFormatEntity;

public interface AFormatRepositoryInt extends JpaRepository<AFormatEntity, Long> {
    
}
