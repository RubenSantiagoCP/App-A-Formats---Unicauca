package co.edu.unicauca.asae.app_formats_a.infrastructure.input.ManageAFormatController.validations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ProfessorDTOValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidProfessorDTO {
    String message() default "Invalid professor data";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
