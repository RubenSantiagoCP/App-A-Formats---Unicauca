package co.edu.unicauca.asae.app_formats_a.infrastructure.output.exceptionController.exceptionStructure;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ErrorCode {
    GENERIC_ERROR("GC-001", "Generic error"),
    ENTITY_NOT_FOUND("GC-002", "Entity not found"),
    ENTITY_ALREADY_EXISTS("GC-003", "Entity already exists"),
    INVALID_REQUEST("GC-004", "Invalid request"),
    UNAUTHORIZED("GC-005", "Unauthorized"),
    BUSINESS_RULE_VIOLATION("GC-006", "Business rule violation");

    private final String errorCode;
    private final String message;
}
