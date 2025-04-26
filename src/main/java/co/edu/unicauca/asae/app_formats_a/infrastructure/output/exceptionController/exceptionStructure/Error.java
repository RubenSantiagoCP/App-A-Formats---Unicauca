package co.edu.unicauca.asae.app_formats_a.infrastructure.output.exceptionController.exceptionStructure;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Error {
    
    private String errorCode;
    private String message;
    private Integer httpCode;
    private String url;
    private String method;
    
}
