package co.edu.unicauca.asae.app_formats_a.infrastructure.input.ManageAFormatController.mappers;

import java.util.ArrayList;
import java.util.List;

import co.edu.unicauca.asae.app_formats_a.infrastructure.input.ManageAFormatController.DTO.response.HistoricalRecordDTOResponse;
import co.edu.unicauca.asae.app_formats_a.infrastructure.input.ManageAFormatController.DTO.response.RoleDTOResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import co.edu.unicauca.asae.app_formats_a.domain.models.Professor;
import co.edu.unicauca.asae.app_formats_a.infrastructure.input.ManageAFormatController.DTO.request.ProfessorDTORequest;
import co.edu.unicauca.asae.app_formats_a.infrastructure.input.ManageAFormatController.DTO.response.ProfessorDTOResponse;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProfessorInputMapper {

    @Mapping(target = "historicalRecord", ignore = true)
    @Mapping(target = "aFormats", ignore = true)
    Professor toDomain(ProfessorDTORequest professorDTORequest);

    ProfessorDTOResponse toResponse(Professor professor);

    List<Professor> toDomainList(List<ProfessorDTORequest> professorDTORequests);

    List<ProfessorDTOResponse> toResponseList(List<Professor> professors);


    default List<ProfessorDTOResponse> toResponseListWithHistoricalRecords(List<Professor> professors) {
        List<ProfessorDTOResponse> responses = new ArrayList<>();

        for (Professor professor : professors) {
            responses.add(
                    ProfessorDTOResponse.builder()
                            .id(professor.getId())
                            .name(professor.getName())
                            .lastName(professor.getLastName())
                            .groupName(professor.getGroupName())
                            .email(professor.getEmail())
                            .records(professor.getHistoricalRecord().stream()
                                    .map(record ->
                                            HistoricalRecordDTOResponse.builder()
                                                    .startDate(record.getStartDate())
                                                    .endDate(record.getEndDate())
                                                    .role(
                                                            new RoleDTOResponse(
                                                                    record.getRole().getAssignedRole()
                                                            )
                                                    )
                                                    .build()

                                    ).toList()
                            )
                            .build()
            );
        }

        return responses;
    }

}
