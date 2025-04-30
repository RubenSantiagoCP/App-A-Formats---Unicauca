package co.edu.unicauca.asae.app_formats_a.infrastructure.input.ManageAFormatController.DTO.response;

import co.edu.unicauca.asae.app_formats_a.commons.enums.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleDTOResponse {
    private RoleEnum assignedRole;
}
