package co.edu.unicauca.asae.app_formats_a.infrastructure.input.ManageAFormatController.DTO.request;


import co.edu.unicauca.asae.app_formats_a.infrastructure.input.ManageAFormatController.validations.ValidProfessorDTO;
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
@ValidProfessorDTO
public class ProfessorDTORequest {

    private Long id;

    @Size(min = 3, max = 100, message = "{professor.name.size}")
    private String name;

    @Size(min = 3, max = 100, message = "{professor.lastName.size}")
    private String lastName;

    @Size(min = 3, max = 100, message = "{professor.groupName.size}")
    private String groupName;

    @Email(message = "{professor.email.invalid}")
    private String email;
}
