package co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import co.edu.unicauca.asae.app_formats_a.domain.models.Evaluation;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.entities.EvaluationEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EvaluationOutputMapper {
    
    @Mapping(target = "objAFormat", ignore = true)
    Evaluation toDomain(EvaluationEntity entity);


}
