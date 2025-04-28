package co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import co.edu.unicauca.asae.app_formats_a.domain.models.Observation;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.entities.ObservationEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ObservationOutputMapper {

    @Mapping(target = "professors", ignore = true)
    @Mapping(target = "objEvaluation.observations", ignore = true)
    @Mapping(target = "objEvaluation.objAFormat", ignore = true)
    Observation toDomain(ObservationEntity entity);

    @Mapping(target = "professors.historicalRecord", ignore = true)
    @Mapping(target = "professors.aFormats", ignore = true)
    @Mapping(target = "objEvaluation", ignore = true)
    ObservationEntity toEntity(Observation domain);
    
}
