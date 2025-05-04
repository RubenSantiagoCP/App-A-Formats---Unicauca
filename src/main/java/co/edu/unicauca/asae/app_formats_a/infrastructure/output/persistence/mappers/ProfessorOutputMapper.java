package co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.mappers;

import co.edu.unicauca.asae.app_formats_a.domain.models.HistoricalRecord;
import co.edu.unicauca.asae.app_formats_a.domain.models.Professor;
import co.edu.unicauca.asae.app_formats_a.domain.models.Role;
import co.edu.unicauca.asae.app_formats_a.infrastructure.input.ManageAFormatController.DTO.response.ProfessorDTOResponse;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.entities.HistoricalRecordEntity;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.entities.ProfessorEntity;

import java.util.ArrayList;
import java.util.List;

import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.entities.RoleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProfessorOutputMapper {

    @Named("toDomainIgnoringRecordsAndFormats")
    @Mapping(target = "historicalRecord", ignore = true)
    @Mapping(target = "aFormats", ignore = true)
    Professor toDomainIgnoringRecordsAndFormats(ProfessorEntity entity);

    ProfessorEntity toEntity(Professor domain);

    //List<Professor> toDomainList(List<ProfessorEntity> entities);

    List<ProfessorEntity> toEntityList(List<Professor> domainList);

    @Named("mapProfessors")
    default List<Professor> toDomainList(List<ProfessorEntity> entities) {
        if (entities == null) return null;
        return entities.stream()
                .map(this::toDomainIgnoringRecordsAndFormats)
                .toList();
    }


    default List<Professor> toDomainListWithRecords(List<ProfessorEntity> entities) {
        List<Professor> professors = new ArrayList<>();

        // Iterar por los profesores
        for(ProfessorEntity entity : entities) {

            List<HistoricalRecord> historicalRecords = new ArrayList<>();
            // Iterar por los registros históricos
            for(HistoricalRecordEntity recordEntity:entity.getHistoricalRecord()){
                //System.out.println(recordEntity.getObjRole().getAssignedRole());

                // Añadir cada registro histórico a la lista mapeado
                historicalRecords.add(
                        new HistoricalRecord(
                                recordEntity.getId(),
                                recordEntity.getActive(),
                                recordEntity.getStartDate(),
                                recordEntity.getEndDate(),
                                null,
                                new Role(
                                        recordEntity.getObjRole().getId(),
                                        recordEntity.getObjRole().getAssignedRole(),
                                        null
                                )

                        )
                );
            }
            // Crear un nuevo objeto Professor y añadirlo a la lista
            professors.add(
                    new Professor(
                            entity.getId(),
                            entity.getName(),
                            entity.getLastName(),
                            entity.getGroupName(),
                            entity.getEmail(),
                            historicalRecords,
                            null
                    )
            );
        }
        return professors;
    }


}
