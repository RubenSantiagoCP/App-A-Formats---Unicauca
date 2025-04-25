package co.edu.unicauca.asae.app_formats_a.infrastructure.input.DTOResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PPAFormatDTOResponse extends AFormatDTOResponse {
    
    private String assesorName;

    private String studedt1Name;

    private String acceptanceLetterRoute;
}
