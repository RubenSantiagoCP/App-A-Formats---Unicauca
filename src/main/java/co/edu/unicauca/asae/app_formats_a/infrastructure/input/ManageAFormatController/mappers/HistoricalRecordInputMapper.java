package co.edu.unicauca.asae.app_formats_a.infrastructure.input.ManageAFormatController.mappers;

import co.edu.unicauca.asae.app_formats_a.domain.models.HistoricalRecord;
import co.edu.unicauca.asae.app_formats_a.infrastructure.input.ManageAFormatController.DTO.response.HistoricalRecordDTOResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HistoricalRecordInputMapper {

    HistoricalRecordDTOResponse toResponse(HistoricalRecord historicalRecord);
    List<HistoricalRecordDTOResponse> toResponseList(List<HistoricalRecord> historicalRecords);
}
