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
@JsonTypeName("TIA")
public class TIAFormatDTORequest extends AFormatDTORequest {

    @Size(min = 3, max = 100, message = "TIAformat.studentName.size")
    @NotBlank(message = "TIAformat.student1Name.required")
    private String student1Name;

    @Size(min = 3, max = 100, message = "TIAformat.student2Name.size")
    private String student2Name;
}
