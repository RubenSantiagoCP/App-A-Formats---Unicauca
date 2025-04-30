package co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.mappers;

import co.edu.unicauca.asae.app_formats_a.domain.models.HistoricalRecord;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.entities.HistoricalRecordEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses={ProfessorOutputMapper.class,RoleOutputMapper.class})
public interface HistoricalRecordOutputMapper {
    // Define mapping methods here if needed
    // For example, if you have a HistoricalRecordEntity and HistoricalRecord domain model
    // You can define methods like:

    @Mapping(target = "professor",qualifiedByName = "toDomainIgnoringRecordsAndFormats")
    @Mapping(target = "role", source ="objRole",qualifiedByName = "toDomainIgnoringHistoricalRecords")
    HistoricalRecord toDomain(HistoricalRecordEntity entity);
    HistoricalRecordEntity toEntity(HistoricalRecord domain);

    List<HistoricalRecordEntity> toEntityList(List<HistoricalRecord> domain);

    List<HistoricalRecord> toDomainList(List<HistoricalRecordEntity> entity);
}
