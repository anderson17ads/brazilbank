package br.com.anderson17ads.brazilbank.domain.exception;

import java.time.Instant;
import java.util.Collections;
import java.util.List;

public class ErrorResponse {
    private final Instant timestamp;
    private final int status;
    private final String message;
    private final List<ValidationError> errors;

    public ErrorResponse(int status, String message, List<ValidationError> errors) {
        this.timestamp = Instant.now();
        this.status = status;
        this.message = message;
        this.errors = errors;
    }

    public ErrorResponse(int status, String message) {
        this(status, message, Collections.emptyList());
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public List<ValidationError> getErrors() {
        return errors;
    }
}
