package co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.mappers;

import co.edu.unicauca.asae.app_formats_a.domain.models.Professor;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.entities.ProfessorEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProfessorOutputMapper {
    // @Autowired
    // protected AFormatOutputMapper aFormatOutputMapper;

    // public abstract ProfessorEntity toEntity(Professor professor);

    // @Mapping(target = "aFormats", expression = "java(AFormatsToDomainIgnoringEvaluations(professorEntity.getAFormats()))")
    // public abstract Professor toDomain(ProfessorEntity professorEntity);

    // protected List<AFormat> AFormatsToDomainIgnoringEvaluations(List<AFormatEntity> aFormatEntities) {
    //     if (aFormatEntities == null) return null;
    //     return aFormatEntities.stream()
    //             .map(aFormatOutputMapper::toDomainIgnoringEvaluations) // ✅ no typo
    //             .collect(Collectors.toList());
    // }

    @Mapping(target = "historicalRecord", ignore = true) // Evita ciclo con HistoricalRecordEntity
    @Mapping(target = "aFormats", ignore = true) // Evita ciclo con AFormatEntity
    Professor toDomain(ProfessorEntity entity);

    @Mapping(target = "historicalRecord", ignore = true)
    @Mapping(target = "aFormats", ignore = true)
    ProfessorEntity toEntity(Professor domain);
}
