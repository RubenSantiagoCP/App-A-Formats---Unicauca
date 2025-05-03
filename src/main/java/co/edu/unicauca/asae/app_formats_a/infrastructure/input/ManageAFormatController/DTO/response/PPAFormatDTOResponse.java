package co.edu.unicauca.asae.app_formats_a.infrastructure.input.ManageAFormatController.DTO.response;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@JsonTypeName("PPA")
public class PPAFormatDTOResponse extends AFormatDTOResponse {
    
    private String assesorName;

    private String acceptanceLetterRoute;
}
