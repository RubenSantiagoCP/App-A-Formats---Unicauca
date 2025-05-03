package co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import co.edu.unicauca.asae.app_formats_a.domain.models.State;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.entities.StateEntity;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface StateOutputMapper {

    @Named("mapStateWithoutRelations")
    @Mapping(target = "objAformat", ignore = true)
    State toDomain(StateEntity stateEntity);

    
    @Mapping(target = "objAformat.objProfessor", ignore = true)
    @Mapping(target = "objAformat.state", ignore = true)
    @Mapping(target = "objAformat.evaluations", ignore = true)
    StateEntity toEntity(State state);
}
