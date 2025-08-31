package br.com.anderson17ads.brazilbank.domain.exception;

public abstract class DomainException extends RuntimeException {
    private final int status;

    public DomainException(String message, int status) {
        super(message);
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
