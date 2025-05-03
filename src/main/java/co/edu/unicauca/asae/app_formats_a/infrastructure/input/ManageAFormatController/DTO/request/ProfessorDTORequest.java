package co.edu.unicauca.asae.app_formats_a.infrastructure.input.ManageAFormatController.DTO.request;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfessorDTORequest {

    private Long id;

    @Size(min = 3, max = 100, message = "professor.name.size")
    @NotBlank(message = "professor.name.required")
    private String name;

    @Size(min = 3, max = 100, message = "professor.lastName.size")
    @NotBlank(message = "professor.lastName.required")
    private String lastName;

    @Size(min = 3, max = 100, message = "professor.groupName.size")
    @NotBlank(message = "professor.groupName.required")
    private String groupName;

    @NotBlank(message = "professor.email.required")
    @Email(message = "professor.email.invalid")
    private String email;
}
