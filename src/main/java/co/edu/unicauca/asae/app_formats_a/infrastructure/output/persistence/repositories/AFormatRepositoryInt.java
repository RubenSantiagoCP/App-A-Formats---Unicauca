package co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.entities.AFormatEntity;

public interface AFormatRepositoryInt extends JpaRepository<AFormatEntity, Long> {
    
    @Query("SELECT COUNT(aFormat.id)>0 FROM AFormatEntity aFormat WHERE aFormat.title = :title")
    public boolean existsByTitle(@Param("title") String title);
}
