package co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.mappers;

import co.edu.unicauca.asae.app_formats_a.domain.models.Observation;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.entities.ObservationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper(componentModel = "spring")
public interface ObservationWithoutRelationsMapper {

    @Mapping(target = "professors", ignore = true)
    @Mapping(target = "objEvaluation", ignore = true)
    Observation toMapObservationWithoutRelations(ObservationEntity observationEntity);

    default List<Observation> toListDomainObservationWithoutRelations(List<ObservationEntity> entityList){
        if(entityList==null) return  null;
        return entityList.stream()
                .map(this::toMapObservationWithoutRelations)
                .toList();
    }
}
