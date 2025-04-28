package co.edu.unicauca.asae.app_formats_a.infrastructure.input.ManageAFormatController.DTO.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ObservationDTORequest {
    
    @Size(min = 3, max = 100, message = "observation.size")
    @NotBlank(message = "observation.required")
    private String observation;

    @Size(min = 1, max = 3, message = "observation.professors.size")
    @NotEmpty(message = "observation.professors.required")
    private List<Long> professorsId;
}
