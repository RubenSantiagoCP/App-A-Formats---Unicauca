package co.edu.unicauca.asae.app_formats_a.infrastructure.input.ManageAFormatController.validations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = ObjectiveStartsWithInfinitiveValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.TYPE_USE})
public @interface ObjectiveStartsWithInfinitiveInt {
    String message() default "objective.startsWith.infinitive";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
