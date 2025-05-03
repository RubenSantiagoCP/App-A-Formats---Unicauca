package co.edu.unicauca.asae.app_formats_a.infrastructure.output.exceptionController;

import java.util.Locale;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.exceptionController.exceptionStructure.Error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import co.edu.unicauca.asae.app_formats_a.infrastructure.output.exceptionController.exceptionStructure.ErrorCode;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.exceptionController.exceptionStructure.ErrorUtils;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class RestApiExceptionHandler {
    /*@ExceptionHandler(Exception.class)
    public ResponseEntity<Error> handleGenericException(final HttpServletRequest request, final Exception ex,
            final Locale locale) {
        final Error error = ErrorUtils.buildError(
                                ErrorCode.GENERIC_ERROR.getErrorCode(), 
                                ex.getMessage(),
                                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                                request.getRequestURL().toString(),
                                request.getMethod());

        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }*/
}
