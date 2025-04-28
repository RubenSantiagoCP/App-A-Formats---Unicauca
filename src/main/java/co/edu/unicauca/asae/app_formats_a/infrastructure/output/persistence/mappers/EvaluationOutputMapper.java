package co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import co.edu.unicauca.asae.app_formats_a.domain.models.Evaluation;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.entities.EvaluationEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {ObservationOutputMapper.class})
public interface EvaluationOutputMapper {
    
    @Mapping(target = "observations", qualifiedByName = "mapLstObservations")
    @Mapping(target = "objAFormat", ignore = true)
    Evaluation toDomain(EvaluationEntity entity);

    @Named("mapListEvaluations")
    default List<Evaluation> toDomainList(List<EvaluationEntity> entities) {
        if (entities == null) return null;
        return entities.stream()
                .map(this::toDomain)
                .toList();
    }
}
