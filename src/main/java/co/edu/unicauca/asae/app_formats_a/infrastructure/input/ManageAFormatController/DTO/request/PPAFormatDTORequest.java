package co.edu.unicauca.asae.app_formats_a.infrastructure.input.ManageAFormatController.DTO.request;

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
public class PPAFormatDTORequest extends AFormatDTORequest {
    
    @Size(min = 3, max = 100, message = "PPAformat.assesorName.size")
    @NotBlank(message = "PPAformat.assesorName.required")
    private String assesorName;

    @Size(min = 3, max = 100, message = "PPAformat.studentName.size")
    @NotBlank(message = "PPAformat.studentName.required")
    private String studedt1Name;

    @Size(min = 3, max = 100, message = "PPAformat.acceptanceLetterRoute.size")
    @NotBlank(message = "PPAformat.acceptanceLetterRoute.required")
    private String acceptanceLetterRoute;
}
