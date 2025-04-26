package co.edu.unicauca.asae.app_formats_a.infrastructure.input.ManageAFormatController.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import co.edu.unicauca.asae.app_formats_a.domain.models.Professor;
import co.edu.unicauca.asae.app_formats_a.infrastructure.input.ManageAFormatController.DTO.request.ProfessorDTORequest;
import co.edu.unicauca.asae.app_formats_a.infrastructure.input.ManageAFormatController.DTO.response.ProfessorDTOResponse;

@Mapper(componentModel = "spring")
public interface ProfessorInputMapper {
    
    @Mapping(target = "historicalRecord", ignore = true)
    @Mapping(target = "aFormats", ignore = true)
    @Mapping(target = "id", ignore = true)
    Professor toDomain(ProfessorDTORequest professorDTORequest);

    ProfessorDTOResponse toResponse(Professor professor);
}
