package ru.itpark.exception;

public class DataAccesException extends RuntimeException {
    public DataAccesException() {
        super();
    }

    public DataAccesException(String message) {
        super(message);
    }

    public DataAccesException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataAccesException(Throwable cause) {
        super(cause);
    }

    protected DataAccesException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
