package co.edu.unicauca.asae.app_formats_a.infrastructure.input.ManageAFormatController.validations;

import co.edu.unicauca.asae.app_formats_a.infrastructure.input.ManageAFormatController.DTO.request.ProfessorDTORequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ProfessorDTOValidator implements ConstraintValidator<ValidProfessorDTO, ProfessorDTORequest> {

    @Override
    public boolean isValid(ProfessorDTORequest dto, ConstraintValidatorContext context) {
        if (dto == null) return true;

        boolean isValid = true;

        context.disableDefaultConstraintViolation();

        if (dto.getId() == null) {
            if (isBlank(dto.getName())) {
                context.buildConstraintViolationWithTemplate("{professor.name.required}")
                        .addPropertyNode("name").addConstraintViolation();
                isValid = false;
            }
            if (isBlank(dto.getLastName())) {
                context.buildConstraintViolationWithTemplate("{professor.lastName.required}")
                        .addPropertyNode("lastName").addConstraintViolation();
                isValid = false;
            }
            if (isBlank(dto.getGroupName())) {
                context.buildConstraintViolationWithTemplate("{professor.groupName.required}")
                        .addPropertyNode("groupName").addConstraintViolation();
                isValid = false;
            }
            if (isBlank(dto.getEmail())) {
                context.buildConstraintViolationWithTemplate("{professor.email.required}")
                        .addPropertyNode("email").addConstraintViolation();
                isValid = false;
            }
        }

        return isValid;
    }

    private boolean isBlank(String str) {
        return str == null || str.trim().isEmpty();
    }
}
