package co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.mappers;

import co.edu.unicauca.asae.app_formats_a.domain.models.Professor;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.entities.ProfessorEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring", uses = {HistoricalRecordWithoutRelations.class, AFormatWithotRelations.class})
public interface ProfessorWithoutObjectsMapper {

    @Named("mapProfessorWithoutRelations")
    @Mapping(target = "historicalRecord", ignore = true)
    @Mapping(target = "aFormats", ignore = true)
    Professor toDomainWithoutRelations(ProfessorEntity professorEntity);

    default List<Professor> toListDomain(List<ProfessorEntity> entities){
        if(entities == null) return null;
        return entities.stream()
                .map(this::toDomainWithoutRelations)
                .toList();
    }
}
