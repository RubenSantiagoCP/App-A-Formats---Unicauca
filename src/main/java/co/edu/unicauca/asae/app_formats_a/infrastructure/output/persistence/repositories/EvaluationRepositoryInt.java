package co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.entities.EvaluationEntity;

public interface EvaluationRepositoryInt extends JpaRepository<EvaluationEntity, Long> {

    @Query("SELECT evaluation FROM EvaluationEntity evaluation WHERE evaluation.objAFormat.id = :id ORDER BY evaluation.id DESC")
    public EvaluationEntity lastEvaluationByFormat(@Param("id") Long id);

}
