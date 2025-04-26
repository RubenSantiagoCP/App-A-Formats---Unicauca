package co.edu.unicauca.asae.app_formats_a.infrastructure.output.exceptionController.exceptionStructure;


public class ErrorUtils {

    public static Error buildError(String errorCode, String message, Integer httpCode, String url, String method) {
        return Error.builder()
                .errorCode(errorCode.toString())
                .message(message)
                .httpCode(httpCode)
                .url(url)
                .method(method)
                .build();
    }
    
}
