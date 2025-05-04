package co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.mappers;

import co.edu.unicauca.asae.app_formats_a.domain.models.HistoricalRecord;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.entities.HistoricalRecordEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface HistoricalRecordWithoutRelations {

    @Mapping(target = "professor", ignore = true)
    @Mapping(target = "role", ignore = true)
    HistoricalRecord toDomain(HistoricalRecordEntity historicalRecordEntity);
}
