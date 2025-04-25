package co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.mappers;

import co.edu.unicauca.asae.app_formats_a.domain.models.AFormat;
import co.edu.unicauca.asae.app_formats_a.domain.models.Professor;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.entities.AFormatEntity;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.entities.ProfessorEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = {AFormatOutputMapper.class})
public abstract class ProfessorOutputMapper {
    @Autowired
    protected AFormatOutputMapper aFormatOutputMapper;

    public abstract ProfessorEntity toEntity(Professor professor);

    @Mapping(target = "aFormats", expression = "java(AFormatsToDomainIgnoringEvaluations(professorEntity.getAFormats()))")
    public abstract Professor toDomain(ProfessorEntity professorEntity);

    protected List<AFormat> AFormatsToDomainIgnoringEvaluations(List<AFormatEntity> aFormatEntities) {
        if (aFormatEntities == null) return null;
        return aFormatEntities.stream()
                .map(aFormatOutputMapper::toDomainIgnoringEvaluations) // ✅ no typo
                .collect(Collectors.toList());
    }
}
