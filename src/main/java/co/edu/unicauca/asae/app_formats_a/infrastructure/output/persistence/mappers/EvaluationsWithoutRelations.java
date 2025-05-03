package co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.mappers;

import co.edu.unicauca.asae.app_formats_a.domain.models.Evaluation;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.entities.EvaluationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring", uses = {ObservationWithoutRelationsMapper.class})
public interface EvaluationsWithoutRelations {
    @Named("mapEvaluationsToDomainWithoutRelations")
    @Mapping(target = "objAFormat", ignore = true)
    Evaluation toDomain(EvaluationEntity entity);
}
