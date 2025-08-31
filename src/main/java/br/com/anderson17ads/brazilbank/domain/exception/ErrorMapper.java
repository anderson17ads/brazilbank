package br.com.anderson17ads.brazilbank.domain.exception;

import org.springframework.http.HttpStatus;

public class ErrorMapper {
    public static ErrorResponse toResponse(DomainException e) {
        return new ErrorResponse(e.getStatus(), e.getMessage());
    }

    public static ErrorResponse toResponse(Exception e) {
        return new ErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Unexpected error: " + e.getMessage()
        );
    }
}
