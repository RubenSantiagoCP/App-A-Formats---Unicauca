package co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.mappers;

import co.edu.unicauca.asae.app_formats_a.domain.models.PPAFormat;
import co.edu.unicauca.asae.app_formats_a.domain.models.TIAFormat;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.entities.PPAFormatEntity;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.entities.TIAFormatEntity;

import org.mapstruct.Mapper;

import co.edu.unicauca.asae.app_formats_a.domain.models.AFormat;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.entities.AFormatEntity;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.SubclassMapping;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = { EvaluationOutputMapper.class,
        ProfessorOutputMapper.class })
public interface AFormatOutputMapper {

    @Named("toDomainCreate")
    @SubclassMapping(source = PPAFormatEntity.class, target = PPAFormat.class)
    @SubclassMapping(source = TIAFormatEntity.class, target = TIAFormat.class)
    @Mapping(target = "objProfessor", ignore = true)
    @Mapping(target = "state.objAformat", ignore = true)
    AFormat toDomainCreate(AFormatEntity aFormatEntity);

    @SubclassMapping(source = PPAFormat.class, target = PPAFormatEntity.class)
    @SubclassMapping(source = TIAFormat.class, target = TIAFormatEntity.class)
    @Mapping(target = "objProfessor.historicalRecord", ignore = true)
    @Mapping(target = "objProfessor.aFormats", ignore = true)
    @Mapping(target = "state.objAformat", ignore = true)
    @Mapping(target = "evaluations.observations", ignore = true)
    @Mapping(target = "evaluations.objAFormat", ignore = true)
    AFormatEntity toEntity(AFormat aFormat);

    // //@Named("toDomainList")
    // @SubclassMapping(source = PPAFormatEntity.class, target = PPAFormat.class)
    // @SubclassMapping(source = TIAFormatEntity.class, target = TIAFormat.class)
    // @Mapping(target = "objProfessor" , qualifiedByName = "mapProfessor")
    // @Mapping(target = "state.objAformat", ignore = true)
    // @Mapping(target = "evaluations", qualifiedByName = "mapListEvaluations")
    // AFormat toDomain(AFormatEntity aFormatEntity);

}
