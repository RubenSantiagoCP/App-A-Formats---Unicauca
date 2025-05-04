package co.edu.unicauca.asae.app_formats_a.infrastructure.input.ManageAFormatController.mappers;


import co.edu.unicauca.asae.app_formats_a.domain.models.AFormat;
import co.edu.unicauca.asae.app_formats_a.domain.models.PPAFormat;
import co.edu.unicauca.asae.app_formats_a.domain.models.TIAFormat;
import co.edu.unicauca.asae.app_formats_a.infrastructure.input.ManageAFormatController.DTO.request.AFormatDTORequest;
import co.edu.unicauca.asae.app_formats_a.infrastructure.input.ManageAFormatController.DTO.request.PPAFormatDTORequest;
import co.edu.unicauca.asae.app_formats_a.infrastructure.input.ManageAFormatController.DTO.request.TIAFormatDTORequest;
import co.edu.unicauca.asae.app_formats_a.infrastructure.input.ManageAFormatController.DTO.response.AFormatDTOResponse;
import co.edu.unicauca.asae.app_formats_a.infrastructure.input.ManageAFormatController.DTO.response.AFormatWithoutRelationsDTOResponse;
import co.edu.unicauca.asae.app_formats_a.infrastructure.input.ManageAFormatController.DTO.response.PPAFormatDTOResponse;
import co.edu.unicauca.asae.app_formats_a.infrastructure.input.ManageAFormatController.DTO.response.TIAFormatDTOResponse;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.SubclassMapping;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AFormatInputMapper {
    @SubclassMapping(source = PPAFormatDTORequest.class, target = PPAFormat.class)
    @SubclassMapping(source = TIAFormatDTORequest.class, target = TIAFormat.class)
    AFormat toDomain(AFormatDTORequest aFormatDTORequest);

    @SubclassMapping(source = PPAFormat.class, target = PPAFormatDTOResponse.class)
    @SubclassMapping(source = TIAFormat.class, target = TIAFormatDTOResponse.class)
    AFormatDTOResponse toResponse(AFormat aFormat);


    default List<AFormatDTOResponse> lstAFormatsToResponse(List<AFormat> aFormats){
        if(aFormats==null) return  null;
        return aFormats.stream()
                .map(this::toResponse)
                .toList();
    }


}
