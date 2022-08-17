package com.rntgroup.event.service.exception;

public class NotFoundEventException extends EventException {

    public NotFoundEventException(String name, String value) {
        super(String.format("Event with '%s' = %s not found", name, value));
    }

}
