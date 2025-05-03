package co.edu.unicauca.asae.app_formats_a.infrastructure.input.ManageAFormatController.DTO.request;


import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
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

    private String student2Name;

    @Pattern(regexp = "^1046\\d*$", message = "AFormat.studentCode.mustStartWith1046")
    private String student2code;
}
