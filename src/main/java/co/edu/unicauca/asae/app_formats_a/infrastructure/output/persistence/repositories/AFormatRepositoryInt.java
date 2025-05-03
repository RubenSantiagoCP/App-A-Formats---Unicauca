package co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.entities.AFormatEntity;

public interface AFormatRepositoryInt extends JpaRepository<AFormatEntity, Long> {
    
    @Query(value = "SELECT COUNT(id) FROM a_formats WHERE title = :title", nativeQuery = true)
    public Long existsByTitle(@Param("title") String title);
}
