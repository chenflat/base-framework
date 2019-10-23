package io.github.supercube.exception;

public class SourceException extends RuntimeException {
    public SourceException(String message) {
        super(message);
    }

    public SourceException(String message, Throwable cause) {
        super(message, cause);
    }
}
