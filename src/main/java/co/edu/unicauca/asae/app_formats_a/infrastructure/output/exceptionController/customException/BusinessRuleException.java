package co.edu.unicauca.asae.app_formats_a.infrastructure.output.exceptionController.customException;

import co.edu.unicauca.asae.app_formats_a.infrastructure.output.exceptionController.exceptionStructure.ErrorCode;

public class BusinessRuleException extends ManageAFormatsRuntimeException{
    private static final String FORMAT_EXCEPTION = "%s - Business Rule violated: %s";

    private final String businessRule;

    public BusinessRuleException(final  String businessRule){
        super(ErrorCode.BUSINESS_RULE_VIOLATION);
        this.businessRule = businessRule;
    }

    @Override
    public String formatException() {
        return String.format(FORMAT_EXCEPTION, errorCode.getErrorCode(), businessRule);
    }
}