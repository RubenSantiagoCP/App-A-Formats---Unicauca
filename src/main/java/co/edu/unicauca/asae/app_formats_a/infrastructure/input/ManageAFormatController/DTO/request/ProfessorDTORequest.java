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

    private String name;

    private String lastName;

    private String groupName;

    private String email;
}
