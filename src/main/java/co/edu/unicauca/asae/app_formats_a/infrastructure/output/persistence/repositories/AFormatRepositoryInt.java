package co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.entities.AFormatEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AFormatRepositoryInt extends JpaRepository<AFormatEntity, Long> {
    
    @Query(value = "SELECT COUNT(id) FROM a_formats WHERE title = :title", nativeQuery = true)
    public Long existsByTitle(@Param("title") String title);

    @Query("SELECT a FROM AFormatEntity a " +
            "JOIN a.objProfessor p " +  // Join con la entidad Professor
            "JOIN a.state s " +         // Join con la entidad State
            "WHERE (:title IS NULL OR :title = '' OR a.title LIKE :title) " +
            "AND s.registerStateDate BETWEEN :stateRegisterStateDateAfter AND :stateRegisterStateDateBefore " +
            "AND p.id = :objProfessorId")
    Optional<List<AFormatEntity>> findByTitleDatesAndProfessor(
            @Param("title") String title,
            @Param("stateRegisterStateDateAfter") LocalDate stateRegisterStateDateAfter,
            @Param("stateRegisterStateDateBefore") LocalDate stateRegisterStateDateBefore,
            @Param("objProfessorId") Long objProfessorId
    );
}
