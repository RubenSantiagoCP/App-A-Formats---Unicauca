package co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.mappers;

import co.edu.unicauca.asae.app_formats_a.domain.models.*;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.entities.*;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {StateOutputMapper.class, ProfessorWithoutObjectsMapper.class, EvaluationsWithoutRelations.class})
public interface AFormatOutputMapperWithoutDependencies {



    @Named("toDomainCreate")
    @SubclassMapping(source = PPAFormatEntity.class, target = PPAFormat.class)
    @SubclassMapping(source = TIAFormatEntity.class, target = TIAFormat.class)
    @Mapping(target = "objProfessor", qualifiedByName = "mapProfessorWithoutRelations")
    @Mapping(target = "state", qualifiedByName = "mapStateWithoutRelations")
    @Mapping(target = "evaluations", ignore = true)
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
    @IterableMapping(qualifiedByName ="toDomainCreate" )
    List<AFormat> toDomainList(List<AFormatEntity> aFormatEntities);

}
