package co.edu.unicauca.asae.app_formats_a.infrastructure.input.mappers;


import co.edu.unicauca.asae.app_formats_a.domain.models.AFormat;
import co.edu.unicauca.asae.app_formats_a.domain.models.PPAFormat;
import co.edu.unicauca.asae.app_formats_a.domain.models.TIAFormat;
import co.edu.unicauca.asae.app_formats_a.infrastructure.input.DTORequest.AFormatDTORequest;
import co.edu.unicauca.asae.app_formats_a.infrastructure.input.DTORequest.PPAFormatDTORequest;
import co.edu.unicauca.asae.app_formats_a.infrastructure.input.DTORequest.TIAFormatDTORequest;
import co.edu.unicauca.asae.app_formats_a.infrastructure.input.DTOResponse.AFormatDTOResponse;
import co.edu.unicauca.asae.app_formats_a.infrastructure.input.DTOResponse.PPAFormatDTOResponse;
import co.edu.unicauca.asae.app_formats_a.infrastructure.input.DTOResponse.TIAFormatDTOResponse;
import org.mapstruct.Mapper;
import org.mapstruct.SubclassMapping;

@Mapper(componentModel = "spring")
public interface AFormatInputMapper {
    @SubclassMapping(source = PPAFormatDTORequest.class, target = PPAFormat.class)
    @SubclassMapping(source = TIAFormatDTORequest.class, target = TIAFormat.class)
    AFormat toDomain(AFormatDTORequest aFormatDTORequest);

    @SubclassMapping(source = PPAFormat.class, target = PPAFormatDTOResponse.class)
    @SubclassMapping(source = TIAFormat.class, target = TIAFormatDTOResponse.class)
    AFormatDTOResponse toResponse(AFormat aFormat);

}
