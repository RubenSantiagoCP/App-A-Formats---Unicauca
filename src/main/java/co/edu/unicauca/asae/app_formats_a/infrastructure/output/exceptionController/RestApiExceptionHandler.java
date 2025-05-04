package co.edu.unicauca.asae.app_formats_a.infrastructure.output.exceptionController;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import co.edu.unicauca.asae.app_formats_a.infrastructure.output.exceptionController.customException.EntityAlreadyExistsException;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.exceptionController.customException.EntityNotFoundException;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.exceptionController.exceptionStructure.Error;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import co.edu.unicauca.asae.app_formats_a.infrastructure.output.exceptionController.exceptionStructure.ErrorCode;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.exceptionController.exceptionStructure.ErrorUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class RestApiExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> handleGenericException(final HttpServletRequest request, final Exception ex,
            final Locale locale) {
        final Error error = ErrorUtils.buildError(
                                ErrorCode.GENERIC_ERROR.getErrorCode(), 
                                ex.getMessage(),
                                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                                request.getRequestURL().toString(),
                                request.getMethod());

        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Error> handleGenericException(final HttpServletRequest req,
                                                        final EntityNotFoundException ex,
                                                        final Locale locale){
        final Error error = ErrorUtils.buildError(
                ErrorCode.ENTITY_NOT_FOUND.getErrorCode(),
                ex.formatException(),
                HttpStatus.NOT_FOUND.value(),
                req.getRequestURL().toString(),
                req.getMethod());

        return  new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EntityAlreadyExistsException.class)
    public ResponseEntity<Error> handleGenericException(final HttpServletRequest req,
                                                        final EntityAlreadyExistsException ex,
                                                        final Locale locale){
        final Error error = ErrorUtils.buildError(
                ErrorCode.ENTITY_ALREADY_EXISTS.getErrorCode(),
                ex.formatException(),
                HttpStatus.NOT_ACCEPTABLE.value(),
                req.getRequestURL().toString(),
                req.getMethod());

        return  new ResponseEntity<>(error, HttpStatus.NOT_ACCEPTABLE);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        System.out.println("Retornando respuesta con los errores identificados");
        Map<String, String> errores = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String campo = ((FieldError) error).getField();
            String mensajeDeError = error.getDefaultMessage();
            errores.put(campo, mensajeDeError);
        });

        return new ResponseEntity<Map<String, String>>(errores, HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
