package co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.mappers;

import co.edu.unicauca.asae.app_formats_a.domain.models.Role;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.entities.RoleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface RoleOutputMapper {
    @Named("toDomainIgnoringHistoricalRecords")
    @Mapping(target = "historicalRecords", ignore = true)
    Role toDomainIgnoringHistoricalRecords(RoleEntity roleEntity);
}
