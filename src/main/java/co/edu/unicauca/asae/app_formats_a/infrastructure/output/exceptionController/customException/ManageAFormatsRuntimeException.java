package co.edu.unicauca.asae.app_formats_a.infrastructure.output.exceptionController.customException;

import co.edu.unicauca.asae.app_formats_a.infrastructure.output.exceptionController.exceptionStructure.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public abstract class ManageAFormatsRuntimeException extends RuntimeException {

    protected ErrorCode errorCode;

    public  abstract String formatException();
}
