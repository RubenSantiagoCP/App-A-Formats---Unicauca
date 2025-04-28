package co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.mappers;

import co.edu.unicauca.asae.app_formats_a.domain.models.HistoricalRecord;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.entities.HistoricalRecordEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface HistoricalRecordOutputMapper {
    // Define mapping methods here if needed
    // For example, if you have a HistoricalRecordEntity and HistoricalRecord domain model
    // You can define methods like:
    HistoricalRecord toDomain(HistoricalRecordEntity entity);

    HistoricalRecordEntity toEntity(HistoricalRecord domain);
}
