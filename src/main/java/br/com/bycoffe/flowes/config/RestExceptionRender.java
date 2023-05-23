package br.com.bycoffe.flowes.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.bycoffe.flowes.exceptions.RestNotFoundException;
import br.com.bycoffe.flowes.exceptions.dto.RestMethodError;
import br.com.bycoffe.flowes.exceptions.dto.RestNotFoundError;
import br.com.bycoffe.flowes.exceptions.dto.RestValidationError;
import jakarta.validation.ConstraintViolationException;
import org.springframework.web.HttpRequestMethodNotSupportedException;

@RestControllerAdvice
public class RestExceptionRender {

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<List<RestValidationError>> ConstraintViolationExceptionHandler(ConstraintViolationException e) {

        List<RestValidationError> errors = new ArrayList<>();

        e.getConstraintViolations().forEach((v) -> {
            errors.add(new RestValidationError(v.getPropertyPath().toString(), v.getMessage()));
        });

        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<RestMethodError> HttpRequestMethodNotSupportedExceptionHadler(HttpRequestMethodNotSupportedException e) {
        var error = new RestMethodError(e.getMethod(), e.getMessage());
        return ResponseEntity.badRequest().body(error);
    }


    @ExceptionHandler(RestNotFoundException.class) 
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> RestNotFoundExceptionHandler(RestNotFoundException e) {
        var error = new RestNotFoundError(e.getMessage(), e.getStatus());
        return ResponseEntity.status(e.getStatus()).body(error);
    }
}
