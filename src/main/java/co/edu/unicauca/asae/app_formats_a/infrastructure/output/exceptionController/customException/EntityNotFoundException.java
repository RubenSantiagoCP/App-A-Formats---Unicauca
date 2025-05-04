package co.edu.unicauca.asae.app_formats_a.infrastructure.output.exceptionController.customException;

import co.edu.unicauca.asae.app_formats_a.infrastructure.output.exceptionController.exceptionStructure.ErrorCode;

public class EntityNotFoundException extends ManageAFormatsRuntimeException{

    private static final String FORMAT_EXCEPTION = "%s - Entity not found: %s";

    private final String entityNotFound;

    public EntityNotFoundException(final String entityNotFound){
        super(ErrorCode.ENTITY_NOT_FOUND);
        this.entityNotFound = entityNotFound;
    }


    @Override
    public String formatException() {
        return String.format(FORMAT_EXCEPTION, errorCode.getErrorCode(), entityNotFound);
    }
}
