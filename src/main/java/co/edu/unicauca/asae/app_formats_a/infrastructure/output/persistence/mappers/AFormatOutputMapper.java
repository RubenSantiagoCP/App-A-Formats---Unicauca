package co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.mappers;

import co.edu.unicauca.asae.app_formats_a.domain.models.PPAFormat;
import co.edu.unicauca.asae.app_formats_a.domain.models.TIAFormat;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.entities.PPAFormatEntity;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.entities.TIAFormatEntity;
import org.mapstruct.Mapper;

import co.edu.unicauca.asae.app_formats_a.domain.models.AFormat;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.entities.AFormatEntity;
import org.mapstruct.Mapping;
import org.mapstruct.SubclassMapping;

@Mapper(componentModel = "spring")
public interface AFormatOutputMapper {

    @SubclassMapping(source = PPAFormat.class, target = PPAFormatEntity.class)
    @SubclassMapping(source = TIAFormat.class, target = TIAFormatEntity.class)
    AFormatEntity toEntity(AFormat aFormat);

    @SubclassMapping(source = PPAFormatEntity.class, target = PPAFormat.class)
    @SubclassMapping(source = TIAFormatEntity.class, target = TIAFormat.class)
    AFormat toDomain(AFormatEntity aFormatEntity);

    @Mapping(target = "evaluations", ignore = true)
    AFormat toDomainIgnoringEvaluations(AFormatEntity aFormat);
}
