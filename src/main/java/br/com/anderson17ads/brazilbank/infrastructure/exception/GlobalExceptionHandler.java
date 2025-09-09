package br.com.anderson17ads.brazilbank.infrastructure.exception;

import br.com.anderson17ads.brazilbank.domain.exception.DomainException;
import br.com.anderson17ads.brazilbank.domain.exception.ErrorMapper;
import br.com.anderson17ads.brazilbank.domain.exception.ErrorResponse;
import br.com.anderson17ads.brazilbank.domain.exception.ValidationError;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Map<String, String> EXPECTED_TYPES = new HashMap<>();
    static {
        EXPECTED_TYPES.put("LocalDate", "format yyyy-MM-dd");
        EXPECTED_TYPES.put("BigDecimal", "numeric format (e.g., 100.50)");
        EXPECTED_TYPES.put("UUID", "valid UUID format (xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx)");
    }

    @ExceptionHandler(DomainException.class)
    public ResponseEntity<ErrorResponse> handleDomainException(DomainException e) {
        return ResponseEntity
                .status(e.getStatus())
                .body(ErrorMapper.toResponse(e));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException e) {
        List<ValidationError> errors = e.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(err -> new ValidationError(err.getField(), err.getDefaultMessage()))
                .collect(Collectors.toList());

        ErrorResponse response = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                "Validation failed",
                errors
        );

        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        Throwable cause = e.getCause();

        if (cause instanceof InvalidFormatException) {
            InvalidFormatException invalidFormat = (InvalidFormatException) cause;

            String message = buildInvalidFormatMessage(invalidFormat);

            ErrorResponse errorResponse = new ErrorResponse(
                    HttpStatus.BAD_REQUEST.value(),
                    message,
                    Collections.emptyList()
            );

            return ResponseEntity.badRequest().body(errorResponse);
        }

        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                "Malformed JSON request",
                Collections.emptyList()
        );

        return ResponseEntity.badRequest().body(errorResponse);
    }

    private static String buildInvalidFormatMessage(InvalidFormatException invalidFormat) {
        String fieldName = invalidFormat.getPath().isEmpty()
                ? "unknow"
                : invalidFormat.getPath().get(0).getFieldName();

        String targetType = invalidFormat.getTargetType() != null
                ? invalidFormat.getTargetType().getSimpleName()
                : "unknow";

        String expectedTargetType = EXPECTED_TYPES.getOrDefault(targetType, targetType);

        return String.format(
                "Invalid value for field '%s'. Expected type is %s.",
                fieldName,
                expectedTargetType
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception e) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .body(ErrorMapper.toResponse(e));
    }
}
