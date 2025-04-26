package co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.mappers;

import co.edu.unicauca.asae.app_formats_a.domain.models.PPAFormat;
import co.edu.unicauca.asae.app_formats_a.domain.models.TIAFormat;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.entities.PPAFormatEntity;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.entities.TIAFormatEntity;

import java.util.List;

import org.mapstruct.Mapper;

import co.edu.unicauca.asae.app_formats_a.domain.models.AFormat;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.entities.AFormatEntity;
import org.mapstruct.Mapping;
import org.mapstruct.SubclassMapping;

@Mapper(componentModel = "spring", uses = {ProfessorOutputMapper.class})
public interface AFormatOutputMapper {


    @SubclassMapping(source = PPAFormatEntity.class, target = PPAFormat.class)
    @SubclassMapping(source = TIAFormatEntity.class, target = TIAFormat.class)
    @Mapping(target = "objProfessor.historicalRecord", ignore = true)
    @Mapping(target = "objProfessor.aFormats", ignore = true)
    @Mapping(target = "state.objAformat.state", ignore = true)
    @Mapping(target = "state.objAformat.objProfessor", ignore = true)
    @Mapping(target = "state.objAformat.evaluations", ignore = true)
    AFormat toDomain(AFormatEntity aFormatEntity);

    @SubclassMapping(source = PPAFormat.class, target = PPAFormatEntity.class)
    @SubclassMapping(source = TIAFormat.class, target = TIAFormatEntity.class)
    @Mapping(target = "evaluations", ignore = true)
    @Mapping(target = "objProfessor.historicalRecord", ignore = true)
    @Mapping(target = "objProfessor.aFormats", ignore = true)
    @Mapping(target = "state.objAformat.state", ignore = true)
    @Mapping(target = "state.objAformat.objProfessor", ignore = true)
    @Mapping(target = "state.objAformat.evaluations", ignore = true)
    AFormatEntity toEntity(AFormat aFormat);

    default List<AFormat> toDomainList(List<AFormatEntity> entities) {
        return entities == null ? null : entities.stream().map(this::toDomain).toList();
    }

    default List<AFormatEntity> toEntityList(List<AFormat> domainList) {
        return domainList == null ? null : domainList.stream().map(this::toEntity).toList();
    }

}
