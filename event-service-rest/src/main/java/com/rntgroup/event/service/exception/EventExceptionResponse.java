package com.rntgroup.event.service.exception;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Objects;

@Data
@Accessors(chain = true)
public class EventExceptionResponse {

    private LocalDateTime timestamp;
    private HttpStatus status;
    private String message;
    private String cause;
    private StackTraceElement[] stackTrace;

    public static EventExceptionResponse build(Exception exception, HttpStatus status) {
        return new EventExceptionResponse()
                .setTimestamp(LocalDateTime.now())
                .setStatus(status)
                .setMessage(exception.getMessage())
                .setCause(Objects.nonNull(exception.getCause())
                        ? exception.getCause().toString()
                        : null)
                .setStackTrace(exception.getStackTrace());
    }

}
