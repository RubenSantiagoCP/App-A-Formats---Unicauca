package co.edu.unicauca.asae.app_formats_a.infrastructure.input.ManageAFormatController.validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ObjectiveStartsWithInfinitiveValidator
        implements ConstraintValidator<ObjectiveStartsWithInfinitiveInt, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        String[] words = value.split(" ");
        String firstWord = words[0];
        if (firstWord.length() < 2) {
            return false;
        }

        String lastTwoLetters = firstWord.substring(firstWord.length() - 2);
        if (!lastTwoLetters.equals("ar") || !lastTwoLetters.equals("er") || !lastTwoLetters.equals("ir")) {
            return false;
        }
        return true;
    }

}
