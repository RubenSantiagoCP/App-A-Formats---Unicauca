package co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.mappers;

import co.edu.unicauca.asae.app_formats_a.domain.models.Professor;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.entities.ProfessorEntity;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProfessorOutputMapper {
    @Mapping(target = "historicalRecord", ignore = true) 
    @Mapping(target = "aFormats", ignore = true)
    Professor toDomain(ProfessorEntity entity);

   
    ProfessorEntity toEntity(Professor domain);

    //List<Professor> toDomainList(List<ProfessorEntity> entities);

    List<ProfessorEntity> toEntityList(List<Professor> domainList);

    @Named("mapProfessors")
    default List<Professor> toDomainList(List<ProfessorEntity> entities) {
        if (entities == null) return null;
        return entities.stream()
                .map(this::toDomain)
                .toList();
    }

}
