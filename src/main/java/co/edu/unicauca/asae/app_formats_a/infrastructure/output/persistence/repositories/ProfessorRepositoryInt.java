package co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.repositories;

import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.entities.ProfessorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

@Component
public interface ProfessorRepositoryInt extends JpaRepository<ProfessorEntity, Long> {

    @Query("SELECT p FROM ProfessorEntity p WHERE p.email=:email")
    ProfessorEntity findByEmail(@Param("email") String email);
}
