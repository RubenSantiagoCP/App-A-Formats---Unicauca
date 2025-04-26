package co.edu.unicauca.asae.app_formats_a.infrastructure.input.ManageAFormatController.mappers;


import co.edu.unicauca.asae.app_formats_a.domain.models.AFormat;
import co.edu.unicauca.asae.app_formats_a.domain.models.PPAFormat;
import co.edu.unicauca.asae.app_formats_a.domain.models.TIAFormat;
import co.edu.unicauca.asae.app_formats_a.infrastructure.input.ManageAFormatController.DTO.request.AFormatDTORequest;
import co.edu.unicauca.asae.app_formats_a.infrastructure.input.ManageAFormatController.DTO.request.PPAFormatDTORequest;
import co.edu.unicauca.asae.app_formats_a.infrastructure.input.ManageAFormatController.DTO.request.TIAFormatDTORequest;
import co.edu.unicauca.asae.app_formats_a.infrastructure.input.ManageAFormatController.DTO.response.AFormatDTOResponse;
import co.edu.unicauca.asae.app_formats_a.infrastructure.input.ManageAFormatController.DTO.response.PPAFormatDTOResponse;
import co.edu.unicauca.asae.app_formats_a.infrastructure.input.ManageAFormatController.DTO.response.TIAFormatDTOResponse;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.SubclassMapping;

@Mapper(componentModel = "spring")
public interface AFormatInputMapper {
    @SubclassMapping(source = PPAFormatDTORequest.class, target = PPAFormat.class)
    @SubclassMapping(source = TIAFormatDTORequest.class, target = TIAFormat.class)
    @Mapping(target = "objProfessor.historicalRecord", ignore = true)
    @Mapping(target = "objProfessor.aFormats", ignore = true)
    @Mapping(target = "objProfessor.id", ignore = true)
    @Mapping(target = "state", ignore = true)
    @Mapping(target = "evaluations", ignore = true)
    @Mapping(target = "id", ignore = true)
    AFormat toDomain(AFormatDTORequest aFormatDTORequest);

    @SubclassMapping(source = PPAFormat.class, target = PPAFormatDTOResponse.class)
    @SubclassMapping(source = TIAFormat.class, target = TIAFormatDTOResponse.class)
    @Mapping(target = "state.objAformat", ignore = true)
    AFormatDTOResponse toResponse(AFormat aFormat);

}
