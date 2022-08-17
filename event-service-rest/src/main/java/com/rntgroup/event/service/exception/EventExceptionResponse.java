package com.rntgroup.event.service.exception;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Objects;

@Data
@Accessors(chain = true)
public class EventExceptionResponse {

    @Schema(description = "Время ошибки"    )
    private LocalDateTime timestamp;

    @Schema(description = "HTTP статус ошибки")
    private HttpStatus status;

    @Schema(description = "Сообщение ошибки")
    private String message;

    @Schema(description = "Причина ошибки")
    private String cause;

    @Schema(description = "Stack trace")
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
