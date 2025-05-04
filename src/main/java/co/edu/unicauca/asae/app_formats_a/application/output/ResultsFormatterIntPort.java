package co.edu.unicauca.asae.app_formats_a.application.output;

public interface ResultsFormatterIntPort {

    public void returnResponseErrorEntityNotFound(String message);
    public void returnResponseErrorEntityAlreadyExists(String message);
    public void returnResponseErrorBusinessRuleViolation(String message);

}
