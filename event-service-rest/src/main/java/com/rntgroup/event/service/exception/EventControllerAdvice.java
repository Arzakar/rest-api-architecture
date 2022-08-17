package com.rntgroup.event.service.exception;

import org.springframework.core.NestedRuntimeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.sql.SQLException;

@ControllerAdvice
public class EventControllerAdvice {

    @ExceptionHandler(NotFoundEventException.class)
    public ResponseEntity<EventExceptionResponse> handleException(NotFoundEventException exception) {
        var response = EventExceptionResponse.build(exception, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(response, response.getStatus());
    }

    @ExceptionHandler({
            HttpMessageNotReadableException.class,
            MethodArgumentTypeMismatchException.class
    })
    public ResponseEntity<EventExceptionResponse> handleException(NestedRuntimeException exception) {
        var response = EventExceptionResponse.build(exception, HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(response, response.getStatus());
    }

    @ExceptionHandler(SQLException.class)
    public ResponseEntity<EventExceptionResponse> handleException(SQLException exception) {
        var response = EventExceptionResponse.build(exception, HttpStatus.INTERNAL_SERVER_ERROR);

        return new ResponseEntity<>(response, response.getStatus());
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<EventExceptionResponse> handelException(RuntimeException exception) {
        var response = EventExceptionResponse.build(exception, HttpStatus.INTERNAL_SERVER_ERROR);

        return new ResponseEntity<>(response, response.getStatus());
    }
}
