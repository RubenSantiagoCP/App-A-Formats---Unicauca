package co.edu.unicauca.asae.app_formats_a.infrastructure.output.exceptionController.customException;

import co.edu.unicauca.asae.app_formats_a.infrastructure.output.exceptionController.exceptionStructure.ErrorCode;

public class EntityAlreadyExistsException extends ManageAFormatsRuntimeException{

    private static final String FORMAT_EXCEPTION = "%s - Entity already exists: %s";

    private final String entityAlreadyExists;

    public EntityAlreadyExistsException(final  String entityAlreadyExists){
        super(ErrorCode.ENTITY_ALREADY_EXISTS);
        this.entityAlreadyExists = entityAlreadyExists;
    }

    @Override
    public String formatException() {
        return String.format(FORMAT_EXCEPTION, errorCode.getErrorCode(), entityAlreadyExists);
    }
}
