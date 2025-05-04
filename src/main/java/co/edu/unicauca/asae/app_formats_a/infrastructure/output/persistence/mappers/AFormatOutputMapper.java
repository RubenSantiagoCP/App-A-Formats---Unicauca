package co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.mappers;

import co.edu.unicauca.asae.app_formats_a.domain.models.PPAFormat;
import co.edu.unicauca.asae.app_formats_a.domain.models.TIAFormat;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.entities.PPAFormatEntity;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.entities.TIAFormatEntity;

import org.mapstruct.*;

import co.edu.unicauca.asae.app_formats_a.domain.models.AFormat;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.entities.AFormatEntity;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = { StateOutputMapper.class, ProfessorWithoutObjectsMapper.class, EvaluationsWithoutRelations.class})
public interface AFormatOutputMapper {


    @Named("toDomainCreate")
    @SubclassMapping(source = PPAFormatEntity.class, target = PPAFormat.class)
    @SubclassMapping(source = TIAFormatEntity.class, target = TIAFormat.class)
    @Mapping(target = "objProfessor", qualifiedByName = "mapProfessorWithoutRelations")
    @Mapping(target = "state", qualifiedByName = "mapStateWithoutRelations")
    @Mapping(target = "evaluations", qualifiedByName = "mapEvaluationsToDomainWithoutRelations")
    AFormat toDomainCreate(AFormatEntity aFormatEntity);

    @SubclassMapping(source = PPAFormat.class, target = PPAFormatEntity.class)
    @SubclassMapping(source = TIAFormat.class, target = TIAFormatEntity.class)
    @Mapping(target = "objProfessor.historicalRecord", ignore = true)
    @Mapping(target = "objProfessor.aFormats", ignore = true)
    @Mapping(target = "state.objAformat", ignore = true)
    @Mapping(target = "evaluations.observations", ignore = true)
    @Mapping(target = "evaluations.objAFormat", ignore = true)
    AFormatEntity toEntity(AFormat aFormat);

    @Named("mapAFormatsListToDomain")
    default List<AFormat> toDomainList(List<AFormatEntity> aFormatEntities){
        if(aFormatEntities== null) return  null;
        return aFormatEntities.stream()
                .map(this::toDomainCreate)
                .toList();
    }

    @Named("toDomainIgnoringDependencies")
    @Mapping(target = "objProfessor", ignore = true)
    @Mapping(target = "evaluations", ignore = true)
    AFormat toDomainIgnoringDependencies(AFormatEntity aFormatEntity);

    @Named("toDomainListIgnoringDependencies")
    @IterableMapping(qualifiedByName = "toDomainIgnoringDependencies")
    List<AFormat> toDomainListIgnoringDependencies(List<AFormatEntity> aFormatEntities);



}
