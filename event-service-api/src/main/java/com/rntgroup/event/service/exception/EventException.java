package com.rntgroup.event.service.exception;

public class EventException extends RuntimeException {

    protected EventException(String message) {
        super(message);
    }

    protected EventException(String message, Throwable cause) {
        super(message, cause);
    }

}
