package co.edu.unicauca.asae.app_formats_a.infrastructure.input.ManageAFormatController.DTO.request;

import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeName("PPA")
public class PPAFormatDTORequest extends AFormatDTORequest {
    
    @Size(min = 3, max = 100, message = "PPAformat.assesorName.size")
    @NotBlank(message = "PPAformat.assesorName.required")
    private String assesorName;

    @Size(min = 3, max = 100, message = "PPAformat.acceptanceLetterRoute.size")
    @NotBlank(message = "PPAformat.acceptanceLetterRoute.required")
    private String acceptanceLetterRoute;
}
