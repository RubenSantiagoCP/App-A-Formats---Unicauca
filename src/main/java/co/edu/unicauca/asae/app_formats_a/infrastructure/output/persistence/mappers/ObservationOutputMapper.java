package co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.mappers;


import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import co.edu.unicauca.asae.app_formats_a.domain.models.Observation;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.entities.ObservationEntity;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE , uses = {ProfessorWithoutObjectsMapper.class, EvaluationsWithoutRelations.class})
public interface ObservationOutputMapper {

    @Mapping(target = "professors", qualifiedByName = "mapProfessorWithoutRelations")
    @Mapping(target = "objEvaluation", qualifiedByName = "mapEvaluationsToDomainWithoutRelations")
    Observation toDomainCreate(ObservationEntity entity);

    @Mapping(target = "professors.historicalRecord", ignore = true)
    @Mapping(target = "professors.aFormats", ignore = true)
    @Mapping(target = "objEvaluation", ignore = true)
    ObservationEntity toEntity(Observation domain);

    @Named("mapLstObservations")
    default List<Observation> toDomainList(List<ObservationEntity> entities) {
        if (entities == null) return null;
        return entities.stream()
                .map(this::toDomainCreate)
                .toList();
    }
}
