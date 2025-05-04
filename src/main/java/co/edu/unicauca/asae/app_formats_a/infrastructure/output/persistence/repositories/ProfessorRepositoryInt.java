package co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.repositories;

import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.entities.AFormatEntity;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.entities.ProfessorEntity;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

@Component
public interface ProfessorRepositoryInt extends JpaRepository<ProfessorEntity, Long> {

    @Query("SELECT count(p)>0 FROM ProfessorEntity p WHERE p.email = :email")
    boolean existsByEmail(@Param("email") String email);

    List<ProfessorEntity> findByGroupNameAndLastNameStartingWithIgnoreCaseOrderByLastNameAsc(String groupName, String pattern);

    @Query("SELECT DISTINCT p FROM ProfessorEntity p " +
            "WHERE p.id = :professorId")
    Optional<ProfessorEntity> findProfessorWithFormatsAndEvaluationsById(@Param("professorId") Long professorId);

}
