package co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.mappers;

import org.mapstruct.Mapper;

import co.edu.unicauca.asae.app_formats_a.domain.models.AFormat;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.entities.AFormatEntity;

@Mapper(componentModel = "spring")
public interface AFormatMapper {
    
    AFormatEntity toEntity(AFormat aFormat);

    AFormat toModel(AFormatEntity aFormatEntity);
}
