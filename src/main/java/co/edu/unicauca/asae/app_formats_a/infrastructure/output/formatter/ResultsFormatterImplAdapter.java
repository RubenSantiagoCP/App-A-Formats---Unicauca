package co.edu.unicauca.asae.app_formats_a.infrastructure.output.formatter;

import co.edu.unicauca.asae.app_formats_a.application.output.ResultsFormatterIntPort;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.exceptionController.customException.BusinessRuleException;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.exceptionController.customException.EntityAlreadyExistsException;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.exceptionController.customException.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ResultsFormatterImplAdapter implements ResultsFormatterIntPort {

    @Override
    public void returnResponseErrorEntityNotFound(String message) {
        EntityNotFoundException objException = new EntityNotFoundException(message);
        throw  objException;
    }

    @Override
    public void returnResponseErrorEntityAlreadyExists(String message) {
        EntityAlreadyExistsException objException = new EntityAlreadyExistsException(message);
        throw  objException;
    }

    @Override
    public void returnResponseErrorBusinessRuleViolation(String message) {
        BusinessRuleException objException = new BusinessRuleException(message);
        throw  objException;
    }
}
