package co.edu.unicauca.asae.app_formats_a.infrastructure.input.ManageAFormatController.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import co.edu.unicauca.asae.app_formats_a.domain.models.Observation;
import co.edu.unicauca.asae.app_formats_a.domain.models.Professor;
import co.edu.unicauca.asae.app_formats_a.infrastructure.input.ManageAFormatController.DTO.request.ObservationDTORequest;
import co.edu.unicauca.asae.app_formats_a.infrastructure.input.ManageAFormatController.DTO.response.ObservationDTOResponse;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ObservationInputMapper {
    
    @Mapping(source = "professorsId", target = "professors")
    Observation toDomain(ObservationDTORequest observationDTORequest);

    @Mapping(source = "professors", target = "professorsId")
    ObservationDTOResponse toResponse(Observation observation);

    default List<Professor> mapIdsToProfessors(List<Long> ids) {
        if (ids == null) return null;
        return ids.stream()
                .map(id -> {
                    Professor p = new Professor();
                    p.setId(id);
                    return p;
                })
                .collect(Collectors.toList());
    }

    default List<Long> mapProfessorsToIds(List<Professor> professors) {
        if (professors == null) return null;
        return professors.stream()
                .map(professor -> professor.getId())
                .collect(Collectors.toList());
    }
}
